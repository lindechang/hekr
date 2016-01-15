package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lindec
 *
 */
public class ProtocolTranslateImpl {

	public static ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	private static ParsedJson parsedJson = new ParsedJson();
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		// 为空值不输出
		mapper.setSerializationInclusion(Include.NON_EMPTY);
	}

	public static void addProtocolModule(String mid, String json) {
		InitBean.addProtocolModuleBean(mid, json);
		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
		// if (!beanFactory.containsBean(mid)) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ProtocolModule.class);
		beanFactory.registerBeanDefinition(mid, beanDefinitionBuilder.getBeanDefinition());
		// } else {}
	}

	public static ProtocolModule addProtocolModule(String mid) {
		ProtocolModule protocolModule = (ProtocolModule) ctx.getBean(mid);
		return protocolModule;

	}

	public static String getTranslateJson(String mid, byte[] payload) {

		if (null == mid || mid.equals("")) {

			return "Error: MID无效";
		}
		if ((null == payload) || (payload.length < 5) || (payload.length != payload[1])) {
			return "Error: 透传数据无效";
		}
		int sum = 0;
		for (int i = 0; i < (payload.length - 1); i++) {
			sum += (0x000000ff & payload[i]);
		}
		if (payload[payload.length - 1] != (byte) (0xff & sum)) {
			return "Error: 透传数据无效";
		}
		ProtocolModule protocolModule = null;
		try {
			protocolModule = addProtocolModule(mid);
		} catch (Exception e) {
			return "Error: MID无效";
		}
		parsedJson.setMid(protocolModule.getMid());
		parsedJson.setCid(protocolModule.getCid());
		parsedJson.setPid(protocolModule.getPid());
		String cmd = Integer.toHexString(payload[4] & 0xff);
		for (Protocol protocol : protocolModule.getProtocol()) {
			if (payload[4] == Byte.parseByte(cmd)) {
				parsedJson.setName(protocol.getName());
				parsedJson.setCmd(protocol.getCmd());
				parsedJson.setDesc(protocol.getDesc());
				parsedJson.setFrame_type(protocol.getFrame_type());
				List<ParsedField> fields = new ArrayList<ParsedField>();
				int start_index = 4;
				int end_index = 0;
				for (Field field : protocol.getFields()) {

					ParsedField parsedField = new ParsedField();
					parsedField.setName(field.getName());
					parsedField.setDesc(field.getDesc());

					String type = field.getData_type();
					String length = field.getData_length();
					parsedField.setData_type(type);
					parsedField.setData_length(length);

					end_index = start_index + Integer.parseInt(length);
					start_index = end_index;
					if (type.equals("01")) {
						if (null != field.getMax() && !field.getMax().equals("")) {
							parsedField.setValue(Byte.toString(payload[end_index]));
							parsedField.setUnit(field.getUnit());
							parsedField.setUnit_f(field.getUnit_f());
							parsedField.setMax(field.getMax());
							parsedField.setMin(field.getMin());
						} else {
							for (Enumeration enumeration : field.getEnumeration()) {
								if (enumeration.getValue().equals(Byte.toString(payload[end_index]))) {
									parsedField.setValue(enumeration.getValue());
									parsedField.setValue_desc(enumeration.getDesc());
									break;
								}
							}
						}
					} else if (type.equals("02")) {
					}

					fields.add(parsedField);
				}
				parsedJson.setFields(fields);
				break;
			}

		}
		String json = "Error";
		try {
			json = mapper.writeValueAsString(parsedJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

}
