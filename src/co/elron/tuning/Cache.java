package co.elron.tuning;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cache {

	public static class Task implements Runnable {

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println("[" + name + "] Task is running...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}

	}

	public static class Watchdog implements Runnable {
		@Override
		public void run() {
			System.gc();
			StringBuilder str = new StringBuilder("--- Watchdog ---\n");
			for (Thread t : threadMap.values()) {
				str.append(t.getName()).append(" is alive.\n");
			}
			System.out.println(str.toString());
		}

	}

	private static Map<String, Thread> threadMap = new WeakHashMap<String, Thread>();

	public static void createPool(int count, Runnable task) {
		for (int i = 0; i < count; i++) {
			Thread thread = new Thread(task);
			threadMap.put(thread.getName(), thread);
			thread.start();
		}
	}

	public static void main(String[] args) {
		Task task = new Task();
		createPool(10, task);
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
		schedule.scheduleWithFixedDelay(new Watchdog(), 0, 3, TimeUnit.SECONDS);
	}

}
