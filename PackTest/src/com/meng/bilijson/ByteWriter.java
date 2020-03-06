package com.meng.bilijson;

public class ByteWriter {

	public byte[] fileByte;
	public int position = 0;

	public ByteWriter(int len) {
		fileByte = new byte[len];
	}

	public ByteWriter write(byte b) {
		fileByte[position++] = b;
		return this;
	}

	public ByteWriter write(int i) {
		byte[] b=BitConverter.getBytes(i);
		fileByte[position++] = b[0];
		fileByte[position++] = b[1];
		fileByte[position++] = b[2];
		fileByte[position++] = b[3];
		return this;
	}

	public ByteWriter write(byte[] array) {
		for (int i = 0; i < array.length; ++i) {
			fileByte[position++] = array[i];
		}
		return this;
	}

	public ByteWriter write(byte[] array, int offset) {
		for (int i = 0; i < array.length; ++i) {
			fileByte[offset + i] = array[i];
		}
		return this;
	}

	public byte[] getBytes() {
		return fileByte;
	}
}
