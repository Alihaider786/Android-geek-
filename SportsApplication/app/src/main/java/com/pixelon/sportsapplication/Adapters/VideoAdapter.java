package com.pixelon.sportsapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixelon.sportsapplication.ImageOpen;
import com.pixelon.sportsapplication.ImageVideoActivities.VideoPlayer;
import com.pixelon.sportsapplication.Models.ImageItem;
import com.pixelon.sportsapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ALi on 9/29/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

Context mContext;
    List<ImageItem> imageItems;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView image_title, image_description;
        ImageView image_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_title = (TextView)itemView.findViewById(R.id.image_title);
            image_description = (TextView)itemView.findViewById(R.id.image_description);
            image_image = (ImageView)itemView.findViewById(R.id.image_image);
        }
    }

    public VideoAdapter(Context context, List<ImageItem> list)
    {
        this.mContext = context;
        this.imageItems = list;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return  new VideoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

                final ImageItem item = imageItems.get(position);
               holder.image_title.setText(item.getTitle());
                holder.image_description.setText(item.getDescription());
        Picasso.with(mContext).load("https://img.youtube.com/vi/"+item.getImageUrl()+"/0.jpg").into(holder.image_image);
        holder.image_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, VideoPlayer.class);
                in.putExtra("VIDEO_URL",item.getImageUrl());
                mContext.startActivity(in);
            }
        });
                }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }


}
