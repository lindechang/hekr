package com.haike.protocol.utils;

public interface ProtocolTranslate {


	public void addProtocol(String json);

	public void addProtocol(Protocol protocol);

	public Protocol getProtocol(String mid);

	public String getJson(String mid,byte[] payload);

}
