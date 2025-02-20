package org.kybe.mixins;

import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PositionMoveRotation.class)
public interface IMixinPositionMoveRotation {
	@Accessor("position")
	@Mutable
	void setPosition(Vec3 position);
}
