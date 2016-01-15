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
			public static final String PROTOCOL = "{\"status\": \"ok\",\"version\": 1,\"frametype\": "
					+ "[{\"value\": \"1\",\"desc\": \"�豸���������ϱ�֡\"},"
					+ "{\"value\": \"2\",\"desc\": \"ģ�������·�֡\"},{\"value\": \"fe\",\"desc\":"
					+ " \"ģ��������֡\"},{\"value\": \"ff\",\"desc\":" + " \"����֡\"}],\"data\":["
					+ "{\"code\": \"1\",\"desc\": \"�ƿ��Ʋ���\",\"fields\": [{\"id\": "
					+ "\"2\",\"name\": \"�ƿ���\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"��\"},"
					+ "{\"value\": \"2\",\"desc\": \"��\"},{\"value\": \"3\",\"desc\":" + " \"��ת\"}]},{\"id\": "
					+ "\"3\",\"name\": \"������\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"���Ȳ�����\"},"
					+ "{\"value\": \"2\",\"desc\": \"����50%\"},{\"value\": \"3\",\"desc\":"
					+ " \"100%����\"}]}]},{\"code\": \"2\",\"desc\": \"�豸\",\"fields\": "
					+ "[]},{\"code\": \"FE\",\"desc\": \"ģ��״̬����\", \"fields\": []},"
					+ "{\"code\": \"FF\",\"desc\": \"����֡\",\"fields\": []}]}";

		}

		public interface DEVICE_LED_2X {
			/** �豸mid **/
			public static final String MID = "54616566564";
			/** Э��JSON��ʽ **/
			public static final String PROTOCOL = "05151516151113";

		}

	}

	public interface FOTILE {

		public interface DEVICE_COOKER_12CC {
			/** �豸mid **/
			public static final String MID = "FOTILE_DEVICE_COOKER_12CC_MID";
			/** Э��JSON��ʽ **/
			public static final String PROTOCOL = "{\"status\": \"ok\",\"version\": 1,\"frametype\": "
					+ "[{\"value\": \"1\",\"desc\": \"�豸���������ϱ�֡\"},"
					+ "{\"value\": \"2\",\"desc\": \"ģ�������·�֡\"},{\"value\": \"fe\",\"desc\":"
					+ " \"ģ��������֡\"},{\"value\": \"ff\",\"desc\":" + " \"����֡\"}],\"data\":["
					+ "{\"code\": \"1\",\"desc\": \"��⿲���\",\"fields\": [{\"id\": "
					+ "\"1\",\"name\": \"������\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"����\"},"
					+ "{\"value\": \"2\",\"desc\": \"����\"},{\"value\": \"3\",\"desc\":" + " \"����\"}]},{\"id\": "
					+ "\"2\",\"name\": \"���ʱ��\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"10����\"},"
					+ "{\"value\": \"2\",\"desc\": \"30����\"},{\"value\": \"3\",\"desc\":"
					+ " \"1��Сʱ\"}]},{\"id\": "
					+ "\"3\",\"name\": \"�������\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"���ٷ���\"},"
					+ "{\"value\": \"2\",\"desc\": \"��������\"},{\"value\": \"3\",\"desc\":"
					+ " \"�������\"}]}]},{\"code\": \"2\",\"desc\": \"�豸\",\"fields\": "
					+ "[]},{\"code\": \"FE\",\"desc\": \"ģ��״̬����\", \"fields\": []},"
					+ "{\"code\": \"FF\",\"desc\": \"����֡\",\"fields\": []}]}";

		}

	}
	
	public interface GREE {
		
		public interface DEVICE_WASHER_55 {
			/** �豸mid **/
			public static final String MID = "GREE_DEVICE_WASHER_55_MID";
			/** Э��JSON��ʽ **/
			public static final String PROTOCOL = "{\"status\": \"ok\",\"version\": 1,\"frametype\": "
					+ "[{\"value\": \"1\",\"desc\": \"�豸���������ϱ�֡\"},"
					+ "{\"value\": \"2\",\"desc\": \"ģ�������·�֡\"},{\"value\": \"fe\",\"desc\":"
					+ " \"ģ��������֡\"},{\"value\": \"ff\",\"desc\":" + " \"����֡\"}],\"data\":["
					+ "{\"code\": \"1\",\"desc\": \"ϴ�Ӳ���\",\"fields\": [{\"id\": "
					+ "\"2\",\"name\": \"ˮλ����\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"��ˮλ\"},"
					+ "{\"value\": \"2\",\"desc\": \"��ˮλ\"},{\"value\": \"3\",\"desc\":" + " \"��ˮλ\"}]},{\"id\": "
					+ "\"3\",\"name\": \"ϴ��ʱ��\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"10����\"},"
					+ "{\"value\": \"2\",\"desc\": \"30����\"},{\"value\": \"3\",\"desc\":"
					+ " \"1��Сʱ\"}]}]},{\"code\": \"2\",\"desc\": \"�豸\",\"fields\": "
					+ "[]},{\"code\": \"FE\",\"desc\": \"ģ��״̬����\", \"fields\": []},"
					+ "{\"code\": \"FF\",\"desc\": \"����֡\",\"fields\": []}]}";

		}
		
	}

}
