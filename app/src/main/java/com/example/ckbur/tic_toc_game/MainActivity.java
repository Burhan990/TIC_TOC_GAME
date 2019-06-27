package com.example.ckbur.tic_toc_game;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.tv);
        iv=(ImageView)findViewById(R.id.iv);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/nabila.ttf");

        tv.setTypeface(typeface);

        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);

        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        final Intent i=new Intent(MainActivity.this,HomePage.class);

        Thread timer=new Thread(){
            public void run(){

                try{
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {


                    startActivity(i);
                    finish();

                }

            }

        };
        timer.start();
    }
}

