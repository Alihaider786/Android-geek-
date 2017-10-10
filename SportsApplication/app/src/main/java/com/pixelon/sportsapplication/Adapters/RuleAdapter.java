package com.pixelon.sportsapplication.Adapters;

import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pixelon.sportsapplication.Details;
import com.pixelon.sportsapplication.Models.NewsItem;
import com.pixelon.sportsapplication.Models.RuleItem;
import com.pixelon.sportsapplication.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by ALi on 7/5/2017.
 */

public class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.NewsCardHolder> {
    Context mContext;
    List<RuleItem> itemList;


    public RuleAdapter(Context mContext, List<RuleItem> itemList)
 {
     this.mContext = mContext;
     this.itemList = itemList;



 }

    @Override
    public NewsCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rule_card, parent, false);
        return  new NewsCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsCardHolder holder, int position) {
     final RuleItem news = itemList.get(position);
        holder.tittleText.setText(news.getTittle());
        holder.description.setText(news.getDescription());
        holder.by.setText(news.getCreatedBy());
        holder.date.setText(news.getDate());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager manager = (DownloadManager)mContext.getSystemService(Context.DOWNLOAD_SERVICE);
                Uri videoUri = Uri.parse(news.getPdfUrl());
                DownloadManager.Request request = new DownloadManager.Request(videoUri);
                request.setTitle("Downloading");
                request.setDescription("Downloading PDF");
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,news.getTittle()+".mp4");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                manager.enqueue(request);
            }


        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class NewsCardHolder extends RecyclerView.ViewHolder {
        TextView  tittleText, description, by, date;
        ImageView button;
        public NewsCardHolder(View itemView) {
            super(itemView);
            tittleText = (TextView)itemView.findViewById(R.id.tittle_rule);
            description = (TextView)itemView.findViewById(R.id.descp);
            button = (ImageView)itemView.findViewById(R.id.download_button);
            by = (TextView)itemView.findViewById(R.id.by);
            date = (TextView)itemView.findViewById(R.id.Date);


        }
    }

  /*  public static class FileDownloader {
        private static final int  MEGABYTE = 1024 * 1024;

        public static void downloadFile(String fileUrl, File directory){
            try {

                URL url = new URL(fileUrl);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                //urlConnection.setRequestMethod("GET");
                //urlConnection.setDoOutput(true);
                urlConnection.connect();
                int totalSize = urlConnection.getContentLength();
                InputStream inputStream = urlConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(directory);

                byte[] buffer = new byte[MEGABYTE];
                int bufferLength = 0;
                while((bufferLength = inputStream.read(buffer))>0 ){
                    fileOutputStream.write(buffer, 0, bufferLength);
                }
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/


   /* private class DownloadFile extends AsyncTask<String, Integer, Void> {
        @Override
        protected void onPreExecute() {

            //showpDialog();
        }

        @Override
        protected Void doInBackground(String... strings) {

            String fileUrl = strings[0];
            String fileName = strings[1];
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "Sports Tutorials");
            folder.mkdir();

            File pdfFile = new File(folder, fileName+".pdf");

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //hidepDialog();
            Toast.makeText(mContext, "PDf Download successfully", Toast.LENGTH_LONG).show();
            Log.e("Download complete", "----------");
        }

    }


*/
}
