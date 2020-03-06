package com.meng.bilijson.content;

import com.meng.bilijson.*;

public class Param extends Content {
	
	public Param() {

	}

	public Param(String s) {
		content = s.getBytes();
	}

	@Override
	public byte type() {
		return ContentType.Param.value();
	}
}
