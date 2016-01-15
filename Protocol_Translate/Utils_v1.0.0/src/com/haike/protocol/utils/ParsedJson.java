package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class ParsedJson {
	
	private String status;
	private String frametype;
	private String serialnumber;
	private String code;
	private List<Command> cmds = new ArrayList<Command>();
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFrametype() {
		return frametype;
	}
	public void setFrametype(String frametype) {
		this.frametype = frametype;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Command> getCmds() {
		return cmds;
	}
	public void setCmds(List<Command> cmds) {
		this.cmds = cmds;
	}
	
	
	
		

}
