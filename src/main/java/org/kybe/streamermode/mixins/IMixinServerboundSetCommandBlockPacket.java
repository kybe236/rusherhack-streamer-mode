package org.kybe.streamermode.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundSetCommandBlockPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundSetCommandBlockPacket.class)
public interface IMixinServerboundSetCommandBlockPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
