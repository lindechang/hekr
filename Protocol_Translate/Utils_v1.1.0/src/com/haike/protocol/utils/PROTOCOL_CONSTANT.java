package com.haike.protocol.utils;

public interface PROTOCOL_CONSTANT {

	/**
	 * @author lindec
	 */
	public interface JOYOUNG {

		public interface DEVICE_LED_1X {
			/** 设备mid **/
			public static final String MID = "JOYOUNG_DEVICE_LED_1X_MID";
			/** 协议JSON格式 **/
			

			public static final String PROTOCOL = "{\"mid\": \"1\",\"cid\": \"1\",\"pid\": \"1\",\"createtime\":"
					+ "\"2016-1-11\",\"protocol\": [{\"name\": \"setPower\",\"cmd\":"
					+ " \"01\",\"desc\": \"设置开关\",\"frame_type\": \"02\",\"fields\":"
					+ " [{\"name\": \"power\",\"desc\": \"开关\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"enumeration\": [{\"value\": \"1\",\"desc\": "
					+ "\"开\"},{\"value\": \"0\",\"desc\": \"关\"}]},{\"name\": \"light\",\"desc\":"
					+ " \"亮度\",\"unit\": \"亮度百分比\",\"unit_f\": \"%\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"max\": \"100\",\"min\": \"10\"}]}]}";
			
			public static final String PROTOCOL_test = "{\"mid\": \"1\",\"cid\": \"2\",\"pid\": \"1\",\"createtime\":"
					+ "\"2016-1-11\",\"protocol\": [{\"name\": \"setPower\",\"cmd\":"
					+ " \"01\",\"desc\": \"设置开关\",\"frame_type\": \"01\",\"fields\":"
					+ " [{\"name\": \"power\",\"desc\": \"开关\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"enumeration\": [{\"value\": \"1\",\"desc\": "
					+ "\"开\"},{\"value\": \"0\",\"desc\": \"关\"}]},{\"name\": \"light\",\"desc\":"
					+ " \"亮度\",\"unit\": \"亮度百分比\",\"unit_f\": \"%\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"max\": \"100\",\"min\": \"10\"}]}]}";
		
		}

		public interface DEVICE_LED_2X {
			/** 设备mid **/
			public static final String MID = "54616566564";
			/** 协议JSON格式 **/
			public static final String PROTOCOL = "";

		}

	}

	public interface FOTILE {

		public interface DEVICE_COOKER_12CC {
			/** 设备mid **/
			public static final String MID = "FOTILE_DEVICE_COOKER_12CC_MID";
			/** 协议JSON格式 **/
			public static final String PROTOCOL = "";

		}

	}
	
	public interface GREE {
		
		public interface DEVICE_WASHER_55 {
			/** 设备mid **/
			public static final String MID = "GREE_DEVICE_WASHER_55_MID";
			/** 协议JSON格式 **/
			public static final String PROTOCOL = "";

		}
		
	}

}
