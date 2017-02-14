package com.example.ali.fragmentlifecycle;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button navigate;
    Button change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigate = (Button)findViewById(R.id.navigate);
       change = (Button)findViewById(R.id.navigate2);
        // change overall view

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction trancation = fm.beginTransaction();
                myFragment fragment = new myFragment();
                trancation.add(R.id.activity_main, fragment);
                trancation.commit();
            }
        });
        // change partial view
        navigate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fragmentManager = getFragmentManager();
               FragmentTransaction transaction = fragmentManager.beginTransaction();
               myFragment fragment = new myFragment();
               transaction.add(R.id.container, fragment);
               transaction.commit();
           }
       });

    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "This is Activity OonStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "This is Activity onResume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "This is Activity OnPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "This is Activity OnStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"This is Activity onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "This is Activity onRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }



}
