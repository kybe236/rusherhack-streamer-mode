package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundMoveEntityPacket.class)
public interface IMixinClientboundMoveEntityPacket {
	@Accessor("xa")
	@Mutable
	void setXa(short xa);

	@Accessor("za")
	@Mutable
	void setZa(short za);
}
