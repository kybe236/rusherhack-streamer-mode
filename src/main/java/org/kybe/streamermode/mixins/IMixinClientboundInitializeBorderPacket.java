package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundInitializeBorderPacket.class)
public interface IMixinClientboundInitializeBorderPacket {
	@Accessor("newCenterX")
	@Mutable
	void setNewCenterX(double newCenterX);

	@Accessor("newCenterZ")
	@Mutable
	void setNewCenterZ(double newCenterZ);
}
