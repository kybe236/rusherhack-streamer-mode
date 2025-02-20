package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockHitResult.class)
public interface IMixinBlockHitResult {
	@Accessor("blockPos")
	@Mutable
	void setBlockPos(BlockPos blockPos);
}
