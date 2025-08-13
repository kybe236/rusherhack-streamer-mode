package org.kybe.streamermode;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import org.kybe.streamermode.utils.CoordManager;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.setting.BooleanSetting;
import org.rusherhack.core.setting.EnumSetting;
import org.rusherhack.core.setting.NullSetting;
import org.rusherhack.core.setting.NumberSetting;

import java.util.concurrent.ThreadLocalRandom;

public class StreamerModeModule extends ToggleableModule {
	public static StreamerModeModule INSTANCE;

	public final BooleanSetting hideCoordinates = new BooleanSetting("Hide Coordinates", false);
	public final EnumSetting<OffsetMode> offsetMode = new EnumSetting<>("Offset Mode", OffsetMode.STATIC_OFFSET);
	public final EnumSetting<OffsetRandom> offsetRandom = new EnumSetting<>("Offset Random", OffsetRandom.NOT);
	public final NullSetting hidden = new NullSetting(
			"WARNING! Under this is X and Z offset which can be used too get your coordinates!!!!",
			"WARNING! Under this is X and Z offset which can be used too get your coordinates!!!!"
	);
	public final NumberSetting<Integer> xOffset = new NumberSetting<>("X Offset", 0, -30000000, 30000000);
	public final NumberSetting<Integer> zOffset = new NumberSetting<>("Z Offset", 0, -30000000, 30000000);

	public final BooleanSetting turnBedrockIntoStoneOrNetherrack = new BooleanSetting("Turn Bedrock into Stone/Netherack", false);
	public final BooleanSetting hideSignText = new BooleanSetting("Hide Sign Text", false);
	public final BooleanSetting hideMap = new BooleanSetting("Hide Map Contents", false);

	public final BooleanSetting ignoreFirstPosition = new BooleanSetting("Ignore First Player Position Packet", true);
	boolean firstPositionSkipped = false;

	public CoordManager coordManager = null;

	public StreamerModeModule() {
		super("Streamer Mode", "Provides Utilities for streamers like offsetting your coordinates.", ModuleCategory.CLIENT);
		INSTANCE = this;

		hidden.addSubSettings(xOffset, zOffset);
		hideCoordinates.addSubSettings(offsetMode, offsetRandom, hidden);

		this.registerSettings(
				hideCoordinates,
				turnBedrockIntoStoneOrNetherrack,
				hideSignText,
				hideMap,
				ignoreFirstPosition
		);
	}

	@Override
	public void onDisable() {
		coordManager = null;
	}

	public void disconnect() {
		coordManager = null;
		firstPositionSkipped = false;
	}

	private void initCoordManager(ClientboundPlayerPositionPacket packet) {
		int baseX = xOffset.getValue();
		int baseZ = zOffset.getValue();

		if (offsetRandom.getValue() == OffsetRandom.EVERY_JOIN) {
			baseX = ThreadLocalRandom.current().nextInt(-30000000, 30000001);
			baseZ = ThreadLocalRandom.current().nextInt(-30000000, 30000001);
			xOffset.setValue(baseX);
			zOffset.setValue(baseZ);
		}

		if (offsetMode.getValue() == OffsetMode.STATIC_OFFSET) {
			coordManager = new CoordManager(baseX, baseZ);
		} else if (offsetMode.getValue() == OffsetMode.CENTERED_OFFSET_ON_JOIN && packet != null) {
			double realX = packet.change().position().x;
			double realZ = packet.change().position().z;
			int offsetX = baseX - (int) realX;
			int offsetZ = baseZ - (int) realZ;
			coordManager = new CoordManager(offsetX, offsetZ);
		}
	}

	public void packetReceived(Packet<?> packet) {
		if (!this.isToggled()) {
			coordManager = null;
			return;
		}

		if (ignoreFirstPosition.getValue() && packet instanceof ClientboundPlayerPositionPacket && !firstPositionSkipped) {
			firstPositionSkipped = true;
			return;
		}

		if (coordManager == null && offsetMode.getValue() == OffsetMode.STATIC_OFFSET) {
			initCoordManager(null);
		}

		if (packet instanceof ClientboundBundlePacket bundle) {
			if (coordManager == null && offsetMode.getValue() == OffsetMode.CENTERED_OFFSET_ON_JOIN) {
				for (Packet<?> sub : bundle.subPackets()) {
					if (ignoreFirstPosition.getValue() && sub instanceof ClientboundPlayerPositionPacket && !firstPositionSkipped) {
						firstPositionSkipped = true;
						continue;
					}
					if (sub instanceof ClientboundPlayerPositionPacket posPacket) {
						initCoordManager(posPacket);
						break;
					}
				}
			}

			if (coordManager == null) return;

			for (Packet<? super ClientGamePacketListener> sub : bundle.subPackets()) {
				Clientbound.handle(coordManager, sub);
			}
			return;
		}

		if (coordManager == null && offsetMode.getValue() == OffsetMode.CENTERED_OFFSET_ON_JOIN
				&& packet instanceof ClientboundPlayerPositionPacket posPacket) {
			initCoordManager(posPacket);
		}

		if (coordManager == null) return;
		Clientbound.handle(coordManager, (Packet<? super ClientGamePacketListener>) packet);
	}

	public void packetSend(Packet<?> packet) {
		if (!this.isToggled() || coordManager == null) return;
		Serverbound.handle(coordManager, packet);
	}

	public enum OffsetMode {
		STATIC_OFFSET,
		CENTERED_OFFSET_ON_JOIN,
	}

	public enum OffsetRandom {
		NOT,
		EVERY_JOIN
	}
}