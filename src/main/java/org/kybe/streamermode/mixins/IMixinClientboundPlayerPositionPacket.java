package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.world.entity.PositionMoveRotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundPlayerPositionPacket.class)
public interface IMixinClientboundPlayerPositionPacket {
	@Accessor("change")
	PositionMoveRotation getChange();

	@Accessor("change")
	@Mutable
	void setChange(PositionMoveRotation change);
}
