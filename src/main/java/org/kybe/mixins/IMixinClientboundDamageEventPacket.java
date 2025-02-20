package org.kybe.mixins;

import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Optional;

@Mixin(ClientboundDamageEventPacket.class)
public interface IMixinClientboundDamageEventPacket {
	@Accessor("sourcePosition")
	Optional<Vec3> getSourcePosition();

	@Accessor("sourcePosition")
	@Mutable
	void setSourcePosition(Optional<Vec3> sourcePosition);
}

