package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class Protocol {

	private String name;
	private String cmd;
	private String desc;
	private String frame_type;
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
	public String getFrame_type() {
		return frame_type;
	}
	public void setFrame_type(String frame_type) {
		this.frame_type = frame_type;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	
}
