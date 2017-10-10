package com.pixelon.sportsapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageOpen extends AppCompatActivity {
String Url;
    ImageView view;

    PhotoViewAttacher photoAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_open);
         Url = getIntent().getStringExtra("IMAGE_URL");
        view = (ImageView)findViewById(R.id.imageEnhance);
        Picasso.with(this).load(Url).into(view);
        photoAttacher = new PhotoViewAttacher(view);
        photoAttacher.update();


    }

}
