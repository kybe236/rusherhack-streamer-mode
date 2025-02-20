package org.kybe;

import org.rusherhack.client.api.feature.command.Command;
import org.rusherhack.client.api.utils.ChatUtils;
import org.rusherhack.core.command.annotations.CommandExecutor;

public class OffsetCommand extends Command {
	public OffsetCommand() {
		super("offset", "makes the fake code real coords or other way around");
	}

	@CommandExecutor(subCommand = "toReal")
	@CommandExecutor.Argument(value = {"int", "int"})
	public String toReal(Integer x, Integer z) {
		int real_x = CoordSpoofer.INSTANCE.coordManager.prepareSendX(x);
		int real_z = CoordSpoofer.INSTANCE.coordManager.prepareSendZ(z);
		return "Real coords: " + real_x + " " + real_z;
	}

	@CommandExecutor(subCommand = "toReal")
	public String toReal() {
		if (mc.player == null) {
			return "You need to be in a world to use this command";
		}
		int real_x = CoordSpoofer.INSTANCE.coordManager.prepareSendX(mc.player.blockPosition().getX());
		int real_z = CoordSpoofer.INSTANCE.coordManager.prepareSendZ(mc.player.blockPosition().getZ());
		return "Real coords: " + real_x + " " + real_z;
	}

	@CommandExecutor(subCommand = "toFake")
	@CommandExecutor.Argument(value = {"int", "int"})
	public String toFake(Integer x, Integer z) {
		int fake_x = CoordSpoofer.INSTANCE.coordManager.prepareReceiveX(x);
		int fake_z = CoordSpoofer.INSTANCE.coordManager.prepareReceiveZ(z);
		return "Fake coords: " + fake_x + " " + fake_z;
	}

	@CommandExecutor(subCommand = "toFake")
	public String toFake() {
		if (mc.player == null) {
			return "You need to be in a world to use this command";
		}
		int fake_x = CoordSpoofer.INSTANCE.coordManager.prepareReceiveX(mc.player.blockPosition().getX());
		int fake_z = CoordSpoofer.INSTANCE.coordManager.prepareReceiveZ(mc.player.blockPosition().getZ());
		return "Fake coords: " + fake_x + " " + fake_z;
	}
}
