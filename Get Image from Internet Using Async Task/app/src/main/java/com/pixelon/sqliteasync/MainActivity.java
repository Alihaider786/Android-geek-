package com.pixelon.sqliteasync;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;
/*this */
public class MainActivity extends AppCompatActivity implements ImageInterface{


    ImageView imageView;
    public static final String url = "https://cdn.pixabay.com/photo/2017/01/06/23/21/soap-bubble-1959327_960_720.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   imageView = (ImageView)findViewById(R.id.imageview);


    }


    public void OnDownloadClick(View view) {
    MyTask imageTask = new MyTask(MainActivity.this);

        imageTask.execute(new String[]{url});


    }

    @Override
    public void getImage(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);

    }
}
