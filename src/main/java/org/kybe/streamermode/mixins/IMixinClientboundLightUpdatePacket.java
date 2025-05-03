package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundLightUpdatePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundLightUpdatePacket.class)
public interface IMixinClientboundLightUpdatePacket {
	@Accessor("x")
	@Mutable
	void setX(int x);

	@Accessor("z")
	@Mutable
	void setZ(int z);
}
