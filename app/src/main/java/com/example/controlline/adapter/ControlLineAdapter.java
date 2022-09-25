package com.example.controlline.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.controlline.R;
import com.example.controlline.bean.ControlLine;

import java.util.List;

public class ControlLineAdapter extends BaseAdapter {
    private Context context;
    private List<ControlLine> controlLineList;

    public ControlLineAdapter(Context context, List<ControlLine> controlLineList) {
        this.context = context;
        this.controlLineList = controlLineList;
    }

    @Override
    public int getCount() {
        return controlLineList.size();
    }

    @Override
    public Object getItem(int position) {
        return controlLineList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_item_control_line,null,false);
            if(position%2==0){
                convertView.setBackgroundColor(Color.argb(200,220,230,240));
            }else{
                convertView.setBackgroundColor(Color.argb(51,170,187,204));
            }

            holder.year = (TextView) convertView.findViewById(R.id.year);
            holder.category = (TextView) convertView.findViewById(R.id.category);
            holder.batch = (TextView) convertView.findViewById(R.id.batch);
            holder.controlLine = (TextView) convertView.findViewById(R.id.controlLine);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.year.setText(controlLineList.get(position).getControlYear()+"");

        holder.category.setText(controlLineList.get(position).getCategoryName()+"");

        holder.batch.setText(controlLineList.get(position).getBatchName()+"");

        holder.controlLine.setText(controlLineList.get(position).getControlLine()+"");
        return convertView;
    }

    public final class  ViewHolder{
        public TextView year;
        public TextView category;
        public TextView batch;
        public TextView controlLine;
    }
}
