package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class Protocol {

	private String name;
	private String cmd;
	private String desc;
	private String protocol_type;
	private List<Field> fields = new ArrayList<Field>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getProtocol_type() {
		return protocol_type;
	}
	public void setProtocol_type(String protocol_type) {
		this.protocol_type = protocol_type;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	

	
}
