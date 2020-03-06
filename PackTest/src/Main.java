import java.util.*;
import com.meng.bilijson.*;
import com.meng.bilijson.content.*;
import java.io.*;

public class Main {
	public static FilePack fp=new FilePack();

	public static void main(String[] args) {
		addContent(new TitleText("此生无悔入东方 来世愿生幻想乡"));
		addContent(new SmallTitle("🎵Pure Furies ~ 心の在処"));
		addContent(new NormalText("此生无悔入东方 来世愿生幻想乡 红魔地灵夜神雪 永夜风神星莲船 非想天则文花贴 萃梦神灵绯想天 冥界地狱异变起 樱下华胥主谋现 净罪无改渡黄泉 华鸟风月是非辨 境界颠覆入迷途 幻想花开啸风弄 二色花蝶双生缘 前缘未尽今生还 星屑洒落雨霖铃 虹彩彗光银尘耀 无寿迷蝶彼岸归 幻真如画妖如月 永劫夜宵哀伤起 幼社灵中幻似梦 追忆往昔巫女缘 须弥之间冥梦现 仁榀华诞井中天 歌雅风颂心无念"));
		try {
			addContent(new Png(new File("/storage/emulated/0/Pictures/-792c38e1cb9c39f4.jpg")));
			addContent(new HttpLink("https://api.live.bilibili.com/sign/doSign"));
			addContent(new JsonContent(new File("/storage/emulated/0/AppProjects/bilibili/j.json")));
		} catch (IOException e) {}

		System.out.println(fp.getLength());
		save("1.hex");
		FilePack fp2=new FilePack(new File("/storage/emulated/0/AppProjects/BJSON/1.hex"));
	}

	public static void addContent(Content c) {
		fp.contents.add(c);
	}

	public static void save(String name) {
		try {
			fp.writeToFile(new File("/storage/emulated/0/AppProjects/BJSON/" + name));
		} catch (IOException e) {}
	}

	public static File getFile(String name) {
		return new File("/storage/emulated/0/AppProjects/BJSON/" + name);
	}
}
