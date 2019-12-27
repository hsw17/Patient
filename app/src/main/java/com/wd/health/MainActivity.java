package com.wd.health;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.mymodlue.R2;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.text_view);

//        textView.setText("@八维移动智能系1704A第五组");
//        3秒跳转
        final Intent intent = new Intent();
//        设置跳转方法
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ARouter.getInstance().build("/mymodlue/activity").navigation();
            }
        };
        timer.schedule(task, 3000);
    }


}
