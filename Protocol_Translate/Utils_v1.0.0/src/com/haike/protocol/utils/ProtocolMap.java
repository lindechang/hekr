package com.haike.protocol.utils;

import java.util.HashMap;
import java.util.Map;

public class ProtocolMap {

	private static Map<String, Protocol> protocols = new HashMap<String, Protocol>();

	public static Map<String, Protocol> getProtocols() {
		return protocols;
	}

	public static void setProtocols(Map<String, Protocol> protocols) {
		ProtocolMap.protocols = protocols;
	}

	public Protocol getProtocol(String mid) {
		return protocols.get(mid);
	}

	public void setProtocol(String mid, Protocol protocol) {
		protocols.put(mid, protocol);
	}

}
