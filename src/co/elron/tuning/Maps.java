package co.elron.tuning;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {

	static Map<Integer, Object> countMap = new ConcurrentHashMap<>();

	static class A {
		String x;
		String y;
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (true) {
					A a = new A();
					a.x = "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdb" + i;
					a.y = "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdx" + i;
					countMap.put(i, a);
					i++;
					method1();
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static void method1() {
		method2();
	}

	public static void method2() {
		method3();
	}

	public static void method3() {
		method4();
	}

	public static void method4() {
		String uuid = UUID.randomUUID().toString();
		if (uuid.contains("x")) {
			System.out.println("x");
		}
	}

}
