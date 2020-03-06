package com.meng.bilijson.content;

import com.meng.bilijson.*;

public class NormalText extends Content {

	public NormalText(){
		
	}
	
	public NormalText(String s) {
		content = s.getBytes();
	}

	@Override
	public byte type() {
		return ContentType.NormalText.value();
	}
}
