package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundBlockEntityDataPacket.class)
public interface IMixinIMixinClientboundBlockEntityDataPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
