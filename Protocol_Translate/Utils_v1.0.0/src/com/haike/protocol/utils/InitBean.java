package com.haike.protocol.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class InitBean {

  private static Map<String, Protocol> protocolMap = new HashMap<String, Protocol>();
  private static ObjectMapper mapper = new ObjectMapper();
  
	public static Protocol getProtocol(String beanName) {	
		Protocol protocol = protocolMap.get(beanName);
		
		return protocol;
	}
	
	public static void addProtocol(String mid,String json){
//		Protocol protocol = JSON.parseObject(json, Protocol.class);
		Protocol protocol = null;
		try {
			protocol = mapper.readValue(json, Protocol.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		protocolMap.put(mid, protocol);
	}
}
