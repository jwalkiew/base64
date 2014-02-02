package pl.jwalkiew.base64;

import org.junit.Assert;
import org.junit.Test;

public class Base64Test {

	private Base64 base64 = new Base64();

	@Test
	public void encodeWithoutPads() {
		Assert.assertEquals("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZS4uLiBpIGNvIHRlcmF6PyE/", base64.encode("Ala ma kota, a kot ma ale... i co teraz?!?".getBytes()));
	}

	@Test
	public void encodeWith1Pad() {
		Assert.assertEquals("QWxhIG1hIGtvdGE=", base64.encode("Ala ma kota".getBytes()));
	}

	@Test
	public void encodeWith2Pads() {
		Assert.assertEquals("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZQ==", base64.encode("Ala ma kota, a kot ma ale".getBytes()));
	}

	@Test
	public void decodeWithoutPads() {
		Assert.assertEquals("Ala ma kota, a kot ma ale... i co teraz?!?", new String(base64.decode("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZS4uLiBpIGNvIHRlcmF6PyE/")));
	}

	@Test
	public void decodeWith1Pad() {
		Assert.assertEquals("Ala ma kota", new String(base64.decode("QWxhIG1hIGtvdGE=")));
	}

	@Test
	public void decodeWith2Pads() {
		Assert.assertEquals("Ala ma kota, a kot ma ale", new String(base64.decode("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZQ==")));
	}

}
