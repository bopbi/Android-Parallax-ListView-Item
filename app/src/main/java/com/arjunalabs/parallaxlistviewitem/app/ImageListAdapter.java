package com.arjunalabs.parallaxlistviewitem.app;

import android.content.Context;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

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
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 300));
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = imageView.getImageMatrix();
            matrix.postTranslate(0, -100);
            imageView.setImageMatrix(matrix);
            if (position % 2 == 0) {
                imageView.setImageResource(R.drawable.lorempixel2);
            } else if (position % 3 == 0) {
                imageView.setImageResource(R.drawable.lorempixel3);
            } else {
                imageView.setImageResource(R.drawable.lorempixel);
            }
            viewHolder = new ViewHolder();
            convertView = imageView;
            viewHolder.imageView = imageView;
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Matrix matrix = viewHolder.imageView.getImageMatrix();
        matrix.reset();
        matrix.postTranslate(0, -100);
        viewHolder.imageView.setImageMatrix(matrix);

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
    }

}
