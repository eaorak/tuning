package co.elron.tuning;

public class Locks {

	static class MyThread extends Thread {
		@Override
		public void run() {
			while (true) {
				process();
			}
		}
	}

	public static void process() {
		method1();
	}

	private static void method1() {
		method2();
	}

	private static void method2() {
		System.out.println("");
	}

	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}

}
