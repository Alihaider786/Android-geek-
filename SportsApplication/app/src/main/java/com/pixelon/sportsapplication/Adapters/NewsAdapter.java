package com.pixelon.sportsapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixelon.sportsapplication.Details;
import com.pixelon.sportsapplication.ImageOpen;
import com.pixelon.sportsapplication.Models.NewsItem;
import com.pixelon.sportsapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ALi on 7/5/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsCardHolder> {
Context mContext;
    List<NewsItem> itemList;

 public  NewsAdapter(Context mContext, List<NewsItem> itemList)
 {
     this.mContext = mContext;
     this.itemList = itemList;
 }

    @Override
    public NewsCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_card, parent, false);
        return  new NewsCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsCardHolder holder, int position) {
     final NewsItem news = itemList.get(position);
        holder.authorText.setText(news.getAuthor());
        holder.tittleText.setText(news.getTittle());
        holder.description.setText(news.getDescp());
        holder.top.setText(news.getNewsType());
        Picasso.with(mContext).load(news.getImageUrl()).into(holder.thumbnailImage);
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Details.class);
                intent.putExtra("URL", news.getDetailUrl());
                mContext.startActivity(intent);
            }
        });
        holder.thumbnailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, ImageOpen.class);
                in.putExtra("IMAGE_URL",news.getImageUrl());
                mContext.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class NewsCardHolder extends RecyclerView.ViewHolder {
        TextView authorText, tittleText, description, detail, top;
        ImageView thumbnailImage;

        public NewsCardHolder(View itemView) {
            super(itemView);
            authorText = (TextView)itemView.findViewById(R.id.author);
            tittleText = (TextView)itemView.findViewById(R.id.tittle);
            description = (TextView)itemView.findViewById(R.id.desc);
            detail = (TextView)itemView.findViewById(R.id.details);
            thumbnailImage = (ImageView)itemView.findViewById(R.id.imageView);
            top = (TextView)itemView.findViewById(R.id.top);

        }
    }

}
