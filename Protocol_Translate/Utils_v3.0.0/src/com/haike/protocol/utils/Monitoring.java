package com.haike.protocol.utils;

public class Monitoring {

	private static ThreadLocal<Long> begin = new ThreadLocal<Long>();

	public static void begin() {
		begin.set(System.currentTimeMillis());
	}

	public static void end(String name) {
		double time = (System.currentTimeMillis() - begin.get()) / 1000.0;
		System.out.println(name + "����ʱ�䣨�룩��" + time);
		
	}
}
