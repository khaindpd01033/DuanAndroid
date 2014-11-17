package com.example.chuyenmuc;

import java.util.ArrayList;
import java.util.List;

import com.example.duanandroid.R;
import com.example.parser.AdapterHistiry;
import com.example.parser.AdapterYeuThich;
import com.example.parser.History;
import com.example.parser.YeuThich;

import SQLite.DatabaseHandler;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WebviewActivity extends Activity {
	public static String URL="";
	public static String data="";
	AdapterHistiry adapter;
	AdapterYeuThich adaptery;
	Button btnyeuthich;
	DatabaseHandler db = new DatabaseHandler(WebviewActivity.this);
	public static  List<History> array = new ArrayList<History>();
	public static  List<YeuThich> arraya = new ArrayList<YeuThich>();
	WebView webview ;
	TextView lbltitle;
	YeuThich YeuThich = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		webview = (WebView) findViewById(R.id.webview);
		lbltitle=(TextView)findViewById(R.id.lbltitle);
		btnyeuthich=(Button)findViewById(R.id.btnyeuthich);
		btnyeuthich.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {	
				// TODO Auto-generated method stub
				db.addThemYeuThich(new YeuThich(data,URL));
				YeuThichActivity.arraya.add(new YeuThich(data, URL));
				Toast.makeText(getApplicationContext(), "Đã Thêm Mục Yêu Thích!",
						Toast.LENGTH_SHORT).show();
			}
		});
		lbltitle.setText(data);
		adapter = new AdapterHistiry(this, array);
		HistoryActivity.array.add(new History(data,URL));
		webview.getSettings().setJavaScriptEnabled(true);
		//webview.loadData(data, "text/html; charset=UTF-8", null);
		webview.loadUrl(URL);
	}


}
