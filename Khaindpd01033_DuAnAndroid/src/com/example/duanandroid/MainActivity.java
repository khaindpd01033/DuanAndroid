package com.example.duanandroid;

import com.example.chuyenmuc.GioithieuActivity;
import com.example.chuyenmuc.GopyActivity;
import com.example.chuyenmuc.DetailActivity;
import com.example.chuyenmuc.HistoryActivity;
import com.example.chuyenmuc.YeuThichActivity;

import com.example.parser.ListEntry;
import com.example.parser.ParseXml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan.Concrete;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	public static ListEntry listRssItem;
	private String urlSK = "http://meovathay.edu.vn/suc-khoe/feed/";
	private String urlNau = "http://meohay.com/c/am-thuc/meo-nau-an/nau-an-ngon/feed/";
	private String urlDep = "http://meohay.edu.vn/lam-dep/feed/";
	private String urlDon = "http://meohay.com/c/nha-cua/don-dep-nha-cua/feed/";
	private String urlDo = "http://meohay.edu.vn/do-dung/feed/";
	private String urlCongNghe = "http://meohay.com/c/cong-nghe/feed/";
	private String urlPhuKien = "http://meohay.com/c/thoi-trang/phu-kien/feed/";
	private String urlDoUong = "http://meohay.com/c/am-thuc/do-uong/feed/";

	Button btnsuckhoe, btnhistory, btnyethich, btnnaunuong, btnquavadoan,
			btnsacdep, btndodunggd, btnvesinh, btnvanphong, btnquanao, btngopy,
			btngioithieu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnsuckhoe = (Button) findViewById(R.id.btnsuckhoe);
		btnhistory = (Button) findViewById(R.id.btnhistory);
		btnyethich = (Button) findViewById(R.id.btnyeuthich);
		btnnaunuong = (Button) findViewById(R.id.btnnaunuong);
		btnquavadoan = (Button) findViewById(R.id.btnQuavadoan);
		btnsacdep = (Button) findViewById(R.id.btnsacdep);
		btndodunggd = (Button) findViewById(R.id.btndodunggd);
		btnvesinh = (Button) findViewById(R.id.btnvesinh);
		btnvanphong = (Button) findViewById(R.id.btnvanphong);
		btnquanao = (Button) findViewById(R.id.btnquanao);
		btngopy = (Button) findViewById(R.id.btngopy);
		btngioithieu = (Button) findViewById(R.id.btngioithieu);
		btnhistory.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						HistoryActivity.class);
				startActivity(intent);
			}
		});
		btnsuckhoe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlSK);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnnaunuong.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlNau);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnquavadoan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlDoUong);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnsacdep.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlDep);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnyethich.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						YeuThichActivity.class);
				startActivity(intent);
			}
		});
		btndodunggd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlDo);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnvesinh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlDon);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnvanphong.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlCongNghe);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});

		btnquanao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(urlPhuKien);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"
							+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});
		btngopy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						GopyActivity.class);
				startActivity(intent);
			}
		});
		btngioithieu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, GioithieuActivity.class);
				startActivity(intent);

			}
		});

	}

}
