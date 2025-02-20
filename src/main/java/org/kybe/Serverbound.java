package org.kybe;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.kybe.mixins.*;
import org.kybe.utils.CoordManager;
import org.rusherhack.client.api.accessors.packet.IMixinServerboundMovePlayerPacket;
import org.rusherhack.client.api.accessors.packet.IMixinServerboundMoveVehiclePacket;

public class Serverbound {
	public static void handle(CoordManager coordManager, Packet<?> packet) {
		if (packet instanceof ServerboundBlockEntityTagQueryPacket packet1) {
			serverboundBlockEntityTagQueryPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundJigsawGeneratePacket packet1) {
			serverboundJigsawGeneratePacket(packet1, coordManager);
		} else if (packet instanceof ServerboundMovePlayerPacket.Pos packet1) {
			serverboundMovePlayerPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundMovePlayerPacket.PosRot packet1) {
			serverboundMovePlayerPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundMoveVehiclePacket packet1) {
			serverboundMoveVehiclePacket(packet1, coordManager);
		} else if (packet instanceof ServerboundSetCommandBlockPacket packet1) {
			serverboundSetCommandBlockPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundSetJigsawBlockPacket packet1) {
			serverboundSetJigsawBlockPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundSetStructureBlockPacket packet1) {
			serverboundSetStructureBlockPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundSignUpdatePacket packet1) {
			serverboundSignUpdatePacket(packet1, coordManager);
		} else if (packet instanceof ServerboundUseItemOnPacket packet1) {
			serverboundUseItemOnPacket(packet1, coordManager);
		} else if (packet instanceof ServerboundPlayerActionPacket packet1) {
			serverboundPlayerActionPacket(packet1, coordManager);
		}
	}

	public static void serverboundPlayerActionPacket(ServerboundPlayerActionPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareSendBlockPos(pos);
		((IMixinServerboundPlayerActionPacket) packet).setPos(pos);
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
		double x = packet.getX();
		double z = packet.getZ();
		x = coordManager.prepareSendX(x);
		z = coordManager.prepareSendZ(z);
		((IMixinServerboundMoveVehiclePacket) packet).setX(x);
		((IMixinServerboundMoveVehiclePacket) packet).setZ(z);

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
