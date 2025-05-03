package org.kybe.streamermode.mixins;

import net.minecraft.core.SectionPos;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientboundSectionBlocksUpdatePacket.class)
public interface IMixinClientboundSectionBlocksUpdatePacket {
	@Accessor("sectionPos")
	SectionPos getSectionPos();

	@Accessor("sectionPos")
	@Mutable
	void setSectionPos(SectionPos sectionPos);
}
