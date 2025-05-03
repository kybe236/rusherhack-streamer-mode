package org.kybe.streamermode.mixins;

import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.kybe.streamermode.StreamerModeModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import static org.rusherhack.client.api.Globals.mc;

@Mixin(BlockRenderDispatcher.class)
public class IBlockRenderDispatcher {
	@ModifyArgs(method = "renderBatched", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/BlockRenderDispatcher;getBlockModel(Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/client/resources/model/BakedModel;"))
	private void renderBatchedArgs(Args args) {
		BlockState blockState = args.get(0);
		if (blockState.getBlock() != Blocks.BEDROCK) return;
		if (StreamerModeModule.INSTANCE == null || !StreamerModeModule.INSTANCE.isToggled() || !StreamerModeModule.INSTANCE.turnBedrockIntoStoneOrNetherrack.getValue()) return;
		if (mc.level == null) return;
		if (mc.level.dimension() == Level.OVERWORLD) {
			args.set(0, Blocks.STONE.defaultBlockState());
		} else if (mc.level.dimension() == Level.NETHER) {
			args.set(0, Blocks.NETHERRACK.defaultBlockState());
		}
	}
}
