package com.example.youtubeviewers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.florent37.viewanimator.ViewAnimator;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3;
    private TextView textView_count;
    private Random random_num;
    private int count=0;
    private boolean nextPage=false;
    int a =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView1=findViewById(R.id.iv_logo1_id_splashActivity);
        imageView2=findViewById(R.id.iv_logo2_id_splashActivity);
        imageView3=findViewById(R.id.iv_logo3_id_splashActivity);
        textView_count=findViewById(R.id.tv_count_splahActivity);
        random_num=new Random();
        a= 0;
        textView_count.setText(String.valueOf(a));

        Handler handler=new Handler();
        for(int i=0;i<=1000;i++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            },100);
             textView_count.setText(String.valueOf(i));
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimator.animate(imageView1).translationY(-400,0).duration(1000).start();
            }
        },200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimator.animate(imageView2).translationY(-400,0).translationX(0,-90).duration(1000).start();
                nextPage=true;
            }
        },400);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimator.animate(imageView3).translationY(-400,0).translationX(0,90).duration(1000).start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);

            }
        },600);


         /* handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                do {
                    int a = random_num.nextInt();
                    if (a > 0) {
                        if (count < a) {
                            count = a;
                            textView_count.setText(String.valueOf(count));
                        }
                    }
                } while (true);
            }
        },0);



        */

    }
}