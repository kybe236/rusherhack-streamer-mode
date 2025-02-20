package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundSetChunkCacheCenterPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundSetChunkCacheCenterPacket.class)
public interface IMixinClientboundSetChunkCacheCenterPacket {
	@Accessor("x")
	int getX();

	@Accessor("x")
	@Mutable
	void setX(int x);

	@Accessor("z")
	int getZ();

	@Accessor("z")
	@Mutable
	void setZ(int z);


}
