package com.pluralsight.lambda;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {
		// Before Java 8
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 3; i++) {
					System.out.println("Hello World from thread: " + Thread.currentThread().getName());
				}
			}
		};
		
		// From Java 8
//		Runnable runnableLambda = () -> {
//			for(int i = 0; i < 3; i++) {
//				System.out.println("Hello World from thread: " + Thread.currentThread().getName());
//			}
//		};
		
		Runnable runnableLamdba2 = () -> {
			for(int i = 0; i < 4; i++) {
				System.out.println("Hello World from thread: " + Thread.currentThread().getName());
			}
		};
		
		//Thread t = new Thread(runnable);
		Thread t = new Thread(runnableLamdba2);
		t.start();
		t.join();
	}
}
