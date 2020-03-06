package com.meng.bilijson.content;

import com.meng.bilijson.*;

public class HttpLink extends Content {
	
	public HttpLink() {

	}

	public HttpLink(String s) {
		content = s.getBytes();
	}

	@Override
	public byte type() {
		return ContentType.Link.value();
	}
}
