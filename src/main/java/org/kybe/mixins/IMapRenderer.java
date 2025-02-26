package org.kybe.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MapRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.state.MapRenderState;
import org.kybe.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapRenderer.class)
public class IMapRenderer {
	@Inject(method = "render", at = @At("HEAD"), cancellable = true)
	private void render(MapRenderState mapRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, boolean bl, int i, CallbackInfo ci) {
		if (StreamerModeModule.INSTANCE != null && StreamerModeModule.INSTANCE.isToggled() && StreamerModeModule.INSTANCE.hideMap.getValue()) {
			ci.cancel();
		}
	}
}
