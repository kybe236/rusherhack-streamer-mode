package org.kybe.streamermode.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;

/**
 * Utility for offsetting Minecraft coordinates by a fixed chunk-aligned X/Z offset.
 * Supports both "send" (subtract offset) and "receive" (add offset) transformations.
 */
public class CoordManager {
	private int x; // chunk-aligned X offset in blocks
	private int z; // chunk-aligned Z offset in blocks

	public CoordManager(int x, int z) {
		// Align to nearest lower chunk boundary (multiple of 16)
		this.x = x & ~15;
		this.z = z & ~15;
	}

	public int getX() { return x; }
	public void setX(int x) { this.x = x & ~15; }

	public int getZ() { return z; }
	public void setZ(int z) { this.z = z & ~15; }

	/* ===================== CHUNK POS ===================== */

	public ChunkPos prepareReceiveChunkPos(ChunkPos pos) {
		return new ChunkPos(prepareReceiveChunkX(pos.x), prepareReceiveChunkZ(pos.z));
	}

	public int prepareReceiveChunkX(int chunkX) {
		return chunkX + (this.x >> 4);
	}

	public int prepareReceiveChunkZ(int chunkZ) {
		return chunkZ + (this.z >> 4);
	}

	/* ===================== SECTION POS ===================== */

	public SectionPos prepareReceiveSectionPos(SectionPos sectionPos) {
		return sectionPos.offset(this.x >> 4, 0, this.z >> 4);
	}

	/* ===================== BLOCK X/Z (int) ===================== */

	public int prepareReceiveX(int blockX) { return blockX + this.x; }
	public int prepareReceiveZ(int blockZ) { return blockZ + this.z; }

	public int prepareSendX(int blockX) { return blockX - this.x; }
	public int prepareSendZ(int blockZ) { return blockZ - this.z; }

	/* ===================== BLOCK X/Z (double) ===================== */

	public double prepareReceiveX(double blockX) { return blockX + this.x; }
	public double prepareReceiveZ(double blockZ) { return blockZ + this.z; }

	public double prepareSendX(double blockX) { return blockX - this.x; }
	public double prepareSendZ(double blockZ) { return blockZ - this.z; }

	/* ===================== BLOCK POS ===================== */

	public BlockPos prepareSendBlockPos(BlockPos pos) {
		return new BlockPos(prepareSendX(pos.getX()), pos.getY(), prepareSendZ(pos.getZ()));
	}

	public BlockPos prepareReceiveBlockPos(BlockPos pos) {
		return new BlockPos(prepareReceiveX(pos.getX()), pos.getY(), prepareReceiveZ(pos.getZ()));
	}

	/* ===================== VEC3 ===================== */

	public Vec3 prepareSendVec3(Vec3 vec3) {
		return new Vec3(prepareSendX(vec3.x), vec3.y, prepareSendZ(vec3.z));
	}

	public Vec3 prepareReceiveVec3(Vec3 vec3) {
		return new Vec3(prepareReceiveX(vec3.x), vec3.y, prepareReceiveZ(vec3.z));
	}
}