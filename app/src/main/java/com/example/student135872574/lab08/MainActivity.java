package com.example.student135872574.lab08;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;//new

import android.os.Handler;

public class MainActivity extends AppCompatActivity {
private ImageView m_img_duke;
    private AnimationDrawable m_frame_animation;
    private TextView m_tv_message;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFrameAnimation();
    }
    private void initView(){

        m_img_duke=(ImageView)findViewById(R.id.img_duke);
        m_tv_message=(TextView)findViewById(R.id.tv_message);
    }
    private void initFrameAnimation(){
        m_img_duke.setBackgroundResource(R.drawable.frame_animation);
        m_frame_animation=(AnimationDrawable)m_img_duke.getBackground();
    }
    public void click(View view){
        switch (view.getId()){
            case R.id.btn_start:
                m_frame_animation.start();
                break;
            case R.id.btn_stop:
                m_frame_animation.stop();
                break;
            case R.id.btn_5_sece:
                animation5secs();
                break;

        }


    }
    private Handler m_Handler = new Handler();
    private void animation5secs(){
        int delayMillis = 5*1000;
        Runnable task = new Task();
        boolean result = m_Handler.postDelayed(task, delayMillis);
        //
        m_tv_message.setText(result ? "成功" : "失敗");
        m_frame_animation.start();


    }
    private  class Task implements Runnable{
        @Override
        public void run(){
            m_frame_animation.stop();
            m_tv_message.setText("時間到");


        }


    }



}
