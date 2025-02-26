package org.kybe.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.MapRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.saveddata.maps.MapId;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.kybe.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapRenderer.class)
public class IMapRenderer {
	@Inject(method = "render", at = @At("HEAD"), cancellable = true)
	private void render(PoseStack poseStack, MultiBufferSource multiBufferSource, MapId mapId, MapItemSavedData mapItemSavedData, boolean bl, int i, CallbackInfo ci) {
		if (StreamerModeModule.INSTANCE != null && StreamerModeModule.INSTANCE.isToggled() && StreamerModeModule.INSTANCE.hideMap.getValue()) {
			ci.cancel();
		}
	}
}
