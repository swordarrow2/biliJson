package com.meng.bilijson;

public class ArrayTool {
	public static byte[] mergeArray(byte[]... arrays) {
		int allLen=0;
		for (byte[] bs:arrays) {
			allLen += bs.length;
		}
		byte[] finalArray=new byte[allLen];
		int flag=0;
		for (byte[] byteArray:arrays) {
			for (int i=0;i < byteArray.length;++flag,++i) {
				finalArray[flag] = byteArray[i];
			}
		}
		return finalArray;
	}
}
