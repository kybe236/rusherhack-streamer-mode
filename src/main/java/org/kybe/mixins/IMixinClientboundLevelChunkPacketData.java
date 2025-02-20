package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundLevelChunkPacketData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ClientboundLevelChunkPacketData.class)
public interface IMixinClientboundLevelChunkPacketData {
	@Accessor("blockEntitiesData")
	List<?> getBlockEntitiesData();

	@Accessor("blockEntitiesData")
	@Mutable
	void setBlockEntitiesData(List<?> blockEntitiesData);
}

