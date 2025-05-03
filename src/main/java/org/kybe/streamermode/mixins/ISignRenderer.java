package org.kybe.streamermode.mixins;

import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.SignText;
import org.kybe.streamermode.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SignRenderer.class)
public class ISignRenderer {
	@ModifyVariable(method = "renderSignText", at = @At(value = "HEAD"), argsOnly = true)
	private SignText renderSignText(SignText value) {
		if (StreamerModeModule.INSTANCE == null || !StreamerModeModule.INSTANCE.isToggled() || !StreamerModeModule.INSTANCE.hideSignText.getValue()) return value;
		value = value.setMessage(0, Component.literal(""));
		value = value.setMessage(1, Component.literal(""));
		value = value.setMessage(2, Component.literal(""));
		value = value.setMessage(3, Component.literal(""));
		return value;
	}
}
