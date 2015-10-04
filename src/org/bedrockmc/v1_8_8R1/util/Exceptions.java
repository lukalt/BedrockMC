package org.bedrockmc.v1_8_8R1.util;

public class Exceptions {

	public static void unimplemented() {
		throw new IllegalStateException("Not implemented yet.");
	}
	
	public static void removed() {
		throw new IllegalStateException("No longer supported");
	}
}
