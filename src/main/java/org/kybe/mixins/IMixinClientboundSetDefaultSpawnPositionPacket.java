package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundSetDefaultSpawnPositionPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundSetDefaultSpawnPositionPacket.class)
public interface IMixinClientboundSetDefaultSpawnPositionPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
