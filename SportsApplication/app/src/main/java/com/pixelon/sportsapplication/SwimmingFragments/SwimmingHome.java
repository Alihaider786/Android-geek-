package com.pixelon.sportsapplication.SwimmingFragments;

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


public class SwimmingHome extends Fragment {


    ListView view;
    CategoryAdapter adapter;
    List<CategoryItem> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_swimming_home, container, false);
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
                        batting.putExtra("CATEGORY", "swimmingbutterfly");
                        startActivity(batting);

                        break;
                    case 1:
                        Intent bowling = new Intent(getActivity(), ImagesVideo.class);
                        bowling.putExtra("CATEGORY", "swimmingbackstroke");
                        startActivity(bowling);

                        break;
                    case 3:
                        Intent fielding = new Intent(getActivity(), ImagesVideo.class);
                        fielding.putExtra("CATEGORY", "swimmingfreestyle");
                        startActivity(fielding);

                        break;
                    case 2:

                        Intent straching = new Intent(getActivity(), ImagesVideo.class);
                        straching.putExtra("CATEGORY", "swimmingbreaststroke");
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
        CategoryItem cricket = new CategoryItem("Butterfly", "The butterfly is a swimming stroke swum on the chest, with both arms moving symmetrically, accompanied by the butterfly kick.");
        list.add(cricket);
        CategoryItem tennis = new CategoryItem("Backstroke", "Backstroke is one of the four swimming styles used in competitive events regulated by FINA, and the only one of these styles swum on the back.");
        list.add(tennis);
        CategoryItem football = new CategoryItem("Breaststroke", "Breaststroke is a swimming style in which the swimmer is on their chest and the torso does not rotate.");
        list.add(football);
        CategoryItem hockey = new CategoryItem("Freestyle", "Freestyle is a category of swimming competition, defined by the rules of the International Swimming Federation (FINA), in which competitors are subject to only limited restrictions on their swimming stroke, affording the swimmer great freedom in style.");
        list.add(hockey);



    }


}
