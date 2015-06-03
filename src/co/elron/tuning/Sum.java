package co.elron.tuning;

import java.util.ArrayList;
import java.util.List;

public class Sum {

	static List<Long> list = new ArrayList<Long>();

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		long sum = 0L;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}

		long end = System.currentTimeMillis() - start;
		System.out.println("Delta: " + end + " Sum: " + sum);
	}

}
