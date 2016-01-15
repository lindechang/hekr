package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class ParsedJson {
	
	private String mid;
	private String cid;
	private String pid;
    private String name;
    private String cmd;
    private String desc;
    private String frame_type;
    private List<ParsedField> fields = new ArrayList<ParsedField>();
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
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
	public List<ParsedField> getFields() {
		return fields;
	}
	public void setFields(List<ParsedField> fields) {
		this.fields = fields;
	}
    
    
	
	
	
	
	
	
	
		

}
