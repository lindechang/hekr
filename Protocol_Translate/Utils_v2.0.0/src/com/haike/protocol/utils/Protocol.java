package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Protocol {

	private String name;
	private String cmd;
	private String desc;
	private String protocol_type;
	private List<Field> fields = new ArrayList<Field>();
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getCmd() {
		return cmd;
	}
	@XmlElement
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getDesc() {
		return desc;
	}
	@XmlElement
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getProtocol_type() {
		return protocol_type;
	}
	@XmlElement
	public void setProtocol_type(String protocol_type) {
		this.protocol_type = protocol_type;
	}
	@XmlElementWrapper(name = "fields")
	@XmlElement(name = "field")
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	

	
}
