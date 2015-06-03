package co.elron.tuning;

public class Threads {

	static class MyThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}

}
