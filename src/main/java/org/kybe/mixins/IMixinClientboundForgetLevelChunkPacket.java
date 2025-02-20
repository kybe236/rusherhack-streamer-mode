package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import net.minecraft.world.level.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundForgetLevelChunkPacket.class)
public interface IMixinClientboundForgetLevelChunkPacket {
	@Accessor("pos")
	@Mutable
	void setPos(ChunkPos pos);
}
