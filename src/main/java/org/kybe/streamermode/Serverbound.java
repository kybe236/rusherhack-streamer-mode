package org.kybe.streamermode;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.kybe.streamermode.mixins.*;
import org.kybe.streamermode.utils.CoordManager;
import org.rusherhack.client.api.accessors.packet.IMixinServerboundMovePlayerPacket;
import org.rusherhack.client.api.accessors.packet.IMixinServerboundMoveVehiclePacket;

public class Serverbound {
	public static void handle(CoordManager coordManager, Packet<?> packet) {
		switch (packet) {
			case ServerboundBlockEntityTagQueryPacket packet1 -> {
				serverboundBlockEntityTagQueryPacket(packet1, coordManager);
			}
			case ServerboundJigsawGeneratePacket packet1 -> {
				serverboundJigsawGeneratePacket(packet1, coordManager);
			}
			case ServerboundMovePlayerPacket packet1 -> {
				serverboundMovePlayerPacket(packet1, coordManager);
			}
			case ServerboundMoveVehiclePacket packet1 -> {
				serverboundMoveVehiclePacket(packet1, coordManager);
			}
			case ServerboundPickItemFromBlockPacket packet1 -> {
				serverboundPickItemFromBlockPacket(packet1, coordManager);
			}
			case ServerboundPlayerActionPacket packet1 -> {
				serverboundPlayerActionPacket(packet1, coordManager);
			}
			case ServerboundSetCommandBlockPacket packet1 -> {
				serverboundSetCommandBlockPacket(packet1, coordManager);
			}
			case ServerboundSetJigsawBlockPacket packet1 -> {
				serverboundSetJigsawBlockPacket(packet1, coordManager);
			}
			case ServerboundSetStructureBlockPacket packet1 -> {
				serverboundSetStructureBlockPacket(packet1, coordManager);
			}
			case ServerboundSignUpdatePacket packet1 -> {
				serverboundSignUpdatePacket(packet1, coordManager);
			}
			case ServerboundUseItemOnPacket packet1 -> {
				serverboundUseItemOnPacket(packet1, coordManager);
			}
			default -> {
			}
		}
	}

	public static void serverboundBlockEntityTagQueryPacket(ServerboundBlockEntityTagQueryPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundBlockEntityTagQueryPacket) packet).setPos(pos);
	}

	public static void serverboundJigsawGeneratePacket(ServerboundJigsawGeneratePacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundJigsawGeneratePacket) packet).setPos(pos);
	}

	public static void serverboundMovePlayerPacket(ServerboundMovePlayerPacket packet, CoordManager coordManager) {
		Vec3 pos = new Vec3(packet.getX(0), packet.getY(0), packet.getZ(0));
		pos = coordManager.prepareSendVec3(pos);
		((IMixinServerboundMovePlayerPacket) packet).setX(pos.x);
		((IMixinServerboundMovePlayerPacket) packet).setZ(pos.z);
	}

	public static void serverboundMoveVehiclePacket(ServerboundMoveVehiclePacket packet, CoordManager coordManager) {
		Vec3 pos = packet.position();
		pos = coordManager.prepareSendVec3(pos);
		((IMixinServerboundMoveVehiclePacket) (Object) packet).setPosition(pos);
	}

	public static void serverboundPickItemFromBlockPacket(ServerboundPickItemFromBlockPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.pos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundPickItemFromBlockPacket) (Object) packet).setPos(pos);
	}

	public static void serverboundPlayerActionPacket(ServerboundPlayerActionPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundPlayerActionPacket) packet).setPos(pos);
	}

	public static void serverboundSetCommandBlockPacket(ServerboundSetCommandBlockPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundSetCommandBlockPacket) packet).setPos(pos);
	}

	public static void serverboundSetJigsawBlockPacket(ServerboundSetJigsawBlockPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundSetJigsawBlockPacket) packet).setPos(pos);
	}

	public static void serverboundSetStructureBlockPacket(ServerboundSetStructureBlockPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundSetStructureBlockPacket) packet).setPos(pos);
	}

	public static void serverboundSignUpdatePacket(ServerboundSignUpdatePacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundSignUpdatePacket) packet).setPos(pos);
	}

	public static void serverboundUseItemOnPacket(ServerboundUseItemOnPacket packet, CoordManager coordManager) {
		BlockHitResult hitResult = packet.getHitResult();

		Vec3 pos = hitResult.getLocation();
		pos = coordManager.prepareSendVec3(pos);

		BlockPos blockPos = hitResult.getBlockPos();
		blockPos = coordManager.prepareSendBlockPos(blockPos);

		((IMixinHitResult) hitResult).setLocation(pos);
		((IMixinBlockHitResult) hitResult).setBlockPos(blockPos);
	}
}
