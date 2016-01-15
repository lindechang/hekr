package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class ProtocolModule {
	
	private String mid;
	private String cid;
	private String pid;
	private String createtime;
	private List<Protocol> protocol = new ArrayList<Protocol>();
	
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public List<Protocol> getProtocol() {
		return protocol;
	}
	public void setProtocol(List<Protocol> protocol) {
		this.protocol = protocol;
	}
		
}
