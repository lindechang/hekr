package com.haike.protocol.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mids")
public class ListMid {
	
	private int count ;
	private List<String> mids = new ArrayList<String>() ;
	public int getCount() {
		return count;
	}
	@XmlAttribute
	public void setCount(int count) {
		this.count = count;
	}
	public List<String> getMids() {
		return mids;
	}
    @XmlElement(name = "mid")
	public void setMids(List<String> mids) {
		this.mids = mids;
	}
	
	
	

}
