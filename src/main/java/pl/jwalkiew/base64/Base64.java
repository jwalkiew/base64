package pl.jwalkiew.base64;

import java.util.Arrays;

public class Base64 {

	private final static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	private final static String PAD_CHAR = "=";

	public String encode(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		String pad = "";
		int rest = bytes.length % 3;

		if (rest > 0) {
			bytes = Arrays.copyOf(bytes, bytes.length + 3 - rest);

			for (; rest < 3; rest++)
				pad += PAD_CHAR;
		}

		for (int i = 0; i < bytes.length; i += 3) {
			int byte1 = (int) (bytes[i]) & 255;
			int byte2 = (int) (bytes[i + 1]) & 255;
			int byte3 = (int) (bytes[i + 2]) &255;

			int part1 = (byte1 >> 2) & 63;
			int part2 = ((byte1 << 4) | (byte2 >> 4)) & 63;
			int part3 = ((byte2 << 2) | (byte3 >> 6)) & 63;
			int part4 = byte3 & 63;

			stringBuilder.append(CHARS.charAt(part1));
			stringBuilder.append(CHARS.charAt(part2));
			stringBuilder.append(CHARS.charAt(part3));
			stringBuilder.append(CHARS.charAt(part4));
		}

		String result = stringBuilder.toString();

		return result.substring(0, result.length() - pad.length()) + pad;

	}

	public byte[] decode(String str) {
		byte[] bytes = new byte[str.length() * 3 / 4];
		int strLength = str.length();
		String pad = "";

		for (int i = 0; i < 2; i++)
			if (str.charAt(strLength - 1 - i) == PAD_CHAR.charAt(0))
				pad += CHARS.charAt(0);

		str = str.substring(0, strLength - pad.length()) + pad;

		for (int i = 0, j = 0; i < str.length(); i += 4, j += 3) {
			int part1 = CHARS.indexOf(str.charAt(i));
			int part2 = CHARS.indexOf(str.charAt(i + 1));
			int part3 = CHARS.indexOf(str.charAt(i + 2));
			int part4 = CHARS.indexOf(str.charAt(i + 3));

			int byte1 = ((part1 << 2) | (part2 >> 4)) & 255;
			int byte2 = ((part2 << 4) | (part3 >> 2)) & 255;
			int byte3 = ((part3 << 6) | part4) & 255;

			bytes[j] = (byte) byte1;
			bytes[j + 1] = (byte) byte2;
			bytes[j + 2] = (byte) byte3;
		}

		return Arrays.copyOfRange(bytes, 0, bytes.length - pad.length());
	}
}
