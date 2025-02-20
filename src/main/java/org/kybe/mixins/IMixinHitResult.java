package org.kybe.mixins;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HitResult.class)
public interface IMixinHitResult {
	@Accessor("location")
	@Mutable
	void setLocation(Vec3 location);
}
