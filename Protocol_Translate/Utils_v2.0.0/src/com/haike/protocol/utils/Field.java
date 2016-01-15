package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Field {
	
	private String name;
	private String desc;
	private String data_type;
	private String data_length;
	private String unit;
	private String unit_f;
	private String max;
	private String min;
	private List<Enumeration> enumeration = new ArrayList<Enumeration>();
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	@XmlElement
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getData_type() {
		return data_type;
	}
	@XmlElement
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getData_length() {
		return data_length;
	}
	@XmlElement
	public void setData_length(String data_length) {
		this.data_length = data_length;
	}
	public String getUnit() {
		return unit;
	}
	@XmlElement
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit_f() {
		return unit_f;
	}
	@XmlElement
	public void setUnit_f(String unit_f) {
		this.unit_f = unit_f;
	}
	public String getMax() {
		return max;
	}
	@XmlElement
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	@XmlElement
	public void setMin(String min) {
		this.min = min;
	}
	@XmlElementWrapper(name = "enumerations")
	@XmlElement(name = "enumeration")
	public List<Enumeration> getEnumeration() {
		return enumeration;
	}
	public void setEnumeration(List<Enumeration> enumeration) {
		this.enumeration = enumeration;
	}
	
	
	
	
	
		
}
