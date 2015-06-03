package co.elron.tuning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leak {

	static List<Long> list = new ArrayList<Long>();

	public static void main(String[] args) {
		while (true) {
			list.add(new Random().nextLong());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
