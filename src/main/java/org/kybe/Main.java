package org.kybe;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

public class Main extends Plugin {

	@Override
	public void onLoad() {
		final CoordSpoofer coordSpoofer = new CoordSpoofer();
		RusherHackAPI.getModuleManager().registerFeature(coordSpoofer);

		final OffsetCommand offsetCommand = new OffsetCommand();
		RusherHackAPI.getCommandManager().registerFeature(offsetCommand);
	}

	@Override
	public void onUnload() {

	}
}