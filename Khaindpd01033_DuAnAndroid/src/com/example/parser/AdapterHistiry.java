package com.example.parser;

import java.util.List;

import com.example.duanandroid.R;
import com.example.parser.Entry;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterHistiry extends BaseAdapter{
	
	List<History> array;
 
    public Activity context;
    public LayoutInflater inflater;
    private SparseBooleanArray mSelectedItemsIds;
    public AdapterHistiry(Activity context,List<History> array) {
        super();
        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.array = array;
        
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return array.size();
    }
 
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return array.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
 
    public static class ViewHolder
    {
        ImageView imgLogoTaxi;
        TextView txtNameTaxi;
        TextView txtPhoneTaxi;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
 
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.viewtaxi, null);
 
            holder.imgLogoTaxi = (ImageView) convertView.findViewById(R.id.imgLogoTaxi);
            holder.txtNameTaxi = (TextView) convertView.findViewById(R.id.txtNameTaxi);
 
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
 
        History _entry = (History) array.get(position);        
//	        holder.imgLogoTaxi.setImageResource(_entry.getLogoTaxi());
	        holder.txtNameTaxi.setText(_entry.getTitle());
//	        holder.txtPhoneTaxi.setText(_entry.getDescription());
	 
	        return convertView;
    }

    public void remove(History object) {
        array.remove(object);
        notifyDataSetChanged();
    }
 
    public List<History> getEntries() {
        return array;
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
