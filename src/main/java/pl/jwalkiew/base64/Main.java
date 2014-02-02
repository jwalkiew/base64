package pl.jwalkiew.base64;

public class Main {

	public static void main(String[] args) {
		Base64 base64 = new Base64();

		System.out.println("Ala ma kota -> " + base64.encode("Ala ma kota".getBytes()));
		System.out.println("Ala ma kota, a kot ma ale -> " + base64.encode("Ala ma kota, a kot ma ale".getBytes()));
		System.out.println("Ala ma kota, a kot ma ale... i co teraz?!? -> " + base64.encode("Ala ma kota, a kot ma ale... i co teraz?!?".getBytes()));

		System.out.println("QWxhIG1hIGtvdGE= -> " + new String(base64.decode("QWxhIG1hIGtvdGE=")));
		System.out.println("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZQ== -> " + new String(base64.decode("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZQ==")));
		System.out.println("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZS4uLiBpIGNvIHRlcmF6PyE/ -> " + new String(base64.decode("QWxhIG1hIGtvdGEsIGEga290IG1hIGFsZS4uLiBpIGNvIHRlcmF6PyE/")));
	}
}
