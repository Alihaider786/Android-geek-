package com.pixelon.sportsapplication.ImageVideoActivities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pixelon.sportsapplication.Adapters.ImageAdapter;
import com.pixelon.sportsapplication.Models.ImageItem;
import com.pixelon.sportsapplication.Models.NewsItem;
import com.pixelon.sportsapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALi on 9/29/2017.
 */

public class ImagesFragment extends Fragment {

    RecyclerView view;
    List<ImageItem> itemList;
    RecyclerView.LayoutManager layoutManager;
    ImageAdapter adapter;
    SwipeRefreshLayout layout;
    ProgressBar bar;
    String url="http://mobileappsports.azurewebsites.net/api/ImagesData?category=";
    String category;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.image_fragment, container, false);
        Bundle bundle = getArguments();
        category = bundle.getString("C");
        itemList = new ArrayList<>();
         view = (RecyclerView)v.findViewById(R.id.image_recycle_view);
        bar = (ProgressBar)v.findViewById(R.id.image_progressBar);
        layout = (SwipeRefreshLayout)v.findViewById(R.id.swipe_refresh_image);
        adapter = new ImageAdapter(getContext(), itemList);
        layoutManager = new LinearLayoutManager(getContext());
        view.setHasFixedSize(true);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
        prepareImageList(url, category);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        updateList();
        layout.setRefreshing(false);
    }
});
    }

    private void updateList() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        prepareImageList(url,category);
    }

    private void prepareImageList(final String url, String category) {
      if(isNetworkStatusAvialable(getActivity()))
      {
          final StringRequest request = new StringRequest(Request.Method.GET, url + category, new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {

                  try {
                      JSONArray array = new JSONArray(response);
                      bar.setVisibility(ProgressBar.INVISIBLE);

                      for(int i=0; i<array.length(); i++)
                      {
                          JSONObject object = array.getJSONObject(i);
                          String title = object.getString("title");
                          String description = object.getString("description");
                          String urlToImage = object.getString("urlToImage");
                          ImageItem item = new ImageItem(title, description, urlToImage);
                          itemList.add(item);
                          adapter.notifyDataSetChanged();



                      }

                  } catch (JSONException e) {
                      e.printStackTrace();
                  }


              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {

              }
          });
          RequestQueue queue = Volley.newRequestQueue(getActivity());
          request.setRetryPolicy(new DefaultRetryPolicy(50000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
     queue.add(request);
      }
        else {

          Toast.makeText(getContext(), "No Internet Available", Toast.LENGTH_SHORT).show();
      }

    }

    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if(netInfo != null)
            {
                return netInfo.isConnected();
            }
        }
        return false;
    }
}
