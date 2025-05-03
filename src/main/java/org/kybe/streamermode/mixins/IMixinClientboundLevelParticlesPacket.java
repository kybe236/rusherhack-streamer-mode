package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundLevelParticlesPacket.class)
public interface IMixinClientboundLevelParticlesPacket {
	@Accessor("x")
	@Mutable
	void setX(double x);

	@Accessor("z")
	@Mutable
	void setZ(double z);
}
