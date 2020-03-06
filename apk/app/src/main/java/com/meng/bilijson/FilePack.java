package com.meng.bilijson;

import com.meng.bilijson.content.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;

public class FilePack {
	private final int magic = 0x1060909;
	private int packVersion = 0x1;
	private int dataVersion = 0x1;
	private int length;
	private int hash = 9961;

	public ArrayList<Content> contents = new ArrayList<>();

	public FilePack() {

	}

	public FilePack(File file) {
		try {
			readFromFile(file);
		} catch (IOException e) {

		}
	}

	public void writeToFile(File file) throws IOException {
		byte[] fileBytes;
		length = getLength();
		ByteWriter bw=new ByteWriter(length);
		bw.write(magic).write(packVersion).write(dataVersion).write(length).write(hash);
		for (Content c:contents) {
			bw.write(c.type()).write(c.length()).write(c.getContent());
		}
		fileBytes = bw.getBytes();
		CRC32 crc32=new CRC32();
		crc32.update(fileBytes);
		byte[] bs=BitConverter.getBytes((int)crc32.getValue());
		fileBytes[16] = bs[0];
		fileBytes[17] = bs[1];
		fileBytes[18] = bs[2];
		fileBytes[19] = bs[3];
		FileOutputStream fos;
		fos = new FileOutputStream(file);
		fos.write(fileBytes);
		//	System.out.println("save"+(int)crc32.getValue());
	}

	public int getLength() {
		int len=20;
		for (Content c:contents) {
			len += c.length();
			len += 5;
		}
		return len;
	}

	public void readFromFile(File file) throws IOException {
		byte[] fileByte=new byte[(int)file.length()];
		FileInputStream fis=null;
		fis = new FileInputStream(file);
		fis.read(fileByte);
		ByteReader br = new ByteReader(fileByte);
		if (br.readInt() != magic) {
			System.out.println("bad magic number");
			return;
		}
		packVersion = br.readInt();
		dataVersion = br.readInt();
		length = br.readInt();
		hash = br.readInt();
		CRC32 crc32=new CRC32();
		fileByte[16] = (byte)0xe9;
		fileByte[17] = (byte)0x26;
		fileByte[18] = (byte)0x0;
		fileByte[19] = (byte)0x0;
		crc32.update(fileByte);
		if (((int)crc32.getValue()) != hash) {
			return;
		}
		if (packVersion == 0x1) {
			do{
				byte type=br.readByte();
				Content c = null;
				switch (ContentType.valueOf(type)) {
					case Title:
						c = new TitleText();
						break;
					case SmallTitle:
						c = new SmallTitle();
						break;	
					case Link:
						c = new HttpLink();
						break;
					case Jpg:
						c = new Jpg();
						break;
					case Json:
						c = new JsonContent();
						break;	
					case NormalText:
						c = new NormalText();
						break;
					case Param:
						c = new Param();
						break;
					case Png:
						c = new Png();
						break;
					case Warning:
						c = new Warning();
						break;
				}
				c.setContent(br.readArray(br.readInt()));
				contents.add(c);
			}while(br.hasNext());
		}
	}
}
