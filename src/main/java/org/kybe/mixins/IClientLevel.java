package org.kybe.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.kybe.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.io.IOException;

@Mixin(ClientLevel.class)
public class IClientLevel {
	@ModifyReturnValue(method = "getMapData", at = @At("RETURN"))
	private MapItemSavedData getMapData(MapItemSavedData value) {
		if (value == null) return null;
		if (StreamerModeModule.INSTANCE == null || !StreamerModeModule.INSTANCE.isToggled() || !StreamerModeModule.INSTANCE.hideMapContents.getValue()) return value;
		MapItemSavedData res = MapItemSavedData.createFresh((double)128.0, (double)128, (byte)1, false, false, value.dimension);

		byte[] colors = new byte[16384];
		for (int i = 0; i < 16384; i++) {
			colors[i] = (byte)8;
		}
		res.colors = colors;
		return res;
	}


}
