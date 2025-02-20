package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundSignUpdatePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundSignUpdatePacket.class)
public interface IMixinServerboundSignUpdatePacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
