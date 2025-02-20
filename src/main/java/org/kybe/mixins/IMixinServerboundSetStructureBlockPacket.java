package org.kybe.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundSetStructureBlockPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundSetStructureBlockPacket.class)
public interface IMixinServerboundSetStructureBlockPacket {
	@Accessor("pos")
	@Mutable
	void setPos(BlockPos pos);
}
