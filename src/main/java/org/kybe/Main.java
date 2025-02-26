package org.kybe;

import net.minecraft.client.Minecraft;
import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

public class Main extends Plugin {

	@Override
	public void onLoad() {
		final StreamerModeModule streamerModeModule = new StreamerModeModule();
		RusherHackAPI.getModuleManager().registerFeature(streamerModeModule);

		final OffsetCommand offsetCommand = new OffsetCommand();
		RusherHackAPI.getCommandManager().registerFeature(offsetCommand);
	}

	@Override
	public void onUnload() {

	}
}