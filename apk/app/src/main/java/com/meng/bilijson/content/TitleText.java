package com.meng.bilijson.content;

import com.meng.bilijson.*;

public class TitleText extends Content {
	
	public TitleText(){

	}

	public TitleText(String s) {
		content = s.getBytes();
	}
	
	@Override
	public byte type() {
		return ContentType.Title.value();
	}
}
