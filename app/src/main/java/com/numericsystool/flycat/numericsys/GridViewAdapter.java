package com.numericsystool.flycat.numericsys;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Javicuc on 20/11/2017.
 */

public class GridViewAdapter extends ArrayAdapter<NumericalMethod> {
    public GridViewAdapter(Context context, int resource, List<NumericalMethod> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grid_item,null);
        }

        NumericalMethod method = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.iv_ItemIcon);
        TextView tvTitle = (TextView) v.findViewById(R.id.tv_Title);
        TextView tvDescp = (TextView) v.findViewById(R.id.tv_Description);

        img.setImageResource(method.getImageID());
        tvTitle.setText(method.getTitle());
        tvDescp.setText(method.getDescription());

        return v;
    }
}
