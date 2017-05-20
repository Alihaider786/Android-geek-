package com.pixelon.sqliteasync;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.DateFormat;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by ALi on 5/20/2017.
 */

/*Create an async task for downloading image in background thread*/

public class MyTask extends AsyncTask<String, Void, Bitmap> {

    // Interface that pass value of bitmap
    ImageInterface imageInterface;
    ProgressDialog dialog;
    Context context;

   public MyTask(Context context)
    {     imageInterface = (ImageInterface)context;
         this.context = context;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap map = null;
        for( String url : params)
        {
                // see method below to download bitmap image from url
            map = downloadImage(url);
            
        }
    return map;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Please Wait");
        dialog.show();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        dialog.dismiss();
        imageInterface.getImage(bitmap);
    }

    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        InputStream stream = null;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inSampleSize = 1;
        try {
            stream = getHttpConnection(url);
            bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
   return bitmap;
    }

    private InputStream getHttpConnection(String url) throws IOException{
        InputStream stream = null;
        URL myUrl = new URL(url);
        URLConnection connection =  myUrl.openConnection();
     try
     {
         HttpsURLConnection httpConnection = (HttpsURLConnection)connection;
         httpConnection.setRequestMethod("GET");
         httpConnection.connect();

         if(httpConnection.getResponseCode()== HttpURLConnection.HTTP_OK) {
          stream = httpConnection.getInputStream();
         }
     }
     catch (Exception ex)
     {
         ex.printStackTrace();
     }

return stream;
    }
}
