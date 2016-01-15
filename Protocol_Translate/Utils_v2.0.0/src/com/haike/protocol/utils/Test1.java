package com.haike.protocol.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.FOTILE;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.GREE;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.JOYOUNG;

public class Test1 {

	public static void crc(byte[] payload) {
		int sum = 0;
		for (int i = 0; i < (payload.length - 1); i++) {
			sum += (0x000000ff & payload[i]);
		}
		System.out.println(sum);
		sum = (0x000000ff & sum);
		System.out.println(sum);

		System.out.println((byte) sum == payload[payload.length - 1]);
		System.out.println((byte) payload.length == payload[1]);
	}

	byte[] payload = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x02, 0x01, 00, 00, 00, 00, 00, 00, 00, (byte) 0x5C };

	// byte[] payload = {(byte)0xff,(byte)0xf1};
	@Test
	public void test() {

		// crc(payload);
		byte mm = (byte) 0xF1;
		byte[] pp = { (byte) 123, 0x22 };
		String st = "" + (0x000000ff & mm);
		String sm = null;
		try {
			sm = new String(pp, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String s1 = "f1";
		String s2 = (String) Integer.toHexString(mm & 0xff);
		System.out.println(Integer.toHexString(mm & 0xff));
		System.out.println(s2.getBytes().length);
		System.out.println(s1.equals(s2));
		// System.out.println(st);
		 System.out.println(sm);
		 
		 byte ss = (byte)0x7b;
		 
		 String sTs = "123";
		 
		 String stm= Byte.toString(ss);
		 
		 
		 System.out.println(stm.equals(sTs));
		 
		  
		 System.out.println("sf1--:"+(sTs.equals(Byte.toString(ss))  ?1:0));
		 System.out.println("sf2--:"+(Byte.parseByte(sTs) == ss ?1:0));
		 
		 String mmmt = new String(pp, 1, 1);
		
		 System.out.println("mmmt:"+mmmt);
		 
	}
	// @Test
	// public void translate(){
	// ApplicationContext ctx = new ClassPathXmlApplicationContext(
	// "ApplicationContext.xml");
	// //String str = ProtocolTranslateImpl.getTranslateJson(null, null);
	// Protocol protocol = ProtocolTranslateImpl.getProtocol(ctx,"DS");
	// System.out.println(protocol.getStatus());
	// System.out.println(protocol.getVersion());
	// }
	@Test
	public void test4() {
		ProtocolTranslateImpl.addProtocolModule(JOYOUNG.DEVICE_LED_1X.MID, JOYOUNG.DEVICE_LED_1X.PROTOCOL);
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("ApplicationContext.xml");

		ProtocolModule protocolModule = (ProtocolModule) ProtocolTranslateImpl.ctx.getBean(JOYOUNG.DEVICE_LED_1X.MID);
		System.out.println("cid:" + protocolModule.getCid());
		System.out.println("protocolModule:" + protocolModule.toString());
		ObjectMapper mapper = new ObjectMapper();
		// 为空值不输出
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		String ss = null;
		try {
			ss = mapper.writeValueAsString(protocolModule);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ss1:" + ss);

	}

	@Test
	public void test3() {
		// 创建IOC容器对象
		Monitoring.begin();
		// ApplicationContext ctx = new ClassPathXmlApplicationContext(
		// "ApplicationContext.xml");
		ProtocolTranslateImpl.addProtocolModule(JOYOUNG.DEVICE_LED_1X.MID, JOYOUNG.DEVICE_LED_1X.PROTOCOL);
		for (int i = 0; i < 100000; i++) {
			// String name = JOYOUNG.DEVICE_LED_1X.MID + i;
			ProtocolTranslateImpl.addProtocolModule(JOYOUNG.DEVICE_LED_1X.MID + i, JOYOUNG.DEVICE_LED_1X.PROTOCOL);
		}

		// ProtocolTranslateImpl.addProtocol(ctx, GREE.DEVICE_WASHER_55.MID);
		// ProtocolTranslateImpl.addProtocol(ctx,
		// FOTILE.DEVICE_COOKER_12CC.MID);

		Monitoring.end("初始化完成");
		// 创建协议模块

		byte[] payload1 = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x01, 0x02, 0x02, 00, 00, 00, 00, 00, 00,
				(byte) 0x5e };
		byte[] payload2 = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x01, 0x01, 0x01, 00, 00, 00, 00, 00, 00,
				(byte) 0x5c };
		byte[] payload3 = { (byte) 0x48, (byte) 0x0E, 0x02, 0x01, 0x01, 0x01, 0x01, 0X02, 00, 00, 00, 00, 00,
				(byte) 0x5E };

		Monitoring.begin();
		String json3 = null;
		for (int i = 0; i < 100000; i++) {
			// String json1 = ProtocolTranslateImpl.getTranslateJson(ctx,
			// JOYOUNG.DEVICE_LED_1X.MID, payload1);
			// String json2 = ProtocolTranslateImpl.getTranslateJson(ctx,
			// GREE.DEVICE_WASHER_55.MID, payload2);
			json3 = ProtocolTranslateImpl.getTranslateJson(JOYOUNG.DEVICE_LED_1X.MID, payload3);
		}
		// String json2 = ProtocolTranslateImpl.getTranslateJson(
		// JOYOUNG.DEVICE_LED_1X.MID + 1, payload3);
		Monitoring.end("翻译时间");

		// System.out.println(json1);
		// System.out.println(json2);
		System.out.println(json3);
	}

	@Test
	public void testPtch() {
		// 取得根目录路径
		String rootPath = getClass().getResource("/").getFile().toString();

		String currentPath1 = getClass().getResource(".").getFile().toString();
		String currentPath2 = getClass().getResource("").getFile().toString();

		String parentPath = getClass().getResource("../").getFile().toString();
		System.out.println("rootPath--:" + rootPath);
		System.out.println("currentPath1--:" + currentPath1);
		System.out.println("currentPath2--:" + currentPath2);
		System.out.println("parentPath--:" + parentPath);

		File file = new File("src");
		System.out.println("file--:" + file.getAbsolutePath());
		try {
			System.out.println("file--:" + file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("file--:" + file.getPath());

		System.out.println("user.dir:" + System.getProperty("user.dir"));

	}
	
	@Test
	public void testxml(){
		ProtocolTranslateImpl.addProtocolModule(JOYOUNG.DEVICE_LED_1X.MID, JOYOUNG.DEVICE_LED_1X.PROTOCOL);
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("ApplicationContext.xml");

		ProtocolModule protocolModule = (ProtocolModule) ProtocolTranslateImpl.ctx.getBean(JOYOUNG.DEVICE_LED_1X.MID);
		// System.out.println("cid:" + protocolModule.getCid());
		// System.out.println("protocolModule:" + protocolModule.toString());
		// ObjectMapper mapper = new ObjectMapper();
		// // 为空值不输出
		// mapper.setSerializationInclusion(Include.NON_EMPTY);
		// String ss = null;
		// try {
		// ss = mapper.writeValueAsString(protocolModule);
		// } catch (JsonProcessingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("ss1:" + ss);
		//
		
		File file = new File("xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ProtocolModule.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//String mid = "person";
			// jaxbMarshaller.marshal(student, file);

			jaxbMarshaller.marshal(protocolModule, new FileOutputStream(file.getAbsolutePath() + "/" + protocolModule.getMid() + ".xml"));

			//System.out.println("path---:" + file.getAbsolutePath());
			//jaxbMarshaller.marshal(person, System.out);
			ProtocolModule read = (ProtocolModule) unmarshaller
					.unmarshal(new FileInputStream(file.getAbsolutePath() + "/" + protocolModule.getMid() + ".xml"));
			System.out.println(read.getProtocol().get(0).getDesc());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testxml2(){
		List<String> list = new ArrayList<String>();
		ListMid listMid = new ListMid();
		
		
		list.add("123");
		list.add("456");
		listMid.setCount(list.size());
		listMid.setMids(list);
		
		File file = new File("xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ListMid.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//String mid = "person";
			// jaxbMarshaller.marshal(student, file);

			jaxbMarshaller.marshal(listMid, new FileOutputStream(file.getAbsolutePath() + "/" + "listmid" + ".xml"));

			//System.out.println("path---:" + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
