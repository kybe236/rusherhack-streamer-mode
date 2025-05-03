package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundChunksBiomesPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ClientboundChunksBiomesPacket.class)
public interface IMixinClientboundChunksBiomesPacket {
	@Accessor("chunkBiomeData")
	@Mutable
	void setChunkBiomeData(List<ClientboundChunksBiomesPacket.ChunkBiomeData> chunkBiomeData);
}
