package org.kybe.streamermode.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundBlockUpdatePacket.class)
public interface IMixinClientboundBlockUpdatePacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
