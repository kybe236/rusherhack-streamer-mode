package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundMoveVehiclePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundMoveVehiclePacket.class)
public interface IMixinClientboundMoveVehiclePacket {
	@Accessor("x")
	@Mutable
	void setX(double x);

	@Accessor("z")
	@Mutable
	void setZ(double z);
}
