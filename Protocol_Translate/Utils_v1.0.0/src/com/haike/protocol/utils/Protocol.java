package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

public class Protocol {

	private String status;
	private int version;
	private List<Comment> frametype = new ArrayList<Comment>();
	private List<Data> data = new ArrayList<Data>();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public List<Comment> getFrametype() {
		return frametype;
	}

	public void setFrametype(List<Comment> frametype) {
		this.frametype = frametype;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
  
	public void init() {
		setStatus("edited");
		System.out.println("init...");
	}
	
	@Override
	public String toString() {
		return "Protocol [status=" + status + ", version=" + version
				+ ", data=" + data + "]";
	}
	//
	// public void destory(){
	// System.out.println("destory...");
	// }
}
