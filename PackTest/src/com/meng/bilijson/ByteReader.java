package com.meng.bilijson;

public class ByteReader {

	public byte[] fileByte;
	public int position = 0;

	public ByteReader(byte[] bs) {
		fileByte = bs;
	}

	public boolean hasNext() {
		return position < fileByte.length;
	}

	public byte readByte() {
        return fileByte[position++];
    }

	public int readInt() {
        int i = BitConverter.toInt(fileByte, position);
		position += 4;
		return i;
    }

	public byte[] readArray(int len) {
		byte[] arr=new byte[len];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = readByte();
        }
		return arr;
    }
}
