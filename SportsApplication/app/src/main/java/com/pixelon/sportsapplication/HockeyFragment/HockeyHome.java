package com.pixelon.sportsapplication.HockeyFragment;

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


public class HockeyHome extends Fragment {


    ListView view;
    CategoryAdapter adapter;
    List<CategoryItem> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hockey_home, container, false);
        list = new ArrayList<>();
        adapter = new CategoryAdapter(getActivity(), R.layout.list_item_category, list );
        view = (ListView)v.findViewById(R.id.cricket_List);
        view.setAdapter(adapter);

        prepareList();
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent batting = new Intent(getActivity(), ImagesVideo.class);
                        batting.putExtra("CATEGORY", "hockeydefending");
                        startActivity(batting);

                        break;
                    case 1:
                        Intent bowling = new Intent(getActivity(), ImagesVideo.class);
                        bowling.putExtra("CATEGORY", "hockeyattacking");
                        startActivity(bowling);

                        break;
                    case 3:
                        Intent fielding = new Intent(getActivity(), ImagesVideo.class);
                        fielding.putExtra("CATEGORY", "hockeyGoalkeeping");
                        startActivity(fielding);

                        break;
                    case 2:

                        Intent straching = new Intent(getActivity(), ImagesVideo.class);
                        straching.putExtra("CATEGORY", "hockeymidfield");
                        startActivity(straching);

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
        CategoryItem cricket = new CategoryItem("Defending", "How to defend the ball. See latest Images and Video");
        list.add(cricket);
        CategoryItem tennis = new CategoryItem("Attacking", "Wanna be a good attacker ? No Problem at all");
        list.add(tennis);
        CategoryItem football = new CategoryItem("Mid Field", "Cover better the mid field");
        list.add(football);
        CategoryItem hockey = new CategoryItem("Goal Keeping", "See latest from our stuff");
        list.add(hockey);



    }


}
