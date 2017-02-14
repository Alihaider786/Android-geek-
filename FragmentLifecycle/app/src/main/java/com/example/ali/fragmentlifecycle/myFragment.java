package com.example.ali.fragmentlifecycle;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by ALi on 2/14/2017.
 */

public class myFragment extends Fragment
{  /*<Summary>
    * This is the portion of User Interface of in an activity
    * You can create multiple fragments in an activity to create a multipane user interface.
    * You can reuse one fragment in multiple activities.
    * You can think of a fragment as a modular section of an activity,
    * which has its own lifecycle, receives its own input events,
    * and which you can add or remove while the activity is running (sort of like a "sub activity" that you can reuse in different activities).
    * A fragment must always be embedded in an activity and the fragment's lifecycle is directly affected by the host activity's lifecycle.
    </Summary>*/

  // First CallBack on the fragment Attach the fragment to layout when requested by activity.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(context, "This is on Attach", Toast.LENGTH_SHORT).show();

    }
   // This call back create the fragment essentials.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "This is onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
    }
// This callback initialize the UI of fragment. Can't be null. If Null it Raise Exception.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Toast.makeText(getActivity(), "This is Oncreate View", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment, container, false);


    }
       //The callback when initialized ui is started.
    @Override
    public void onStart() {
        Toast.makeText(getActivity(), "This is onStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }
// The call back when The fragment is its foreground and running state.
    @Override
    public void onResume() {
        Toast.makeText(getActivity(), "This is onResume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }
// This call back when fragment transit to another activity or lose focus from foreground.
    @Override
    public void onPause() {
        Toast.makeText(getActivity(), "This is onPasue", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
// This callback when fragment other process come to foreground and the current fragment stop.
    @Override
    public void onStop() {
        Toast.makeText(getActivity(), "This is onStop",Toast.LENGTH_SHORT).show();
        super.onStop();
    }
// This call back when we press back from application then the activity is destroyed after onStop.
    @Override
    public void onDestroy() {
        Toast.makeText(getActivity(), "This is onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
