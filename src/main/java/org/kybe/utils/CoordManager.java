package org.kybe.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;

public class CoordManager {
	private int x, z;

	public CoordManager(int x, int z) {
		this.x = (int) Math.floor(x / 16.0) * 16;
		this.z = (int) Math.floor(z / 16.0) * 16;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public ChunkPos prepareReceiveChunkPos(ChunkPos pos) {
		return new ChunkPos(
				prepareReceiveChunkX(pos.x),
				prepareReceiveChunkZ(pos.z)
		);
	}

	public int prepareReceiveChunkX(int chunkX) {
		return chunkX + (this.x >> 4);
	}

	public int prepareReceiveChunkZ(int chunkZ) {
		return chunkZ + (this.z >> 4);
	}

	public SectionPos prepareReceiveSectionPos(SectionPos sectionPos) {
		return sectionPos.offset((int) Math.floor(this.x / 16.0), 0, (int) Math.floor(this.z / 16.0));
	}

	// Adjust the block X position
	public int prepareReceiveX(int blockX) {
		return blockX + this.x;
	}

	// Adjust the block Z position
	public int prepareReceiveZ(int blockZ) {
		return blockZ + this.z;
	}

	// Adjust the block X position for double values (e.g., for vectors)
	public double prepareReceiveX(double blockX) {
		return blockX + this.x;
	}

	// Adjust the block Z position for double values (e.g., for vectors)
	public double prepareReceiveZ(double blockZ) {
		return blockZ + this.z;
	}

	// Adjust the block X position before sending
	public int prepareSendX(int blockX) {
		return blockX - this.x;
	}

	// Adjust the block Z position before sending
	public int prepareSendZ(int blockZ) {
		return blockZ - this.z;
	}

	// Prepare BlockPos for sending: adjust X and Z while keeping Y the same
	public BlockPos prepareSendBlockPos(BlockPos pos) {
		return new BlockPos(
				prepareSendX(pos.getX()),
				pos.getY(),
				prepareSendZ(pos.getZ())
		);
	}

	// Prepare BlockPos for receiving: adjust X and Z while keeping Y the same
	public BlockPos prepareReceiveBlockPos(BlockPos pos) {
		return new BlockPos(
				prepareReceiveX(pos.getX()),
				pos.getY(),
				prepareReceiveZ(pos.getZ())
		);
	}

	public Vec3 prepareSendVec3(Vec3 vec3) {
		return new Vec3(
				vec3.x - this.x,
				vec3.y,
				vec3.z - this.z
		);
	}

	// Prepare Vec3 for receiving: adjust X and Z (note: no truncation of doubles here)
	public Vec3 prepareReceiveVec3(Vec3 vec3) {
		return new Vec3(
				prepareReceiveX(vec3.x),  // No casting to int for better precision
				vec3.y,
				prepareReceiveZ(vec3.z)   // No casting to int for better precision
		);
	}

}
