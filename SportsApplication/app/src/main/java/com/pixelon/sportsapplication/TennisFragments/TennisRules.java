package com.pixelon.sportsapplication.TennisFragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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
import com.pixelon.sportsapplication.Adapters.RuleAdapter;
import com.pixelon.sportsapplication.Models.RuleItem;
import com.pixelon.sportsapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class TennisRules extends Fragment {

    RecyclerView view;
    List<RuleItem> itemList;
    RuleAdapter adapter;
    String newsUrl = "http://mobileappsports.azurewebsites.net/api/file?category=tennis";
    RecyclerView.LayoutManager layoutManager;
    SwipeRefreshLayout layout;
    ProgressBar bar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_tennis_rules, container, false);
        layout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_rules);
        itemList = new ArrayList<>();
        container.setScrollContainer(false);
        bar = (ProgressBar) v.findViewById(R.id.progressBar_rule);
        view = (RecyclerView) v.findViewById(R.id.recycleView_rules);
        adapter = new RuleAdapter(getContext(), itemList);
        layoutManager = new LinearLayoutManager(getContext());
        view.setHasFixedSize(true);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
        prepareNewsList(newsUrl);

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
            prepareNewsList(newsUrl);
            layout.setRefreshing(false);
    }


    private void prepareNewsList(String UrlType) {
        if (isNetworkStatusAvialable(getContext())) {
            final StringRequest reqest = new StringRequest(Request.Method.GET, UrlType, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        bar.setVisibility(ProgressBar.INVISIBLE);
                        /*String status = object.getString("status");
                        if(status.equals("ok"))*/
                        //{
                          JSONArray array = new JSONArray(response);
                        for (int i=0; i<array.length(); i++) {
                            JSONObject newObject = array.getJSONObject(i);
                            String tittle = newObject.getString("tittle");
                            String pdfUrl = newObject.getString("pdfUrl");
                            String desc = newObject.getString("description");
                            String date = newObject.getString("date");
                            String createdBy = newObject.getString("createdBy");
                            RuleItem myRule = new RuleItem(tittle, desc, pdfUrl, date, createdBy);
                            itemList.add(myRule);
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
