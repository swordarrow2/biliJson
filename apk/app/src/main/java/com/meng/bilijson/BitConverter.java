package com.meng.bilijson;

import java.io.*;

public class BitConverter {
	public static final String DEFAULT_ENCODING = "UTF-8";

	public static byte[] getBytes(short s) {
		byte[] bs=new byte[2];
		bs[0] = (byte) ((s >> 0) & 0xff);
		bs[1] = (byte) ((s >> 8) & 0xff) ;
		return bs;	
	}

	public static byte[] getBytes(int i) {
		byte[] bs=new byte[4];
		bs[0] = (byte) ((i >> 0) & 0xff);
		bs[1] = (byte) ((i >> 8) & 0xff);
		bs[2] = (byte) ((i >> 16) & 0xff);
		bs[3] = (byte) ((i >> 24) & 0xff);
		return bs;	
	}

	public static byte[] getBytes(long l) {
		byte[] bs=new byte[8];
		bs[0] = (byte) ((l >> 0) & 0xff);
		bs[1] = (byte) ((l >> 8) & 0xff);
		bs[2] = (byte) ((l >> 16) & 0xff);
		bs[3] = (byte) ((l >> 24) & 0xff);
		bs[4] = (byte) ((l >> 32) & 0xff);
		bs[5] = (byte) ((l >> 40) & 0xff);
		bs[6] = (byte) ((l >> 48) & 0xff);
		bs[7] = (byte) ((l >> 56) & 0xff);
		return bs;
	}

	public static byte[] getBytes(float f) {
		int i = Float.floatToIntBits(f);
		byte[] bs=new byte[4];
		bs[0] = (byte) ((i >> 24) & 0xff);
		bs[1] = (byte) ((i >> 16) & 0xff);
		bs[2] = (byte) ((i >> 8) & 0xff);
		bs[3] = (byte) ((i >> 0) & 0xff);
		return bs;	
	}

	public static byte[] getBytes(double d) {
		long l = Double.doubleToLongBits(d);
		byte[] bs = new byte[8];
		bs[0] = (byte) ((l >> 56) & 0xff);
		bs[1] = (byte) ((l >> 48) & 0xff);
		bs[2] = (byte) ((l >> 40) & 0xff);
		bs[3] = (byte) ((l >> 32) & 0xff);
		bs[4] = (byte) ((l >> 24) & 0xff);
		bs[5] = (byte) ((l >> 16) & 0xff);
		bs[6] = (byte) ((l >> 8) & 0xff);
		bs[7] = (byte) ((l >> 0) & 0xff);
		return bs;
	}

	public static byte[] getBytes(String s) {
		try {
			return s.getBytes(DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static short toShort(byte[] data, int pos) {
		return (short) ((data[pos] & 0xff) << 0 | (data[pos + 1] & 0xff) << 8);
	}

	public static short toShort(byte[] data) {
		return toShort(data , 0);
	}

	public static int toInt(byte[] data, int pos) {
		return (data[pos] & 0xff) << 0 | (data[pos + 1] & 0xff) << 8 | (data[pos + 2] & 0xff) << 16 | (data[pos + 3] & 0xff) << 24;
	}

	public static int toInt(byte[] data) {
		return toInt(data, 0);
	}

	public static long toLong(byte[] data, int pos) {
		return ((data[pos] & 0xffL) << 0) | (data[pos + 1] & 0xffL) << 8 | (data[pos + 2] & 0xffL) << 16 | (data[pos + 3] & 0xffL) << 24 | (data[pos + 4] & 0xffL) << 32 | (data[pos + 5] & 0xffL) << 40 | (data[pos + 6] & 0xffL) << 48 | (data[pos + 7] & 0xffL) << 56;
	}

	public static long toLong(byte[] data) {
		return toLong(data , 0);
	}

	public static float toFloat(byte[] data, int pos) {
		int i= (data[pos] & 0xff) << 24 | (data[pos + 1] & 0xff) << 16 | (data[pos + 2] & 0xff) << 8 | (data[pos + 3] & 0xff) << 0;
		return Float.intBitsToFloat(i);
	}

	public static float toFloat(byte[] data) {
		return toFloat(data , 0);
	}

	public static double toDouble(byte[] data, int pos) {
		long l = ((data[pos] & 0xffL) << 56) | (data[pos + 1] & 0xffL) << 48 | (data[pos + 2] & 0xffL) << 40 | (data[pos + 3] & 0xffL) << 32 | (data[pos + 4] & 0xffL) << 24 | (data[pos + 5] & 0xffL) << 16 | (data[pos + 6] & 0xffL) << 8 | (data[pos + 7] & 0xffL) << 0;
		return Double.longBitsToDouble(l);
	}

	public static double toDouble(byte[] data) {
		return toDouble(data , 0);
	}

	public static String toString(byte[] data, int pos, int byteCount) {
		try {
			return new String(data, pos, byteCount, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toString(byte[] data) {
		return toString(data, 0, data.length);
	}
}
