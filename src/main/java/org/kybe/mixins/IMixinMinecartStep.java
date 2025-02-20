package org.kybe.mixins;

import net.minecraft.world.entity.vehicle.NewMinecartBehavior;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NewMinecartBehavior.MinecartStep.class)
public interface IMixinMinecartStep {
	@Accessor("position")
	@Mutable
	void setPosition(Vec3 position);
}
