package com.meng.bilijson.content;
import com.meng.bilijson.*;
import java.io.*;

public class JsonContent extends Content {

	public JsonContent() {

	}

	public JsonContent(File jsonFile) throws IOException {
		content = new byte[(int)jsonFile.length()];
		FileInputStream fis = new FileInputStream(jsonFile);
		fis.read(content);
	}

	@Override
	public byte type() {
		return ContentType.Json.value();
	}
}
