package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockDestructionPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundBlockDestructionPacket.class)
public interface IMixinClientboundBlockDestructionPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
