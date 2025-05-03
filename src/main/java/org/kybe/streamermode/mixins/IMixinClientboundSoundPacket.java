package org.kybe.streamermode.mixins;

import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundSoundPacket.class)
public interface IMixinClientboundSoundPacket {
	@Accessor("x")
	int getX();

	@Accessor("x")
	@Mutable
	void setX(int x);

	@Accessor("z")
	int getZ();

	@Accessor("z")
	@Mutable
	void setZ(int z);
}
