package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundLevelChunkWithLightPacket.class)
public interface IMixinClientboundLevelChunkWithLightPacket {
	@Accessor("x")
	@Mutable
	void setX(int x);

	@Accessor("z")
	@Mutable
	void setZ(int z);
}
