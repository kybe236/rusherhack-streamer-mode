package org.kybe.streamermode.mixins;

import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "net.minecraft.network.protocol.game.ServerboundInteractPacket$InteractionAtLocationAction")
public interface IMixinInteractionAtLocationAction {
	@Accessor("location")
	void setLocation(Vec3 location);
}
