package com.example.android_lab03;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MillToolAdapter extends BaseAdapter {

    List<MillTool> tools;
    private final LayoutInflater layoutInflater;

    public MillToolAdapter(Context context, List<MillTool> tools) {
        this.tools = tools;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tools.size();
    }

    @Override
    public Object getItem(int position) {
        return tools.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = layoutInflater.inflate(R.layout.tool_item_layout, parent, false);
        }

        MillTool tool = tools.get(position);
        TextView name = (TextView) view.findViewById(R.id.tool_name);
        TextView type = (TextView) view.findViewById(R.id.tool_type);
        TextView size = (TextView) view.findViewById(R.id.tool_size);
        TextView material = (TextView) view.findViewById(R.id.tool_material);

        name.setText("Найменування: " + tool.getName());
        type.setText("Тип: " + tool.getType());
        size.setText("Діаметер: " + tool.getSize());
        material.setText("Матеріал: " + tool.getMaterial());

        return view;
    }
}

