package com.meng.bilijson.content;

public enum ContentType {
	Title(0x0),
	SmallTitle(0x1),
	NormalText(0x2),
	Link(0x3),
	Json(0x4),
	Param(0x5),
	Warning(0x6),
	Jpg(0x7),
	Png(0x8);

	private byte type;

	public ContentType(int b){
		type=(byte)b;
	}

	public byte value(){
		return type;
	}

	public static ContentType valueOf(byte b){
		switch(b){
			case 0:
				return Title;
			case 1:
				return SmallTitle;
			case 2:
				return NormalText;
			case 3:
				return Link;
			case 4:
				return Json;
			case 5:
				return Param;
			case 6:
				return Warning;
			case 7:
				return Jpg;
			case 8:
				return Png;
			default:
				return null;
		}
	}
}
