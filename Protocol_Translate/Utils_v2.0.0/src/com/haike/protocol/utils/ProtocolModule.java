package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"mid","cid","pid","createtime","protocol"})
@XmlRootElement
public class ProtocolModule {
	
	private String mid;
	private String cid;
	private String pid;
	private String createtime;
	private List<Protocol> protocol = new ArrayList<Protocol>();
	
	public String getMid() {
		return mid;
	}
	@XmlElement
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCid() {
		return cid;
	}
	@XmlElement
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	@XmlElement
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCreatetime() {
		return createtime;
	}
	@XmlElement
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public List<Protocol> getProtocol() {
		return protocol;
	}
	@XmlElementWrapper(name = "protocols")
	@XmlElement(name = "protocol")
	public void setProtocol(List<Protocol> protocol) {
		this.protocol = protocol;
	}
	@Override
	public String toString() {
		return "ProtocolModule [mid=" + mid + ", cid=" + cid + ", pid=" + pid + ", createtime=" + createtime
				+ ", protocol=" + protocol + "]";
	}

	
}
