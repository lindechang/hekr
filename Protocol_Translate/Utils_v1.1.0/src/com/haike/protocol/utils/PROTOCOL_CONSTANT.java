package com.haike.protocol.utils;

public interface PROTOCOL_CONSTANT {

	/**
	 * @author lindec
	 */
	public interface JOYOUNG {

		public interface DEVICE_LED_1X {
			/** �豸mid **/
			public static final String MID = "JOYOUNG_DEVICE_LED_1X_MID";
			/** Э��JSON��ʽ **/
			

			public static final String PROTOCOL = "{\"mid\": \"1\",\"cid\": \"1\",\"pid\": \"1\",\"createtime\":"
					+ "\"2016-1-11\",\"protocol\": [{\"name\": \"setPower\",\"cmd\":"
					+ " \"01\",\"desc\": \"���ÿ���\",\"frame_type\": \"02\",\"fields\":"
					+ " [{\"name\": \"power\",\"desc\": \"����\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"enumeration\": [{\"value\": \"1\",\"desc\": "
					+ "\"��\"},{\"value\": \"0\",\"desc\": \"��\"}]},{\"name\": \"light\",\"desc\":"
					+ " \"����\",\"unit\": \"���Ȱٷֱ�\",\"unit_f\": \"%\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"max\": \"100\",\"min\": \"10\"}]}]}";
			
			public static final String PROTOCOL_test = "{\"mid\": \"1\",\"cid\": \"2\",\"pid\": \"1\",\"createtime\":"
					+ "\"2016-1-11\",\"protocol\": [{\"name\": \"setPower\",\"cmd\":"
					+ " \"01\",\"desc\": \"���ÿ���\",\"frame_type\": \"01\",\"fields\":"
					+ " [{\"name\": \"power\",\"desc\": \"����\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"enumeration\": [{\"value\": \"1\",\"desc\": "
					+ "\"��\"},{\"value\": \"0\",\"desc\": \"��\"}]},{\"name\": \"light\",\"desc\":"
					+ " \"����\",\"unit\": \"���Ȱٷֱ�\",\"unit_f\": \"%\",\"data_type\": \"integer\","
					+ "\"data_length\": \"1\",\"max\": \"100\",\"min\": \"10\"}]}]}";
		
		}

		public interface DEVICE_LED_2X {
			/** �豸mid **/
			public static final String MID = "54616566564";
			/** Э��JSON��ʽ **/
			public static final String PROTOCOL = "";

		}

	}

	public interface FOTILE {

		public interface DEVICE_COOKER_12CC {
			/** �豸mid **/
			public static final String MID = "FOTILE_DEVICE_COOKER_12CC_MID";
			/** Э��JSON��ʽ **/
			public static final String PROTOCOL = "";

		}

	}
	
	public interface GREE {
		
		public interface DEVICE_WASHER_55 {
			/** �豸mid **/
			public static final String MID = "GREE_DEVICE_WASHER_55_MID";
			/** Э��JSON��ʽ **/
			public static final String PROTOCOL = "";

		}
		
	}

}
