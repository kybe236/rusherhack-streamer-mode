package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundTeleportEntityPacket.class)
public interface IMixinClientboundTeleportEntityPacket {
	@Accessor("x")
	@Mutable
	void setX(double x);

	@Accessor("z")
	@Mutable
	void setZ(double z);
}
