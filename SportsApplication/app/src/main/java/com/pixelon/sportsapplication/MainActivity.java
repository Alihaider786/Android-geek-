package com.pixelon.sportsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.pixelon.sportsapplication.Adapters.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
    ListAdapter adapter;
    List<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        items = new ArrayList<>();
        adapter = new ListAdapter(this, R.layout.list_item_main, items);
        listView.setAdapter(adapter);
prepareList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent cricket = new Intent(MainActivity.this, Cricket.class);
                        startActivity(cricket);
                        break;
                    case 1:
                        Intent tennis = new Intent(MainActivity.this, Tennis.class);
                        startActivity(tennis);
                        break;
                    case 2:
                        Intent football = new Intent(MainActivity.this, Football.class);
                        startActivity(football);
                        break;
                    case 3:
                        Intent hockey = new Intent(MainActivity.this, Hockey.class);
                        startActivity(hockey);
                        break;
                    case 4:
                        Intent badminton = new Intent(MainActivity.this, Badminton.class);
                        startActivity(badminton);
                        break;
                    case 5:
                        Intent swimming = new Intent(MainActivity.this, Swimming.class);
                        startActivity(swimming);
                         default:
                             Toast.makeText(MainActivity.this, "Not Handled Yet", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void prepareList() {
    Item cricket = new Item("Cricket", "Latest from cricket world. Kohli, Sarfraz and Morgan. All in one", R.drawable.cricket);
        items.add(cricket);
        Item tennis = new Item("Tennis", "What going on in world tennis", R.drawable.tennis);
        items.add(tennis);
        Item football = new Item("FootBall", "Messi, Ronaldo and Ronaldhino \nEveryone is here.", R.drawable.football);
        items.add(football);
        Item hockey = new Item("Hockey", "See latest from hockey", R.drawable.hockey);
        items.add(hockey);
        Item bedminton = new Item("Badminton","Badmintion news is here", R.drawable.bedminton );
        items.add(bedminton);
        Item swim = new Item("Swimming", "Everything is here", R.drawable.swim);
        items.add(swim);

        }


    }



