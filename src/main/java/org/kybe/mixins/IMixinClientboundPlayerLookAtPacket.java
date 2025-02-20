package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundPlayerLookAtPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundPlayerLookAtPacket.class)
public interface IMixinClientboundPlayerLookAtPacket {
	@Accessor("x")
	@Mutable
	void setX(double x);

	@Accessor("z")
	@Mutable
	void setZ(double z);
}
