package com.pixelon.sportsapplication.TennisFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.pixelon.sportsapplication.Adapters.CategoryAdapter;
import com.pixelon.sportsapplication.Adapters.ListAdapter;
import com.pixelon.sportsapplication.ImagesVideo;
import com.pixelon.sportsapplication.Item;
import com.pixelon.sportsapplication.Models.CategoryItem;
import com.pixelon.sportsapplication.R;

import java.util.ArrayList;
import java.util.List;


public class TennisHome extends Fragment {


    ListView view;
    CategoryAdapter adapter;
    List<CategoryItem> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tennis_home, container, false);
        list = new ArrayList<>();
        adapter = new CategoryAdapter(getActivity(), R.layout.list_item_category, list);
        view = (ListView) v.findViewById(R.id.cricket_List);
        view.setAdapter(adapter);

        prepareList();
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent batting = new Intent(getActivity(), ImagesVideo.class);
                        batting.putExtra("CATEGORY", "tennisgrip");
                        startActivity(batting);

                        break;
                    case 1:
                        Intent bowling = new Intent(getActivity(), ImagesVideo.class);
                        bowling.putExtra("CATEGORY", "tennisserve");
                        startActivity(bowling);

                        break;
                    case 3:
                        Intent fielding = new Intent(getActivity(), ImagesVideo.class);
                        fielding.putExtra("CATEGORY", "tennisbackhand");
                        startActivity(fielding);

                        break;
                    case 2:

                        Intent straching = new Intent(getActivity(), ImagesVideo.class);
                        straching.putExtra("CATEGORY", "tennisforehand");
                        startActivity(straching);

                        break;
                    case 4:
                        Intent volley = new Intent(getActivity(), ImagesVideo.class);
                        volley.putExtra("CATEGORY", "tennisvolley");
                        startActivity(volley);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Not Handled Yet", Toast.LENGTH_SHORT).show();
                        break;


                }
            }
        });
        return v;
    }

    private void prepareList() {
        CategoryItem cricket = new CategoryItem("Grip", "A grip is a way of holding the racket in order to hit shots during a match.");
        list.add(cricket);
        CategoryItem tennis = new CategoryItem("Serve", "A serve (or, more formally, a service) in tennis is a shot to start a point.");
        list.add(tennis);
        CategoryItem football = new CategoryItem("Forehand", "For a right-handed player, the forehand is a stroke that begins on the right side of the body.");
        list.add(football);
        CategoryItem hockey = new CategoryItem("Backhand", "For right-handed players, the backhand is a stroke that begins on the left side of their body.");
        list.add(hockey);
        CategoryItem volley = new CategoryItem("Volley", "A volley is a shot returned to the opponent in mid-air before the ball bounces.");
        list.add(volley);


    }
}