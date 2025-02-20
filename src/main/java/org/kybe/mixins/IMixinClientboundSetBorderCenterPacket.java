package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundSetBorderCenterPacket.class)
public interface IMixinClientboundSetBorderCenterPacket {
	@Accessor("newCenterX")
	@Mutable
	void setNewCenterX(double newCenterX);

	@Accessor("newCenterZ")
	@Mutable
	void setNewCenterZ(double newCenterZ);
}
