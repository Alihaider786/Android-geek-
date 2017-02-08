package com.example.ali.activitylifecycle;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*Activity Life Cycle
* How and Activity Behaves in its different states
* How we can access the usability of its states
* "Process States"         |----------|"Activity States"
* Foreground               |----------|Created, Started, Resumed
* Background (Losing Focus)|----------|Paused
* Background (Invisible)   |----------|Stopped
* Empty                    |=---------|Destroyed*/


public class MainActivity extends AppCompatActivity {
    Button Navigate ;

    //******  No. 1 OnCreate() Implementation *****
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Super Class method to initialize the saved instances
        super.onCreate(savedInstanceState);
        //recover the instance state
        if(savedInstanceState != null)
        {
            //no saved instance
        }
        setContentView(R.layout.activity_main);
        Navigate = (Button)findViewById(R.id.edit);
        Navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondActivity);
            }
        });


    }
     //*****  No. 2 onStart() ****//
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Enter in OnStart State", Toast.LENGTH_SHORT).show();
        /* When the activity enters the Started state, the system
           invokes this callback. The onStart() call makes the activity visible
           to the user, as the app prepares for the activity to enter the foreground
           and become interactive. For example, this method is where the app initializes
           the code that maintains the UI. It might also register a BroadcastReceiver
           that monitors changes that are reflected in the UI. The onStart() method
           completes very quickly and, as with the Created state, the activity does
           not stay resident in the Started state. Once this callback finishes, the
           activity enters the Resumed state, and the system invokes the onResume()
           method. */

    }

     // ****** No. 3 onResume() Implementation ******
     // invoked at this level when activity comes to foreground and interact with user.
     //You can check whether any service or required component is available or not.

     @Override
      protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Enter in OnResume State.", Toast.LENGTH_SHORT).show();
      // Suppose the activity required a wifi enabled.
         // Then you can manage it like this here.
         WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);

        if (wifi.isWifiEnabled()){
             //wifi is enabled
            Toast.makeText(this, "Your Wifi is Enable", Toast.LENGTH_SHORT).show();
        }
         else {
            //Enable Your Wifi
            Toast.makeText(this, "Enabling Wifi", Toast.LENGTH_SHORT).show();
            wifi.setWifiEnabled(true);
        }
    }


    // ***** No. 4 onPause() *****
    //This method invokes when you leaving the activity to another.
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Entering in OnPause State", Toast.LENGTH_SHORT).show();
        //Suppose you are in a specific activity that require wifi.
        //Now if you are leaving this activity make sure that you have disabled your wifi.

        WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        if(wifi.isWifiEnabled())
        {
            Toast.makeText(this, "Disabling Your Wifi", Toast.LENGTH_SHORT).show();
            wifi.setWifiEnabled(false);

        }


    }

    /*The Code Will be Updated Soon For remaining States*/



}
