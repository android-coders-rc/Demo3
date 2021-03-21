package com.example.android.demo3.Fragments;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.demo3.R;

public class MainAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private int[] images;
    private String[] msg;

    public MainAdapter(Context c,int[] data,String[] text)
    {
        context = c;
        images = data;
        msg = text;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
        {
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_item,null);
        }
        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);

        imageView.setImageResource(images[position]);

        textView.setText(msg[position]);
        return  convertView;
    }
}
