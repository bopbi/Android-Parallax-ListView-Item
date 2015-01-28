package com.arjunalabs.parallaxlistviewitem.app;

import android.content.Context;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bobbyadiprabowo on 6/3/14.
 */
public class ImageListAdapter extends BaseAdapter {

    private Context context;

    public ImageListAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            if (position % 2 == 0) {
                imageView.setImageResource(R.drawable.lorempixel2);
            } else if (position % 3 == 0) {
                imageView.setImageResource(R.drawable.lorempixel3);
            } else {
                imageView.setImageResource(R.drawable.lorempixel);
            }
            Matrix matrix = imageView.getImageMatrix();
            matrix.postTranslate(0, -100);
            imageView.setImageMatrix(matrix);
            viewHolder = new ViewHolder();
            viewHolder.imageView = imageView;
            viewHolder.textView = textView;
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.textView.setText("Row "+ position);
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

}
