package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.world.entity.PositionMoveRotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundTeleportEntityPacket.class)
public interface IMixinClientboundTeleportEntityPacket {
	@Accessor("change")
	PositionMoveRotation getChange();

	@Accessor("change")
	@Mutable
	void setChange(PositionMoveRotation change);
}
