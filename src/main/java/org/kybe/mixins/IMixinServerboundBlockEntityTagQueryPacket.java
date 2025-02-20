package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundBlockEntityTagQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundBlockEntityTagQueryPacket.class)
public interface IMixinServerboundBlockEntityTagQueryPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
