package org.kybe.mixins;

import net.minecraft.network.Connection;
import net.minecraft.network.PacketListener;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.Packet;
import org.jetbrains.annotations.Nullable;
import org.kybe.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class MixinConnection {
	@Inject(method = "genericsFtw", at = @At("HEAD"))
	private static void genericsFtw(Packet<?> packet, PacketListener listener, CallbackInfo ci) {
		StreamerModeModule.INSTANCE.packetReceived(packet);
	}

	@Inject(method = "sendPacket", at = @At("HEAD"))
	public void send(Packet<?> packet, @Nullable PacketSendListener packetSendListener, boolean bl, CallbackInfo ci) {
		StreamerModeModule.INSTANCE.packetSend(packet);
	}
}
