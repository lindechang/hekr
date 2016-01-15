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
			public static final String PROTOCOL = "{\"status\": \"ok\",\"version\": 1,\"frametype\": "
					+ "[{\"value\": \"1\",\"desc\": \"设备数据主动上报帧\"},"
					+ "{\"value\": \"2\",\"desc\": \"模块数据下发帧\"},{\"value\": \"fe\",\"desc\":"
					+ " \"模块操作相关帧\"},{\"value\": \"ff\",\"desc\":" + " \"错误帧\"}],\"data\":["
					+ "{\"code\": \"1\",\"desc\": \"灯控制操作\",\"fields\": [{\"id\": "
					+ "\"2\",\"name\": \"灯控制\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"开\"},"
					+ "{\"value\": \"2\",\"desc\": \"关\"},{\"value\": \"3\",\"desc\":" + " \"翻转\"}]},{\"id\": "
					+ "\"3\",\"name\": \"灯亮度\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"亮度不调整\"},"
					+ "{\"value\": \"2\",\"desc\": \"亮度50%\"},{\"value\": \"3\",\"desc\":"
					+ " \"100%亮光\"}]}]},{\"code\": \"2\",\"desc\": \"设备\",\"fields\": "
					+ "[]},{\"code\": \"FE\",\"desc\": \"模块状态控制\", \"fields\": []},"
					+ "{\"code\": \"FF\",\"desc\": \"错误帧\",\"fields\": []}]}";

		}

		public interface DEVICE_LED_2X {
			/** 设备mid **/
			public static final String MID = "54616566564";
			/** 协议JSON格式 **/
			public static final String PROTOCOL = "05151516151113";

		}

	}

	public interface FOTILE {

		public interface DEVICE_COOKER_12CC {
			/** 设备mid **/
			public static final String MID = "FOTILE_DEVICE_COOKER_12CC_MID";
			/** 协议JSON格式 **/
			public static final String PROTOCOL = "{\"status\": \"ok\",\"version\": 1,\"frametype\": "
					+ "[{\"value\": \"1\",\"desc\": \"设备数据主动上报帧\"},"
					+ "{\"value\": \"2\",\"desc\": \"模块数据下发帧\"},{\"value\": \"fe\",\"desc\":"
					+ " \"模块操作相关帧\"},{\"value\": \"ff\",\"desc\":" + " \"错误帧\"}],\"data\":["
					+ "{\"code\": \"1\",\"desc\": \"烹饪操作\",\"fields\": [{\"id\": "
					+ "\"1\",\"name\": \"火候控制\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"爆炒\"},"
					+ "{\"value\": \"2\",\"desc\": \"慢炖\"},{\"value\": \"3\",\"desc\":" + " \"蒸煮\"}]},{\"id\": "
					+ "\"2\",\"name\": \"烹饪时长\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"10分钟\"},"
					+ "{\"value\": \"2\",\"desc\": \"30分钟\"},{\"value\": \"3\",\"desc\":"
					+ " \"1个小时\"}]},{\"id\": "
					+ "\"3\",\"name\": \"搅拌控制\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"快速翻炒\"},"
					+ "{\"value\": \"2\",\"desc\": \"缓慢搅拌\"},{\"value\": \"3\",\"desc\":"
					+ " \"无需搅拌\"}]}]},{\"code\": \"2\",\"desc\": \"设备\",\"fields\": "
					+ "[]},{\"code\": \"FE\",\"desc\": \"模块状态控制\", \"fields\": []},"
					+ "{\"code\": \"FF\",\"desc\": \"错误帧\",\"fields\": []}]}";

		}

	}
	
	public interface GREE {
		
		public interface DEVICE_WASHER_55 {
			/** 设备mid **/
			public static final String MID = "GREE_DEVICE_WASHER_55_MID";
			/** 协议JSON格式 **/
			public static final String PROTOCOL = "{\"status\": \"ok\",\"version\": 1,\"frametype\": "
					+ "[{\"value\": \"1\",\"desc\": \"设备数据主动上报帧\"},"
					+ "{\"value\": \"2\",\"desc\": \"模块数据下发帧\"},{\"value\": \"fe\",\"desc\":"
					+ " \"模块操作相关帧\"},{\"value\": \"ff\",\"desc\":" + " \"错误帧\"}],\"data\":["
					+ "{\"code\": \"1\",\"desc\": \"洗涤操作\",\"fields\": [{\"id\": "
					+ "\"2\",\"name\": \"水位控制\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"低水位\"},"
					+ "{\"value\": \"2\",\"desc\": \"中水位\"},{\"value\": \"3\",\"desc\":" + " \"高水位\"}]},{\"id\": "
					+ "\"3\",\"name\": \"洗涤时长\",\"datatype\": \"32\",\"length\": \"1\", "
					+ "\"expr\": \"\",\"comments\": [{\"value\": \"1\",\"desc\": \"10分钟\"},"
					+ "{\"value\": \"2\",\"desc\": \"30分钟\"},{\"value\": \"3\",\"desc\":"
					+ " \"1个小时\"}]}]},{\"code\": \"2\",\"desc\": \"设备\",\"fields\": "
					+ "[]},{\"code\": \"FE\",\"desc\": \"模块状态控制\", \"fields\": []},"
					+ "{\"code\": \"FF\",\"desc\": \"错误帧\",\"fields\": []}]}";

		}
		
	}

}
