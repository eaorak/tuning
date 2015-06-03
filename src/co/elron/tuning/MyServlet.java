package co.elron.tuning;

import java.util.concurrent.atomic.AtomicInteger;

public class MyServlet {

	private final AtomicInteger requestCount = new AtomicInteger(0);

	public void doGet() {
		int value = requestCount.incrementAndGet();
		System.out.println(value);
	}

	public static void main(String[] args) {

		final MyServlet servlet = new MyServlet();

		new Thread(new Runnable() {
			@Override
			public void run() {
				servlet.doGet();
			}
		}).start();
		//
		new Thread(new Runnable() {
			@Override
			public void run() {
				servlet.doGet();
			}
		}).start();
	}

}
