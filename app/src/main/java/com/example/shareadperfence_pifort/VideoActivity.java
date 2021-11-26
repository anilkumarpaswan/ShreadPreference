package com.example.shareadperfence_pifort;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    ImageView vv1;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_video );
//        vv1 = findViewById ( R.id.vv1 );
////        vv1.setVideoURI ( Uri.parse ( "file:///android_asset/video1.mp4") );
////        vv1.start ( );
//        vv1.setImageResource ( R.drawable.img1 );
    }
}
