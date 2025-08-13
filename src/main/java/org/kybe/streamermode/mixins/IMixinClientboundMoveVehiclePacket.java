package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundMoveVehiclePacket;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundMoveVehiclePacket.class)
public interface IMixinClientboundMoveVehiclePacket {
    @Accessor("position")
    @Mutable
    void setPosition(Vec3 position);
}
