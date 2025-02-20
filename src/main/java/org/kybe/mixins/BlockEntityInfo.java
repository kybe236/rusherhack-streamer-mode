package org.kybe.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "net.minecraft.network.protocol.game.ClientboundLevelChunkPacketData$BlockEntityInfo")
public interface BlockEntityInfo {
	@Accessor("packedXZ")
	int getPackedXZ();

	@Accessor("packedXZ")
	@Mutable
	void setPackedXZ(int packedXZ);
}
