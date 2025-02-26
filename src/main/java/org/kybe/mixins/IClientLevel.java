package org.kybe.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.kybe.StreamerModeModule;
import org.kybe.utils.MapUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.io.IOException;

@Mixin(ClientLevel.class)
public class IClientLevel {
	int tick = 0;

	@ModifyReturnValue(method = "getMapData", at = @At("RETURN"))
	private MapItemSavedData getMapData(MapItemSavedData value) {
		if (value == null) return null;
		if (StreamerModeModule.INSTANCE == null || !StreamerModeModule.INSTANCE.isToggled() || !StreamerModeModule.INSTANCE.hideMapContents.getValue()) return value;
		MapItemSavedData res = MapItemSavedData.createFresh((double)128.0, (double)128, (byte)1, false, false, value.dimension);
		try {
			tick++;
			if (tick == Integer.MAX_VALUE) tick = 0;
			res.colors = MapUtil.getMapColorsFromResource("/code-kybe.png", tick);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return res;
		}
	}


}
