package com.pixelon.sportsapplication.CricketFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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


public class CricketHome extends Fragment {

    ListView view;
    CategoryAdapter adapter;
    List<CategoryItem> list;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_cricket_home, container, false);
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
                    case 4:
                        Intent tranning = new Intent(getActivity(), ImagesVideo.class);
                        tranning.putExtra("CATEGORY", "training");
                        startActivity(tranning);

                    break;
                    case 0:
                        Intent batting = new Intent(getActivity(), ImagesVideo.class);
                        batting.putExtra("CATEGORY", "batting");
                        startActivity(batting);

                        break;
                    case 1:
                        Intent bowling = new Intent(getActivity(), ImagesVideo.class);
                        bowling.putExtra("CATEGORY", "bowling");
                        startActivity(bowling);

                        break;
                    case 3:
                        Intent fielding = new Intent(getActivity(), ImagesVideo.class);
                        fielding.putExtra("CATEGORY", "fielding");
                        startActivity(fielding);

                        break;
                    case 2:

                        Intent straching = new Intent(getActivity(), ImagesVideo.class);
                        straching.putExtra("CATEGORY", "stretching");
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
        CategoryItem cricket = new CategoryItem("Batting", "Batsman play the ball come from a bowler." );
        list.add(cricket);
        CategoryItem tennis = new CategoryItem("Bowling", "The essence of the sport is that a bowler delivers (i.e., bowls) the ball from his end of the pitch towards the batsman.");
        list.add(tennis);
        CategoryItem football = new CategoryItem("Stretching", "A good player is that who can remain active throughout the game.");
        list.add(football);
        CategoryItem hockey = new CategoryItem("Fielding", "Of the eleven fielders on the field, their positions determined on a tactical basis by the captain or the bowler.");
        list.add(hockey);
        CategoryItem bedminton = new CategoryItem("Training","Train yourself for to play better.");
        list.add(bedminton);



    }


}
