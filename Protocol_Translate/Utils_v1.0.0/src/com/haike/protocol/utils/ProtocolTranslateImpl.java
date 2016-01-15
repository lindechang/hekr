package com.haike.protocol.utils;

import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.FOTILE;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.GREE;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.JOYOUNG;

/**
 * @author Administrator
 *
 */
public class ProtocolTranslateImpl {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"ApplicationContext.xml");
	
	static{
		addProtocol(GREE.DEVICE_WASHER_55.MID,GREE.DEVICE_WASHER_55.PROTOCOL);
		addProtocol(FOTILE.DEVICE_COOKER_12CC.MID,FOTILE.DEVICE_COOKER_12CC.PROTOCOL);
		addProtocol(JOYOUNG.DEVICE_LED_1X.MID,JOYOUNG.DEVICE_LED_1X.PROTOCOL);
	}


	// public static void addProtocol(String mid) {
	// ConfigurableApplicationContext applicationContext =
	// (ConfigurableApplicationContext) ctx;
	// DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)
	// applicationContext
	// .getBeanFactory();
	// if (!beanFactory.containsBean(mid)) {
	// BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
	// .rootBeanDefinition(Protocol.class);
	// beanFactory.registerBeanDefinition(mid,
	// beanDefinitionBuilder.getBeanDefinition());
	// } else {
	// //System.out.println("已经存在这个bean：" + mid);
	// }
	// }

	public static void addProtocol(String mid, String json) {
		InitBean.addProtocol(mid, json);
		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();
		if (!beanFactory.containsBean(mid)) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.rootBeanDefinition(Protocol.class);
			beanFactory.registerBeanDefinition(mid,
					beanDefinitionBuilder.getBeanDefinition());
		} else {
			//System.out.println("已经存在这个bean：" + mid);
		}
	}

	public static void addProtocol(Protocol protocol) {

	}

	public static Protocol getProtocol(String mid) {
		Protocol protocol = (Protocol) ctx.getBean(mid);
		return protocol;

	}

	public static String getTranslateJson(String mid, byte[] payload) {
		ParsedJson parsedJson = new ParsedJson();

		if (null == mid || mid.equals("")) {
			parsedJson.setStatus("Error，无效MID");
			parsedJson.setFrametype("FF");
			return JSON.toJSONString(parsedJson);
		}

		if ((null == payload) || (payload.length < 5)
				|| (payload.length != payload[1])) {
			parsedJson.setStatus("Error，无效数据帧");
			parsedJson.setFrametype("FF");
			return JSON.toJSONString(parsedJson);
		}
		int sum = 0;
		for (int i = 0; i < (payload.length - 1); i++) {
			sum += (0x000000ff & payload[i]);
		}
		if (payload[payload.length - 1] != (byte) (0xff & sum)) {
			parsedJson.setStatus("Error，无效数据帧");
			parsedJson.setFrametype("FF");
			return JSON.toJSONString(parsedJson);
		}
		Protocol protocol = null;
		try {
			protocol = getProtocol(mid);
		} catch (Exception e) {
			parsedJson.setStatus("Error，无效MID");
			parsedJson.setFrametype("FF");
			return JSON.toJSONString(parsedJson);
		}

		parsedJson.setStatus("ok");
		String frametype = Integer.toHexString(payload[2] & 0xff);

		for (Comment comment : protocol.getFrametype()) {
			if (frametype.equals(comment.getValue())) {
				parsedJson.setFrametype(comment.getDesc());
				break;
			}
		}

		String serialnumber = Integer.toHexString(payload[3] & 0xff);
		parsedJson.setSerialnumber(serialnumber);

		String code = Integer.toHexString(payload[4] & 0xff);
		// System.out.println("code:" + code);
		for (Data data : protocol.getData()) {
			// System.out.println("data.getCode():" + data.getCode());
			if (code.equals(data.getCode())) {
				parsedJson.setCode(data.getDesc());

				List<Command> cmds = new ArrayList<Command>();
				// int old_mark = 5;
				int i = 0;
				for (Field field : data.getFields()) {
					Command command = new Command();
					command.setName(field.getName());
					// int length = Integer.valueOf(field.getLength());
					String value = Integer.toHexString(payload[5 + i] & 0xff);
					i++;
					for (Comment comment : field.getComments()) {
						if (value.equals(comment.getValue())) {
							command.setValue(comment.getValue());
							command.setDesc(comment.getDesc());
							break;
						}
					}
					cmds.add(command);
				}
				parsedJson.setCmds(cmds);
				break;
			}
		}

		return JSON.toJSONString(parsedJson);
	}

}
