package com.main.javaindepth;

import java.util.concurrent.TimeUnit;

public class StopThread {

	private static volatile boolean stop;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			while(!stop) {
				System.out.println("In while");
			}
		}).start();
		
		TimeUnit.MILLISECONDS.sleep(10);
		stop = true;
		System.out.println("End of program");
	}
}
