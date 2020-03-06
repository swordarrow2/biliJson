package com.meng.bilijson.content;

import com.meng.bilijson.*;

public class SmallTitle extends Content {
	
	public SmallTitle(){

	}

	public SmallTitle(String s) {
		content = s.getBytes();
	}
	
	@Override
	public byte type() {
		return ContentType.SmallTitle.value();
	}
}
