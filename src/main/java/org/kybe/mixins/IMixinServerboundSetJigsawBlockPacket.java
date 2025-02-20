package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundSetJigsawBlockPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundSetJigsawBlockPacket.class)
public interface IMixinServerboundSetJigsawBlockPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
