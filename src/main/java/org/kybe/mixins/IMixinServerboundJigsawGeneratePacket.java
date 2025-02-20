package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundJigsawGeneratePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundJigsawGeneratePacket.class)
public interface IMixinServerboundJigsawGeneratePacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
