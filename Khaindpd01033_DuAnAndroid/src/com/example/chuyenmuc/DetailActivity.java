package com.example.chuyenmuc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.custom.CustomViewTinTuc;
import com.example.duanandroid.R;
import com.example.parser.Entry;
import com.example.parser.History;


import SQLite.DatabaseHandler;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends Activity {
	ListView listViewTinTuc;
	public static List<Entry> listTinTuc = new ArrayList<Entry>();
	CustomViewTinTuc adapter;
DatabaseHandler db = new DatabaseHandler(DetailActivity.this);
	// khai bao 1 "lop" object
	Entry items = null;
	ImageButton btnsuckhoe;
	TextView txtsuckhoe, txtname;
	TextView txtseach;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		btnsuckhoe=(ImageButton)findViewById(R.id.btnBack);
		txtsuckhoe=(TextView)findViewById(R.id.txtTitle1);
		txtname=(TextView)findViewById(R.id.txtNameTaxi);
		txtseach=(TextView)findViewById(R.id.editText1);
		listViewTinTuc = (ListView) findViewById(R.id.listviewTinTuc);
		
		btnsuckhoe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		adapter = new CustomViewTinTuc(this, listTinTuc);
		listViewTinTuc.setAdapter(adapter);
		
		listViewTinTuc.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
				startActivity(intent);
				WebviewActivity.data=listTinTuc.get(position).getTitle();
				WebviewActivity.URL = listTinTuc.get(position).getLink();
			}
		});
		txtseach.setText("Mẹo Vặt Cuộc Sống");
	}
	 
    // Not using options menu in this tutorial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    	}

}
