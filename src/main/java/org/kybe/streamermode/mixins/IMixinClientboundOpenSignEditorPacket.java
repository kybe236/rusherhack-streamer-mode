package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundOpenSignEditorPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundOpenSignEditorPacket.class)
public interface IMixinClientboundOpenSignEditorPacket {
	@Accessor("pos")
	@Mutable
	void setPos(net.minecraft.core.BlockPos pos);
}
