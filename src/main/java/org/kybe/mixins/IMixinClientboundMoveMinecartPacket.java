package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundMoveMinecartPacket;
import net.minecraft.world.entity.vehicle.NewMinecartBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ClientboundMoveMinecartPacket.class)
public interface IMixinClientboundMoveMinecartPacket {
	@Accessor("lerpSteps")
	@Mutable
	void setLerpSteps(List<NewMinecartBehavior.MinecartStep> lerpSteps);
}
