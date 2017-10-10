package com.pixelon.sportsapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixelon.sportsapplication.Item;
import com.pixelon.sportsapplication.R;

import java.util.List;



/**
 * Created by ALi on 4/18/2017.
 */

public class ListAdapter extends ArrayAdapter<Item> {

    public ListAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.list_item_main, null);
        }
    Item item = getItem(position);
        if (item != null) {
            TextView tittle = (TextView)v.findViewById(R.id.item_heading);
            TextView description = (TextView)v.findViewById(R.id.item_detail);
            ImageView thumbnail = (ImageView)v.findViewById(R.id.ic_consultant);
            if(tittle != null) {
                tittle.setText(item.getListTittle());
            }
                if(description != null){
                    description.setText(item.getListDetail());

            }
            if(thumbnail != null){
                thumbnail.setImageResource(item.getListThumbnail());
            }

        }

    return  v;
    }
}
