package org.kybe.streamermode.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.kybe.streamermode.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class IMinecraft {
	@Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;Z)V", at = @At("HEAD"))
	private void disconnect(Screen screen, boolean bl, CallbackInfo ci) {
		if (StreamerModeModule.INSTANCE != null) {
			StreamerModeModule.INSTANCE.disconnect();
		}
	}
}
