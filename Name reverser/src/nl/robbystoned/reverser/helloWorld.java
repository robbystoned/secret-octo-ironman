package nl.robbystoned.reverser;

public class helloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		String name="DHcilbuP-462H.1.5DD.LD-BEW.p0801.20E10S.D.L.E.I.H.S.fo.stnegA.slevraM";
		System.out.println(reverse(name));
	}
	public static String reverse(String s) {
	    return new StringBuffer(s).reverse().toString();
	}
}
