package com.meng.bilijson.content;

import com.meng.bilijson.*;

public class Warning extends Content {
	
	public Warning() {

	}

	public Warning(String s) {
		content = s.getBytes();
	}

	@Override
	public byte type() {
		return ContentType.Warning.value();
	}
}
