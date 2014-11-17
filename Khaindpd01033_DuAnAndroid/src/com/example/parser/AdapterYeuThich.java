package com.example.parser;

import java.util.List;

import com.example.duanandroid.R;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterYeuThich extends BaseAdapter {

	List<YeuThich> arraya;

	public Activity context;
	public LayoutInflater inflater;
	private SparseBooleanArray mSelectedItemsIds;

	public AdapterYeuThich(Activity context, List<YeuThich> arraya) {
		super();
		mSelectedItemsIds = new SparseBooleanArray();
		this.context = context;
		this.arraya = arraya;

		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arraya.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arraya.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {
		ImageView imgLogoTaxi;
		TextView txtNameTaxi;
		TextView txtPhoneTaxi;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.viewtaxi, null);

			holder.imgLogoTaxi = (ImageView) convertView
					.findViewById(R.id.imgLogoTaxi);
			holder.txtNameTaxi = (TextView) convertView
					.findViewById(R.id.txtNameTaxi);

			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		YeuThich _entry = (YeuThich) arraya.get(position);
		// holder.imgLogoTaxi.setImageResource(_entry.getLogoTaxi());
		holder.txtNameTaxi.setText(_entry.getTitle());
		// holder.txtPhoneTaxi.setText(_entry.getDescription());

		return convertView;
	}

	public void remove(YeuThich object) {
		arraya.remove(object);
		notifyDataSetChanged();
	}

	public List<YeuThich> getEntries() {
		return arraya;
	}

	public void toggleSelection(int position) {
		selectView(position, !mSelectedItemsIds.get(position));
	}

	public void removeSelection() {
		mSelectedItemsIds = new SparseBooleanArray();
		notifyDataSetChanged();
	}

	public void selectView(int position, boolean value) {
		if (value)
			mSelectedItemsIds.put(position, value);
		else
			mSelectedItemsIds.delete(position);
		notifyDataSetChanged();
	}

	public int getSelectedCount() {
		return mSelectedItemsIds.size();
	}

	public SparseBooleanArray getSelectedIds() {
		return mSelectedItemsIds;
	}

}
