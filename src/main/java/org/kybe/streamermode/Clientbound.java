package org.kybe.streamermode;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.vehicle.NewMinecartBehavior;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;
import org.kybe.streamermode.mixins.*;
import org.kybe.streamermode.utils.CoordManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.rusherhack.client.api.Globals.mc;

public class Clientbound {
	public static void handle(CoordManager manager, Packet<? super ClientGamePacketListener> packet) {
		switch (packet) {
			case ClientboundAddEntityPacket packet1 -> {
				clientboundAddEntityPacket(packet1, manager);
			}
			case ClientboundAddExperienceOrbPacket packet1 -> {
				clientboundAddExperienceOrbPacket(packet1, manager);
			}
			case ClientboundBlockDestructionPacket packet1 -> {
				clientboundBlockDestructionPacket(packet1, manager);
			}
			case ClientboundBlockEntityDataPacket packet1 -> {
				clientboundBlockEntityDataPacket(packet1, manager);
			}
			case ClientboundBlockEventPacket packet1 -> {
				clientboundBlockEventPacket(packet1, manager);
			}
			case ClientboundBlockUpdatePacket packet1 -> {
				clientboundBlockUpdatePacket(packet1, manager);
			}
			case ClientboundChunksBiomesPacket packet1 -> {
				clientboundChunksBiomesPacket(packet1, manager);
			}
			case ClientboundDamageEventPacket packet1 -> {
				clientboundDamageEventPacket(packet1, manager);
			}
			case ClientboundEntityPositionSyncPacket packet1 -> {
				clientboundEntityPositionSyncPacket(packet1, manager);
			}
			case ClientboundExplodePacket packet1 -> {
				clientboundExplodePacket(packet1, manager);
			}
			case ClientboundForgetLevelChunkPacket packet1 -> {
				clientboundForgetLevelChunkPacket(packet1, manager);
			}
			case ClientboundLevelChunkWithLightPacket packet1 -> {
				clientboundLevelChunkWithLightPacket(packet1, manager);
			}
			case ClientboundInitializeBorderPacket packet1 -> {
				clientboundInitializeBorderPacket(packet1, manager);
			}
			case ClientboundLevelEventPacket packet1 -> {
				clientboundLevelEventPacket(packet1, manager);
			}
			case ClientboundLevelParticlesPacket packet1 -> {
				clientboundLevelParticlesPacket(packet1, manager);
			}
			case ClientboundLightUpdatePacket packet1 -> {
				clientboundLightUpdatePacket(packet1, manager);
			}
			case ClientboundMoveEntityPacket packet1 -> {
				//clientboundMoveEntityPacket(packet1, manager);
			}
			case ClientboundMoveMinecartPacket packet1 -> {
				clientboundMoveMinecartPacket(packet1, manager);
			}
			case ClientboundMoveVehiclePacket packet1 -> {
				clientboundMoveVehiclePacket(packet1, manager);
			}
			case ClientboundOpenSignEditorPacket packet1 -> {
				clientboundOpenSignEditorPacket(packet1, manager);
			}
			case ClientboundPlayerLookAtPacket packet1 -> {
				clientboundPlayerLookAtPacket(packet1, manager);
			}
			case ClientboundPlayerPositionPacket packet1 -> {
				clientboundPlayerPositionPacket(packet1, manager);
			}
			case ClientboundSectionBlocksUpdatePacket packet1 -> {
				clientboundSectionBlocksUpdatePacket(packet1, manager);
			}
			case ClientboundSetBorderCenterPacket packet1 -> {
				clientboundSetBorderCenterPacket(packet1, manager);
			}
			case ClientboundSetChunkCacheCenterPacket packet1 -> {
				clientboundSetChunkCacheCenterPacket(packet1, manager);
			}
			case ClientboundSetDefaultSpawnPositionPacket packet1 -> {
				clientboundSetDefaultSpawnPositionPacket(packet1, manager);
			}
			case ClientboundSoundPacket packet1 -> {
				clientboundSoundPacket(packet1, manager);
			}
			case ClientboundTeleportEntityPacket packet1 -> {
				clientboundTeleportEntityPacket(packet1, manager);
			}

			default -> {
			}
		}
	}

	public static void clientboundAddEntityPacket(ClientboundAddEntityPacket packet, CoordManager coordManager) {
		Vec3 pos = new Vec3(packet.getX(), packet.getY(), packet.getZ());
		pos = coordManager.prepareReceiveVec3(pos);

		((IMixinClientboundAddEntityPacket) packet).setX(pos.x);
		((IMixinClientboundAddEntityPacket) packet).setZ(pos.z);
	}

	public static void clientboundAddExperienceOrbPacket(ClientboundAddExperienceOrbPacket packet, CoordManager coordManager) {
		Vec3 pos = new Vec3(packet.getX(), packet.getY(), packet.getZ());
		pos = coordManager.prepareReceiveVec3(pos);
		((IMixinClientboundAddExperienceOrbPacket) packet).setX(pos.x);
		((IMixinClientboundAddExperienceOrbPacket) packet).setZ(pos.z);
	}

	public static void clientboundBlockDestructionPacket(ClientboundBlockDestructionPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundBlockDestructionPacket) packet).setPos(pos);
	}

	public static void clientboundBlockEntityDataPacket(ClientboundBlockEntityDataPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundBlockEntityDataPacket) packet).setPos(pos);
	}

	public static void clientboundBlockEventPacket(ClientboundBlockEventPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundBlockEventPacket) packet).setPos(pos);
	}

	public static void clientboundBlockUpdatePacket(ClientboundBlockUpdatePacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundBlockUpdatePacket) packet).setPos(pos);
	}

	public static void clientboundChunksBiomesPacket(ClientboundChunksBiomesPacket packet, CoordManager coordManager) {
		List<ClientboundChunksBiomesPacket.ChunkBiomeData> biomes = packet.chunkBiomeData();
		List<ClientboundChunksBiomesPacket.ChunkBiomeData> newBiomes = new ArrayList<>();
		for (ClientboundChunksBiomesPacket.ChunkBiomeData biome : biomes) {
			ChunkPos pos = biome.pos();
			pos = coordManager.prepareReceiveChunkPos(pos);
			newBiomes.add(new ClientboundChunksBiomesPacket.ChunkBiomeData(pos, biome.buffer()));
		}
		((IMixinClientboundChunksBiomesPacket) (Object) packet).setChunkBiomeData(newBiomes);
	}

	public static void clientboundDamageEventPacket(ClientboundDamageEventPacket packet, CoordManager coordManager) {
		Optional<Vec3> pos = ((IMixinClientboundDamageEventPacket) (Object) packet).getSourcePosition();
		if (pos.isPresent()) {
			Vec3 vec3 = pos.get();
			vec3 = coordManager.prepareReceiveVec3(vec3);
			((IMixinClientboundDamageEventPacket) (Object) packet).setSourcePosition(Optional.of(vec3));
		}
	}

	public static void clientboundEntityPositionSyncPacket(ClientboundEntityPositionSyncPacket packet, CoordManager coordManager) {
		PositionMoveRotation values = packet.values();
		Vec3 pos = values.position();
		pos = coordManager.prepareReceiveVec3(pos);
		values = new PositionMoveRotation(pos, values.deltaMovement(), values.yRot(), values.xRot());
		((IMixinClientboundEntityPositionSyncPacket) (Object) packet).setValues(values);
	}

	public static void clientboundExplodePacket(ClientboundExplodePacket packet, CoordManager coordManager) {
		Vec3 pos = packet.center();
		pos = coordManager.prepareReceiveVec3(pos);
		((IMixinClientboundExplodePacket) (Object) packet).setCenter(pos);
	}

	public static void clientboundForgetLevelChunkPacket(ClientboundForgetLevelChunkPacket packet, CoordManager coordManager) {
		ChunkPos pos = packet.pos();
		pos = coordManager.prepareReceiveChunkPos(pos);
		((IMixinClientboundForgetLevelChunkPacket) (Object) packet).setPos(pos);
	}

	public static void clientboundLevelChunkWithLightPacket(ClientboundLevelChunkWithLightPacket packet, CoordManager coordManager) {
		int x = packet.getX();
		int z = packet.getZ();
		x = coordManager.prepareReceiveChunkX(x);
		z = coordManager.prepareReceiveChunkZ(z);
		((IMixinClientboundLevelChunkWithLightPacket) packet).setX(x);
		((IMixinClientboundLevelChunkWithLightPacket) packet).setZ(z);
	}


	public static void clientboundInitializeBorderPacket(ClientboundInitializeBorderPacket packet, CoordManager coordManager) {
		double x = packet.getNewCenterX();
		double z = packet.getNewCenterZ();
		x = coordManager.prepareReceiveX(x);
		z = coordManager.prepareReceiveZ(z);
		((IMixinClientboundInitializeBorderPacket) packet).setNewCenterX(x);
		((IMixinClientboundInitializeBorderPacket) packet).setNewCenterZ(z);
	}

	public static void clientboundLevelEventPacket(ClientboundLevelEventPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundLevelEventPacket) packet).setPos(pos);
	}

	public static void clientboundLevelParticlesPacket(ClientboundLevelParticlesPacket packet, CoordManager coordManager) {
		Vec3 pos = new Vec3(packet.getX(), packet.getY(), packet.getZ());
		pos = coordManager.prepareReceiveVec3(pos);
		((IMixinClientboundLevelParticlesPacket) packet).setX(pos.x);
		((IMixinClientboundLevelParticlesPacket) packet).setZ(pos.z);
	}

	public static void clientboundLightUpdatePacket(ClientboundLightUpdatePacket packet, CoordManager coordManager) {
		int x = packet.getX();
		int z = packet.getZ();
		x = coordManager.prepareReceiveChunkX(x);
		z = coordManager.prepareReceiveChunkZ(z);
		((IMixinClientboundLightUpdatePacket) packet).setX(x);
		((IMixinClientboundLightUpdatePacket) packet).setZ(z);
	}

	//TODO: ClientboundMoveEntityPacket
	public static void clientboundMoveEntityPacket(ClientboundMoveEntityPacket packet, CoordManager coordManager) {
		Vec3 delta = new Vec3(packet.getXa(), packet.getYa(), packet.getZa());
		delta = coordManager.prepareReceiveVec3(delta);
		((IMixinClientboundMoveEntityPacket) packet).setXa((short) delta.x);
		((IMixinClientboundMoveEntityPacket) packet).setZa((short) delta.z);
	}


	public static void clientboundMoveMinecartPacket(ClientboundMoveMinecartPacket packet, CoordManager coordManager) {
		List<NewMinecartBehavior.MinecartStep> steps = packet.lerpSteps();
		for (NewMinecartBehavior.MinecartStep step : steps) {
			Vec3 pos = step.position();
			pos = coordManager.prepareReceiveVec3(pos);
			((IMixinMinecartStep) (Object) step).setPosition(pos);
		}
		((IMixinClientboundMoveMinecartPacket) (Object) packet).setLerpSteps(steps);
	}

	public static void clientboundMoveVehiclePacket(ClientboundMoveVehiclePacket packet, CoordManager coordManager) {
		Vec3 pos = packet.position();
		pos = coordManager.prepareReceiveVec3(pos);
		((IMixinClientboundMoveVehiclePacket) (Object) packet).setPosition(pos);
	}

	public static void clientboundOpenSignEditorPacket(ClientboundOpenSignEditorPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundOpenSignEditorPacket) packet).setPos(pos);
	}

	public static void clientboundPlayerLookAtPacket(ClientboundPlayerLookAtPacket packet, CoordManager coordManager) {
		Vec3 pos = packet.getPosition(mc.level);
		if (pos == null) return;
		pos = coordManager.prepareReceiveVec3(pos);
		((IMixinClientboundPlayerLookAtPacket) packet).setX(pos.x);
		((IMixinClientboundPlayerLookAtPacket) packet).setZ(pos.z);
	}

	public static void clientboundPlayerPositionPacket(ClientboundPlayerPositionPacket packet, CoordManager coordManager) {
		PositionMoveRotation change = ((IMixinClientboundPlayerPositionPacket) (Object) packet).getChange();
		double x = change.position().x;
		double z = change.position().z;
		x = coordManager.prepareReceiveX(x);
		z = coordManager.prepareReceiveZ(z);

		((IMixinPositionMoveRotation) (Object) change).setPosition(new Vec3(x, change.position().y, z));
		((IMixinClientboundPlayerPositionPacket) (Object) packet).setChange(change);
	}

	public static void clientboundSectionBlocksUpdatePacket(ClientboundSectionBlocksUpdatePacket packet, CoordManager coordManager) {
		SectionPos pos = ((IMixinClientboundSectionBlocksUpdatePacket) packet).getSectionPos();
		pos = coordManager.prepareReceiveSectionPos(pos);
		((IMixinClientboundSectionBlocksUpdatePacket) packet).setSectionPos(pos);
	}

	public static void clientboundSetBorderCenterPacket(ClientboundSetBorderCenterPacket packet, CoordManager coordManager) {
		double x = packet.getNewCenterX();
		double z = packet.getNewCenterZ();
		x = coordManager.prepareReceiveX(x);
		z = coordManager.prepareReceiveZ(z);
		((IMixinClientboundSetBorderCenterPacket) packet).setNewCenterX(x);
		((IMixinClientboundSetBorderCenterPacket) packet).setNewCenterZ(z);
	}

	public static void clientboundSetChunkCacheCenterPacket(ClientboundSetChunkCacheCenterPacket packet, CoordManager coordManager) {
		int x = packet.getX();
		int z = packet.getZ();
		x = coordManager.prepareReceiveChunkX(x);
		z = coordManager.prepareReceiveChunkZ(z);
		((IMixinClientboundSetChunkCacheCenterPacket) packet).setX(x);
		((IMixinClientboundSetChunkCacheCenterPacket) packet).setZ(z);
	}

	public static void clientboundSetDefaultSpawnPositionPacket(ClientboundSetDefaultSpawnPositionPacket packet, CoordManager coordManager) {
		BlockPos pos = packet.getPos();
		pos = coordManager.prepareReceiveBlockPos(pos);
		((IMixinClientboundSetDefaultSpawnPositionPacket) packet).setPos(pos);
	}

	public static void clientboundSoundPacket(ClientboundSoundPacket packet, CoordManager coordManager) {
		int x = ((IMixinClientboundSoundPacket) packet).getX() / 8;
		int z = ((IMixinClientboundSoundPacket) packet).getZ() / 8;
		x = coordManager.prepareReceiveX(x);
		z = coordManager.prepareReceiveZ(z);
		((IMixinClientboundSoundPacket) packet).setX(x * 8);
		((IMixinClientboundSoundPacket) packet).setZ(z * 8);
	}

	public static void clientboundTeleportEntityPacket(ClientboundTeleportEntityPacket packet, CoordManager coordManager) {
		PositionMoveRotation change = ((IMixinClientboundTeleportEntityPacket) (Object) packet).getChange();
		double x = change.position().x;
		double z = change.position().z;
		x = coordManager.prepareReceiveX(x);
		z = coordManager.prepareReceiveZ(z);
		((IMixinPositionMoveRotation) (Object) packet).setPosition(new Vec3(x, change.position().y, z));
	}
}