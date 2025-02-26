package org.kybe.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MapUtil {

	static final int TRANSPARENT_COLOR = 0;
	static final int MIN_COLOR = 1;
	static final int MAX_COLOR = 61;
	public static byte[] getMapColorsFromResource(String resourcePath, int start_index) throws IOException {
		try (InputStream in = MapUtil.class.getResourceAsStream(resourcePath)) {
			if (in == null) {
				throw new IOException("Resource not found: " + resourcePath);
			}
			BufferedImage image = ImageIO.read(in);
			if (image.getWidth() != 128 || image.getHeight() != 128) {
				throw new IllegalArgumentException("Image must be exactly 128x128 pixels.");
			}

			byte[] colors = new byte[128 * 128];

			int currentColor = start_index;
			for (int y = 0; y < 128; y++) {
				for (int x = 0; x < 128; x++) {
					currentColor++;
					int argb = image.getRGB(x, y);
					if (argb == 0xFFFFFFFF || argb == 0x00FFFFFF) {
						colors[y * 128 + x] = (byte) TRANSPARENT_COLOR;
					} else {
						colors[y * 128 + x] = (byte) (currentColor % MAX_COLOR + 1);
					}
				}
			}
			return colors;
		}
	}
}
