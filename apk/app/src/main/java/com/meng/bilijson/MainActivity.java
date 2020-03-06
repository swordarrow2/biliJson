package com.meng.bilijson;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.io.*;
import com.meng.bilijson.content.*;
import android.view.View.*;
import android.view.*;
import android.text.util.*;
import android.graphics.*;

public class MainActivity extends Activity {

	private Button btn;
	private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.mainButton);
		ll = (LinearLayout) findViewById(R.id.mainLinearLayout);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1) {
					load();
					Toast.makeText(MainActivity.this, "reloaded", Toast.LENGTH_SHORT).show();
				}
			});
		load();
    }

	private void load() {
		ll.removeAllViews();
		FilePack fp=new FilePack();
		try {
			fp.readFromFile(new File("/storage/emulated/0/AppProjects/BJSON/1.hex"));
		} catch (IOException e) {}
		for (Content c:fp.contents) {
			switch (ContentType.valueOf(c.type())) {
				case Title:
					TextView tv=(TextView) getLayoutInflater().inflate(R.layout.large_text, null);
					tv.setTextAppearance(android.R.attr.textAppearanceLarge);
					tv.setText(new String(c.getContent()));
					ll.addView(tv);
					break;
				case SmallTitle:
					TextView tv2=new TextView(this);
					tv2.setTextAppearance(android.R.attr.textAppearanceMedium);
					tv2.setText(new String(c.getContent()));
					ll.addView(tv2);
					break;	
				case Link:
					TextView tv3=new TextView(this);
					tv3.setAutoLinkMask(0);
					tv3.setText(new String(c.getContent()));
					ll.addView(tv3);
					break;
				case Jpg:
					Bitmap jpg=BitmapFactory.decodeByteArray(c.getContent(), 0, c.getContent().length);
					ImageView iv=new ImageView(this);
					iv.setImageBitmap(jpg);
					ll.addView(iv);
					break;
				case Json:
					TextView tv4=new TextView(this);
					tv4.setTextAppearance(android.R.attr.textAppearanceSmall);
					tv4.setTextColor(Color.argb(0xff, 0x7f, 0xca, 0x00));
					tv4.setText(new String(c.getContent()));
					ll.addView(tv4);
					break;	
				case NormalText:
					TextView tv5=new TextView(this);
					tv5.setTextAppearance(android.R.attr.textAppearanceSmall);
					tv5.setText(new String(c.getContent()));
					ll.addView(tv5);
					break;
				case Param:
					TextView tv6=new TextView(this);
					tv6.setTextColor(Color.CYAN);
					tv6.setTextAppearance(android.R.attr.textAppearanceMedium);
					tv6.setText(new String(c.getContent()));
					ll.addView(tv6);
					break;
				case Png:
					Bitmap png=BitmapFactory.decodeByteArray(c.getContent(), 0, c.getContent().length);
					ImageView iv2=new ImageView(this);
					iv2.setImageBitmap(png);
					ll.addView(iv2);
					break;
				case Warning:
					TextView tv7=new TextView(this);
					tv7.setTextColor(Color.RED);
					tv7.setTextAppearance(android.R.attr.textAppearanceLarge);
					tv7.setText(new String(c.getContent()));
					ll.addView(tv7);
					break;
			}
		}
	}
}
