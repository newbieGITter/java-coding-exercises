package com.main.javaindepth;

import java.util.concurrent.atomic.AtomicInteger;

public class MeetupEventSimulator {

	public static class MeetupEvent {
		private String name;
		private AtomicInteger count = new AtomicInteger(1);

		public MeetupEvent() {
			// TODO Auto-generated constructor stub
		}

		public MeetupEvent(String name) {
			super();
			this.name = name;
		}
		
		public void attending(int guestCount) {
			if(guestCount == 1) {
				count.incrementAndGet();
			}
			else {
				count.addAndGet(guestCount);
			}
		}
		
		public void notAttending(int guestCount) {
			if(guestCount == 1) {
				count.decrementAndGet();
			} 
			else {
				boolean updated = false;
				
				while(!updated) {
					int currentCount = count.get();
					int newCount = currentCount - guestCount;
					updated = count.compareAndSet(currentCount, newCount);
				}
			}
		}
		
		public int getCount() {
			return count.get();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MeetupEvent jugBoston = new MeetupEvent("Boston Java User Group");
		
		Thread user1 = new Thread(() -> {
			jugBoston.attending(4);
			System.out.println(Thread.currentThread().getName() + ":" + jugBoston.getCount()) ;
		});
		
		Thread user2 = new Thread(() -> {
			jugBoston.attending(3);
			System.out.println(Thread.currentThread().getName() + ":" + jugBoston.getCount()) ;
			
			jugBoston.notAttending(3);
			System.out.println(Thread.currentThread().getName() + ":" + jugBoston.getCount()) ;
		});
		
		Thread user3 = new Thread(() -> {
			jugBoston.attending(1);
			System.out.println(Thread.currentThread().getName() + ":" + jugBoston.getCount()) ;
			
			jugBoston.notAttending(3);
			System.out.println(Thread.currentThread().getName() + ":" + jugBoston.getCount()) ;
		});
		
		user1.setName("User 1");
		user2.setName("User 2");
		user3.setName("User 3");
		
		user1.start();
		Thread.sleep(1);

		user2.start();
		Thread.sleep(2);
		
		user3.start();
		Thread.sleep(1);
		
		System.out.println("Total attending: " + jugBoston.getCount());
	}
}
