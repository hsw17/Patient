package com.wd.health;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private TextView textView;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.text_view);

//        textView.setText("@八维移动智能系1704A第五组");

//        设置跳转方法
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ARouter.getInstance().build("/hehome/activity").navigation();
                finish();
            }
        };
        timer.schedule(task, 3000);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }


}