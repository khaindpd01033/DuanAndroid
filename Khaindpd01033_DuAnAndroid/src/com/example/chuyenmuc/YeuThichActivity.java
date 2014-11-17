package com.example.chuyenmuc;

import java.util.ArrayList;
import java.util.List;

import com.example.duanandroid.R;
import com.example.duanandroid.R.id;
import com.example.duanandroid.R.layout;
import com.example.parser.AdapterHistiry;
import com.example.parser.AdapterYeuThich;
import com.example.parser.Entry;
import com.example.parser.History;
import com.example.parser.YeuThich;
import com.google.android.gms.internal.lv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class YeuThichActivity extends Activity {
	public static List<YeuThich> arraya = new ArrayList<YeuThich>();
	AdapterYeuThich adaptera;
	ListView lvday;
	ImageButton btnxoa, btnback;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yeu_thich);
		lvday=(ListView)findViewById(R.id.listDSa);
		btnxoa=(ImageButton)findViewById(R.id.btnDeleteAll);
		btnback=(ImageButton)findViewById(R.id.btnBack);
		adaptera = new AdapterYeuThich(this,arraya);
		adaptera.notifyDataSetChanged();
		lvday.setAdapter(adaptera);
		btnback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		lvday.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
				startActivity(intent);
				WebviewActivity.data=arraya.get(position).getTitle();
				WebviewActivity.URL = arraya.get(position).getLink();
			}
		});
		lvday.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int pro, long arg3) {
				YeuThich items= arraya.get(pro);
				arraya.remove(items);
				adaptera = new AdapterYeuThich(YeuThichActivity.this,arraya);
				lvday.setAdapter(adaptera);
				Toast.makeText(getApplicationContext(),
						"Xoá Thành Công!",
						Toast.LENGTH_SHORT).show();
				return false;
			}
			
		});
		btnxoa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				// set title
				alertDialogBuilder.setTitle("Thông Báo");

				// set dialog message
				alertDialogBuilder
						.setMessage("Bạn chắc chắn xóa!")
						.setCancelable(false)
						.setPositiveButton("Đồng ý",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										arraya.removeAll(arraya);
										// db.deleteSV(arraySV.get(_id));
										Toast.makeText(getApplicationContext(),
												"Xoá Thành Công!",
												Toast.LENGTH_SHORT).show();
										// listLop.notify();
										// arraySV = db.getAllSinhVien();
										adaptera = new AdapterYeuThich(
												YeuThichActivity.this,
												arraya);
										lvday.setAdapter(adaptera);
									}
								})
						.setNegativeButton("Hủy",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										Toast.makeText(getApplicationContext(),
												"Hủy xóa!", Toast.LENGTH_SHORT)
												.show();
										dialog.cancel();
									}
								});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
			}
		});
	}
}
