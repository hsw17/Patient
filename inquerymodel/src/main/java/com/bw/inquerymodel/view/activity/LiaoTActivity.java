package com.bw.inquerymodel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bw.inquerymodel.R;

import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.api.BasicCallback;

import static cn.jmessage.biz.httptask.task.GetUserInfoListTask.IDType.username;

public class LiaoTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_liao_t );

        Intent intent = getIntent ();
        String userName = intent.getStringExtra ( "userName" );

//        JMessageClient.login(String username, String password, BasicCallback callback);

        Conversation.createSingleConversation ( userName, "c7f6a1d56cb8da740fd18bfa" );

    }
}
