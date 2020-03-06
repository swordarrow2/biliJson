package com.meng.bilijson.content;

public abstract class Content {

	protected byte[] content;

	public abstract byte type();

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] array) {
		content = array;
	}

	public int length() {
		return content.length;
	}
}
