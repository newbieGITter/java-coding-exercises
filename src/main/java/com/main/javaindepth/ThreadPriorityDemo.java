package com.main.javaindepth;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName());

				if (i == 5) {
					Thread.currentThread().yield();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});

		t1.setName("EmailCampaign");
		t2.setName("DataAggregator");

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();
		
		try {
			// main thread is suspended until t2 dies
			t2.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing main exectuion");
	}

}
