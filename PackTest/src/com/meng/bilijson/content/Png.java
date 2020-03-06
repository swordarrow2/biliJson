package com.meng.bilijson.content;

import com.meng.bilijson.*;
import java.io.*;

public class Png extends Content {

	public Png() {

	}

	public Png(File pngFile) throws IOException {
		content = new byte[(int)pngFile.length()];
		FileInputStream fis = new FileInputStream(pngFile);
		fis.read(content);
	}

	@Override
	public byte type() {
		return ContentType.Png.value();
	}
}
