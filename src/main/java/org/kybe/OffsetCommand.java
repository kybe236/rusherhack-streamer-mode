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
	public void toReal(Integer x, Integer z) {
		int real_x = CoordSpoofer.INSTANCE.coordManager.prepareSendX(x);
		int real_z = CoordSpoofer.INSTANCE.coordManager.prepareSendZ(z);
		ChatUtils.print("Real coords: " + real_x + " " + real_z);
	}

	@CommandExecutor(subCommand = "toFake")
	@CommandExecutor.Argument(value = {"int", "int"})
	public void toFake(Integer x, Integer z) {
		int fake_x = CoordSpoofer.INSTANCE.coordManager.prepareReceiveX(x);
		int fake_z = CoordSpoofer.INSTANCE.coordManager.prepareReceiveZ(z);
		ChatUtils.print("Fake coords: " + fake_x + " " + fake_z);
	}
}
