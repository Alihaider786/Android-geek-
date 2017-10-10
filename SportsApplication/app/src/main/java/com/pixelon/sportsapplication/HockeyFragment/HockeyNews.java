package com.pixelon.sportsapplication.HockeyFragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
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
import com.pixelon.sportsapplication.Adapters.NewsAdapter;
import com.pixelon.sportsapplication.Models.NewsItem;
import com.pixelon.sportsapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HockeyNews extends Fragment {
    RecyclerView view;
    List<NewsItem> itemList;
    NewsAdapter adapter;
   // String topNewsUrl = "https://newsapi.org/v1/articles?source=espn-cric-info&sortBy=top&apiKey=ed034ed20ac2437da1a2db4ed231b974";
    String newsUrl = "http://mobileappsports.azurewebsites.net/api/news?category=hockey";
    RecyclerView.LayoutManager layoutManager;
    SwipeRefreshLayout layout;
    ProgressBar bar;
/*
    boolean topNews = false;
*/
    String TOP_NEWS = "Top";
    String LATEST_NEWS = "Latest";
    FloatingActionButton fab;
    CoordinatorLayout coordinatorLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hockey_news, container, false);
        layout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh);
        itemList = new ArrayList<>();
        coordinatorLayout = (CoordinatorLayout) v.findViewById(R.id.main_content);
        container.setScrollContainer(false);
        bar = (ProgressBar) v.findViewById(R.id.progressBar);
        fab = (FloatingActionButton) v.findViewById(R.id.fabButton);
        view = (RecyclerView) v.findViewById(R.id.recycleView);
        adapter = new NewsAdapter(getContext(), itemList);
        layoutManager = new LinearLayoutManager(getContext());
        view.setHasFixedSize(true);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
        prepareNewsList(newsUrl, LATEST_NEWS);


        return v;


    }

    @Override
    public void onResume() {
        super.onResume();

        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateList();
            }
        });
    }

    private void updateList() {

            itemList.clear();
            adapter.notifyDataSetChanged();
            prepareNewsList(newsUrl, TOP_NEWS);
            layout.setRefreshing(false);


        }




    private void prepareNewsList(String UrlType, final String NewsType) {
        if (isNetworkStatusAvialable(getContext())) {
            StringRequest reqest = new StringRequest(Request.Method.GET, UrlType, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        bar.setVisibility(ProgressBar.INVISIBLE);
                   //     JSONObject object = new JSONObject(response);
                        /*String status = object.getString("status");
                        if(status.equals("ok"))*/
                        //{

                        JSONArray array = new JSONArray(response);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject newObject = array.getJSONObject(i);
                            String author = newObject.getString("author");
                            String tittle = newObject.getString("title");
                            String imageUrl = newObject.getString("urlToImage");
                            String desc = newObject.getString("description");
                            String detailUrl = newObject.getString("url");
                            NewsItem myNews = new NewsItem(imageUrl, author, tittle, desc, "Latest", detailUrl);
                            itemList.add(myNews);
                            adapter.notifyDataSetChanged();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity().getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            RequestQueue queue = Volley.newRequestQueue(getContext());
            reqest.setRetryPolicy(new DefaultRetryPolicy(50000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            queue.add(reqest);
        }

        else
    {
        Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
        bar.setVisibility(ProgressBar.INVISIBLE);
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
