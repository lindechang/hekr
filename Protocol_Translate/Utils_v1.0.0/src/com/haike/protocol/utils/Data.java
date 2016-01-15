package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	private String code;
	private String desc;
	private List<Field> fields = new ArrayList<Field>();
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	@Override
	public String toString() {
		return "Data [code=" + code + ", desc=" + desc + ", fields=" + fields
				+ "]";
	} 

	
}
