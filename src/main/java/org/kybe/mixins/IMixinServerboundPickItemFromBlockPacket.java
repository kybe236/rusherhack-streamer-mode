package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundPickItemFromBlockPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundPickItemFromBlockPacket.class)
public interface IMixinServerboundPickItemFromBlockPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
