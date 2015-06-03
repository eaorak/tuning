package co.elron.tuning;

public class Strings {

	public static void main(String[] args) {
		String s1 = "Java is fun";
		String s2 = "Java " + "is" + new StringBuffer(" fun");
		System.out.println(s1 == s2);
	}

	public static void main2(String[] args) {
		Long start = System.currentTimeMillis();
		StringBuilder str = new StringBuilder(100100);
		for (long l = 0; l < 100000; l++) {
			str.append(l);
		}
		System.out.println(str.toString().substring(0, 10));
		Long end = System.currentTimeMillis();
		System.out.println("Total: " + (end - start));
		//
		start = System.currentTimeMillis();
		String s = "";
		for (long l = 0; l < 100000; l++) {
			s += l;
		}
		System.out.println(s.substring(0, 10));
		end = System.currentTimeMillis();
		System.out.println("Total: " + (end - start));
	}

}
