package org.kybe.streamermode.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundPlayerActionPacket.class)
public interface IMixinServerboundPlayerActionPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
