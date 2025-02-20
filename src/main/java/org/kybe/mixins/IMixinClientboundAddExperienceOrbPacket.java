package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundAddExperienceOrbPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundAddExperienceOrbPacket.class)
public interface IMixinClientboundAddExperienceOrbPacket {
	@Accessor("x")
	@Mutable
	void setX(double x);

	@Accessor("x")
	@Mutable
	void setY(double y);

	@Accessor("x")
	@Mutable
	void setZ(double z);
}
