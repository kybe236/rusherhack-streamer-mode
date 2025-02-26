package org.kybe;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import org.kybe.utils.CoordManager;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.setting.BooleanSetting;
import org.rusherhack.core.setting.EnumSetting;
import org.rusherhack.core.setting.NullSetting;
import org.rusherhack.core.setting.NumberSetting;


public class StreamerModeModule extends ToggleableModule {
	public static StreamerModeModule INSTANCE;
	public BooleanSetting hideCoordinates = new BooleanSetting("Hide Coordinates", false);
	public EnumSetting<OffsetMode> offsetMode = new EnumSetting<>("Offset Mode", OffsetMode.STATIC_OFFSET);
	public EnumSetting<OffsetRandom> offsetRandom = new EnumSetting<>("Offset Random", OffsetRandom.NOT);
	public NullSetting hidden = new NullSetting("WARNING! Under this is X and Z offset which can be used too get your coordinates!!!!", "WARNING! Under this is X and Z offset which can be used too get your coordinates!!!!");
	public NumberSetting<Integer> xOffset = new NumberSetting<>("X Offset", 0, -30000000, 30000000);
	public NumberSetting<Integer> zOffset = new NumberSetting<>("Z Offset", 0, -30000000, 30000000);

	public BooleanSetting turnBedrockIntoStoneOrNetherrack = new BooleanSetting("Turn Bedrock into Stone/Netherack", false);

	public BooleanSetting hideSignText = new BooleanSetting("Hide Sign Text", false);
	public BooleanSetting hideMapContents = new BooleanSetting("Hide Map Contents", false);

	CoordManager coordManager = null;
	public StreamerModeModule() {
		super("Streamer Mode", "Provides Utilities for streamers like offsetting your coordinates.", ModuleCategory.CLIENT);
		INSTANCE = this;

		hidden.addSubSettings(
				xOffset,
				zOffset
		);

		hideCoordinates.addSubSettings(
				offsetMode,
				offsetRandom,
				hidden
		);

		this.registerSettings(
				hideCoordinates,
				turnBedrockIntoStoneOrNetherrack,
				hideSignText,
				hideMapContents
		);
	}

	@Override
	public void onDisable() {
		coordManager = null;
	}

	public void disconnect() {
		coordManager = null;
	}

	public void packetReceived(Packet<?> packet) {
		if (!this.isToggled() || !this.hideCoordinates.getValue()) {
			this.coordManager = null;
			return;
		}
		if (this.coordManager == null && this.offsetMode.getValue() == OffsetMode.STATIC_OFFSET) {
			if (this.offsetRandom.getValue() == OffsetRandom.NOT) {
				this.coordManager = new CoordManager(xOffset.getValue(), zOffset.getValue());
			} else if (this.offsetRandom.getValue() == OffsetRandom.EVERY_JOIN) {
				int x = (int) (Math.random() * 30000000);
				int z = (int) (Math.random() * 30000000);
				this.xOffset.setValue(x);
				this.zOffset.setValue(z);
				this.coordManager = new CoordManager(x, z);
			}
		}
		if (packet instanceof ClientboundBundlePacket packet1) {
			for (Packet<? super ClientGamePacketListener> p : packet1.subPackets()) {
				if (this.coordManager == null && this.offsetMode.getValue() == OffsetMode.CENTERED_OFFSET_ON_JOIN && p instanceof ClientboundPlayerPositionPacket packet2) {
					if (this.offsetRandom.getValue() == OffsetRandom.NOT) {
						this.coordManager = new CoordManager((int) -(packet2.getX()) + xOffset.getValue(), (int) -(packet2.getZ()) + zOffset.getValue());
					} else if (this.offsetRandom.getValue() == OffsetRandom.EVERY_JOIN) {
						int x = (int) (Math.random() * 30000000);
						int z = (int) (Math.random() * 30000000);
						this.xOffset.setValue(x);
						this.zOffset.setValue(z);
						this.coordManager = new CoordManager(x + (int) -(packet2.getX()), z + (int) -(packet2.getZ()));
					}
				}
				if (this.coordManager == null) {
					return;
				}
				Clientbound.handle(coordManager, p);
			}
			return;
		}
		if (this.coordManager == null && this.offsetMode.getValue() == OffsetMode.CENTERED_OFFSET_ON_JOIN && packet instanceof ClientboundPlayerPositionPacket packet2) {
			if (this.offsetRandom.getValue() == OffsetRandom.NOT) {
				this.coordManager = new CoordManager((int) -(packet2.getX()) + xOffset.getValue(), (int) -(packet2.getZ()) + zOffset.getValue());
			} else if (this.offsetRandom.getValue() == OffsetRandom.EVERY_JOIN) {
				int x = (int) (Math.random() * 30000000);
				int z = (int) (Math.random() * 30000000);
				this.xOffset.setValue(x);
				this.zOffset.setValue(z);
				this.coordManager = new CoordManager(x + (int) -(packet2.getX()), z + (int) -(packet2.getZ()));
			}
		}
		if (coordManager == null) {
			return;
		}
		Clientbound.handle(coordManager, (Packet<? super ClientGamePacketListener>) packet);

	}

	public void packetSend(Packet<?> packet) {
		if (!this.isToggled() || !this.hideCoordinates.getValue()) {
			this.coordManager = null;
			return;
		}
		if (this.coordManager == null) return;
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
