package com.main.javaindepth;

public class SessionFactory {

	// 1. Eager initialization - Approach 1
	// private static final SessionFactory instance = new SessionFactory();

	// 2. Eager initilization - Approach 2
	private static SessionFactory instance;

	// 2. Using static block
	static {
		if (instance == null) {
			instance = new SessionFactory();
		}
	}

	private SessionFactory() {

	}

	public static SessionFactory getSessionFactory() {
		return instance;
	}

	// 3. Thread safe singleton
	public synchronized static SessionFactory getInstance() {
		if (instance == null) {
			instance = new SessionFactory();
		}
		return instance;
	}

	// 4. Lazy initialization with double check locking
	public static SessionFactory getInstanceDoubleCheck() {
		if (instance == null) {
			synchronized (SessionFactory.class) {
				if (instance == null) {
					instance = new SessionFactory();
				}
			}
		}
		return instance;
	}

	// 5. Bill Pugh Singleton implementation
	private static class BillPughSingleton {
		private static final SessionFactory INSTANCE = new SessionFactory();

		// When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when loading the class.
		// Inner class is created only when getInstance() method is called. So it may seem like eager initialization but it is lazy initialization.
		public static SessionFactory getInstance() {
			return BillPughSingleton.INSTANCE;
		}

	}
}
