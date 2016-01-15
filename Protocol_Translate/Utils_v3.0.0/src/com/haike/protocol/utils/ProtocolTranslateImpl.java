package com.haike.protocol.utils;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.FOTILE;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.GREE;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.JOYOUNG;

/**
 * @author Administrator
 *
 */
public class ProtocolTranslateImpl {

	public static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"ApplicationContext.xml");
	
	static{
		//addProtocolModule(GREE.DEVICE_WASHER_55.MID,GREE.DEVICE_WASHER_55.PROTOCOL);
		//addProtocolModule(FOTILE.DEVICE_COOKER_12CC.MID,FOTILE.DEVICE_COOKER_12CC.PROTOCOL);
		//addProtocolModule(JOYOUNG.DEVICE_LED_1X.MID,JOYOUNG.DEVICE_LED_1X.PROTOCOL);
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

	public static void addProtocolModule(String mid, String json) {
		InitBean.addProtocolModuleBean(mid, json);
		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
				.getBeanFactory();
		if (!beanFactory.containsBean(mid)) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.rootBeanDefinition(ProtocolModule.class);
			beanFactory.registerBeanDefinition(mid,
					beanDefinitionBuilder.getBeanDefinition());
		} else {
			System.out.println("已经存在这个bean：" + mid);
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
		 ObjectMapper mapper = new ObjectMapper();
		  //为空值不输出
		  mapper.setSerializationInclusion(Include.NON_EMPTY);  
		if (null == mid || mid.equals("")) {
			
			return null;
		}

		if ((null == payload) || (payload.length < 5)
				|| (payload.length != payload[1])) {
		
			return null;
		}
		int sum = 0;
		for (int i = 0; i < (payload.length - 1); i++) {
			sum += (0x000000ff & payload[i]);
		}
		if (payload[payload.length - 1] != (byte) (0xff & sum)) {
			
			return null;
		}
		Protocol protocol = null;
		try {
			protocol = getProtocol(mid);
		} catch (Exception e) {
			
			return null;
		}

		//parsedJson.setStatus("ok");
		String frametype = Integer.toHexString(payload[2] & 0xff);

//		for (Enumeration comment : protocol.getFrametype()) {
//			if (frametype.equals(comment.getValue())) {
//				parsedJson.setFrametype(comment.getDesc());
//				break;
//			}
//		}

		String serialnumber = Integer.toHexString(payload[3] & 0xff);
		//parsedJson.setSerialnumber(serialnumber);

		String code = Integer.toHexString(payload[4] & 0xff);
		
//		for (Data data : protocol.getData()) {
//			
//			if (code.equals(data.getCode())) {
//				parsedJson.setCode(data.getDesc());
//
//				List<Command> cmds = new ArrayList<Command>();
//				// int old_mark = 5;
//				int i = 0;
//				for (Field field : data.getFields()) {
//					Command command = new Command();
//					command.setName(field.getName());
//					// int length = Integer.valueOf(field.getLength());
//					String value = Integer.toHexString(payload[5 + i] & 0xff);
//					i++;
//					for (Enumeration comment : field.getComments()) {
//						if (value.equals(comment.getValue())) {
//							command.setValue(comment.getValue());
//							command.setDesc(comment.getDesc());
//							break;
//						}
//					}
//					cmds.add(command);
//				}
//				parsedJson.setCmds(cmds);
//				break;
//			}
//		}
		
		String json = null;
		try {
			json = mapper.writeValueAsString(parsedJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}

}
