package com.meng.bilijson.content;

import com.meng.bilijson.*;
import java.io.*;

public class Jpg extends Content {
	
	public Jpg() {

	}

	public Jpg(File jpgFile) throws IOException {
		content = new byte[(int)jpgFile.length()];
		FileInputStream fis = new FileInputStream(jpgFile);
		fis.read(content);
	}
	
	@Override
	public byte type() {
		return ContentType.Jpg.value();
	}
}
