package com.haike.protocol.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haike.protocol.utils.PROTOCOL_CONSTANT.JOYOUNG;
public class InitBean {

  private static Map<String, ProtocolModule> Map = new HashMap<String, ProtocolModule>();
  private static ObjectMapper mapper = new ObjectMapper();
  
 
  
	public static ProtocolModule getProtocolModuleBean(String beanName) {	
		ProtocolModule protocolModule = Map.get(beanName);
		
		return protocolModule;
	}
	
	public static void addProtocolModuleBean(String mid,String json){
        //Protocol protocol = JSON.parseObject(json, Protocol.class);
		ProtocolModule protocolModule = null;
		try {
			protocolModule = mapper.readValue(json, ProtocolModule.class);
			
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
		Map.put(mid, protocolModule);
	}
}
