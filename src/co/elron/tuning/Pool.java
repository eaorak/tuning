package co.elron.tuning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("Pool is running...");
			}
		});
	}

}
