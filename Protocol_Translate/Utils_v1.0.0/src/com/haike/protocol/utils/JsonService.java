package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonService {

	public JsonService() {
	}
		
	public List<Data> getDatas() {
		List<Data> datas = new ArrayList<Data>();
		List<Field> fields = new ArrayList<Field>();
		List<Comment> comments = new ArrayList<Comment>();
		
		Data data = new Data();
		Field field = new Field();
		Comment comment = new Comment();
		
		comment.setDesc("123");
		comments.add(comment);
		
		field.setComments(comments);
		
		data.setCode("ss");
		fields.add(field);
		
		data.setFields(fields);
		datas.add(data);
		return datas;
	}
	
	
	public List<Data> getDatas(Byte[] array) {
		List<Data> datas = new ArrayList<Data>();
		List<Field> fields = new ArrayList<Field>();
		
		
		Data data = new Data();
		
		Field field1 = new Field();
		Comment comment1 = new Comment();
		List<Comment> comments1 = new ArrayList<Comment>();
		field1.setId("5");
		field1.setDatatype("32");
		field1.setName("命令");
		field1.setLength("1");		
		comment1.setValue("2");
		comment1.setDesc("开关操作");
		comments1.add(comment1);
		field1.setComments(comments1);
		fields.add(field1);
		
		Field field2 = new Field();
		Comment comment2 = new Comment();
		List<Comment> comments2 = new ArrayList<Comment>();
		field2.setId("6");
		field2.setDatatype("32");
		field2.setName("开关状态");
		field2.setLength("1");
		comment2.setValue("1");
		comment2.setDesc("打开灯具");
		comments2.add(comment2);
		field2.setComments(comments2);
		fields.add(field2);
		
		
		Field field3 = new Field();
		Comment comment3 = new Comment();
		List<Comment> comments3 = new ArrayList<Comment>();
		field3.setId("7");
		field3.setDatatype("32");
		field3.setName("渐变");
		field3.setLength("1");
		comment3.setValue("0");
		comment3.setDesc("不渐变");
		comments3.add(comment3);
		field3.setComments(comments3);
		fields.add(field3);
		
		
		Field field4 = new Field();
		Comment comment4 = new Comment();
		List<Comment> comments4 = new ArrayList<Comment>();
		field4.setId("8");
		field4.setDatatype("32");
		field4.setName("亮度");
		field4.setLength("1");
		comment4.setValue("0");
		comment4.setDesc("忽略");
		comments4.add(comment4);
		field4.setComments(comments4);
		fields.add(field4);
		
		Field field5 = new Field();
		Comment comment5 = new Comment();
		List<Comment> comments5 = new ArrayList<Comment>();
		field5.setId("9");
		field5.setDatatype("32");
		field5.setName("色温");
		field5.setLength("1");
		comment5.setValue("0");
		comment5.setDesc("色温为2440K");
		comments5.add(comment5);
		field5.setComments(comments5);
		fields.add(field5);
		
		data.setFields(fields);
		datas.add(data);
		return datas;
	}

	
	public Protocol getProtocol(String mid){
		
		Map<String, Protocol> map = new HashMap<String, Protocol>();
		
		Protocol protocol = new Protocol();
		
		map.put("led", protocol);
		
		
		return null;
		
	}
	
	public String hsexToJson(byte[] payload){
		return null;		
	}
	
}
