package com.haike.protocol.utils;

import com.haike.protocol.utils.PROTOCOL_CONSTANT.JOYOUNG;


public class TestMain {
	

	public static void main(String[] args) {
		
		Test test = new Test();
		Thread test_thread = new Thread(test);
		test_thread.start();
		
	}
	
	public static class Test implements Runnable {

		@Override
		public void run() {
			Monitoring.begin();
			for (int i = 0; i < 10000; i++) {
				ProtocolTranslateImpl.addProtocolModule(JOYOUNG.DEVICE_LED_1X.MID+i , JOYOUNG.DEVICE_LED_1X.PROTOCOL);
			}
			Monitoring.end("初始化完成");
			for (int i = 0; i < 10; i++) {
				Parse parse = new Parse();
				Thread thread = new Thread(parse);
				thread.start();
			}
		}

	}

	public static class Parse implements Runnable {
		

		byte[] payload1 = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x01, 0x02, 0x02, 00, 00, 00, 00, 00, 00,
				(byte) 0x5e };
		byte[] payload2 = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x01, 0x01, 0x01, 00, 00, 00, 00, 00, 00,
				(byte) 0x5c };
		byte[] payload3 = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x01, 0x01, 0x01, 0X02, 00, 00, 00, 00, 00,
				(byte) 0x5E };
		@Override
		public void run() {
			
			Monitoring.begin();
			String json3 = null;
			for (int i = 0; i < 10000; i++) {
				json3 = ProtocolTranslateImpl.getTranslateJson(JOYOUNG.DEVICE_LED_1X.MID +i, payload1);
			}		
			Monitoring.end(Thread.currentThread().getName()+"翻译时间");	
			System.out.println(json3);
			
			
		}
	}

	


}
