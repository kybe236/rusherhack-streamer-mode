package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundEntityPositionSyncPacket;
import net.minecraft.world.entity.PositionMoveRotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundEntityPositionSyncPacket.class)
public interface IMixinClientboundEntityPositionSyncPacket {
	@Accessor("values")
	@Mutable
	void setValues(PositionMoveRotation values);
}
