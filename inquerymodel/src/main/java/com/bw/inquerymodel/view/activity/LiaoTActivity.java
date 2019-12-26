package com.bw.inquerymodel.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.inquerymodel.R;
import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.RecordListBean;
import com.bw.inquerymodel.contract.InqueryContract;
import com.bw.inquerymodel.presenter.InqueryPresenter;
import com.bw.inquerymodel.utils.RsaCoder;
import com.bw.inquerymodel.view.adapter.RecirdListRecycleAdapter;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.MessageContent;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.options.MessageSendingOptions;
import cn.jpush.im.api.BasicCallback;

import static cn.jmessage.biz.httptask.task.GetUserInfoListTask.IDType.username;

public class LiaoTActivity extends BaseActivity<InqueryPresenter> implements InqueryContract.IMainView {
   private String  jiGuangPwd ="R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=";
   private String  userName= "c5nDZM1257647673";
   private String md5;
    private EditText edit;
    private ImageView but_send;
    private String doctorId;
    private Map<String, Object> headerMap;
    private int recordId;
    private String doctorUserName;
    private String username;
    private Map<String, Object> queryMap;
    private XRecyclerView recycle;

    @Override
    protected int bindLayout() {
        return R.layout.activity_liao_t ;
    }

    @Override
    protected InqueryPresenter setPresenter() {
        return new InqueryPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        Intent intent = getIntent ();
        doctorUserName = intent.getStringExtra ( "doctorUserName" );
        doctorId = intent.getStringExtra ( "doctorId" );
        getMapC ();
        presenter.current ( headerMap );

        try {
            String decrypt = RsaCoder.decryptByPublicKey ( jiGuangPwd );
            username = RsaCoder.decryptByPublicKey ( doctorUserName );
            md5 = RsaCoder.MD5 ( decrypt );
        } catch (Exception e) {
            e.printStackTrace ();
        }

        JMessageClient.login(userName, md5, new BasicCallback () {
            @Override
            public void gotResult(int i, String s) {

                Toast.makeText ( LiaoTActivity.this, s+i, Toast.LENGTH_SHORT ).show ();

                if (i==0){
                    but_send.setOnClickListener ( new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {

                            String trim = edit.getText ().toString ().trim ();

                             Log.i("TAG", "onCreate: " + "消息发送成功" +recordId);

                            Map<String, Object> fieldmap = new HashMap<> ();
                            fieldmap.put("inquiryId", recordId);
                            fieldmap.put("content",trim);
                            fieldmap.put("type", 1);
                            fieldmap.put("doctorId", doctorId );
                            presenter.doctorinfo ( headerMap,fieldmap );

                            Conversation conversation = Conversation.createSingleConversation ( userName, "c7f6a1d56cb8da740fd18bfa" );
                            Message message = conversation.createSendMessage ( new TextContent ( trim ) );

                            message.setOnSendCompleteCallback ( new BasicCallback () {
                                @Override
                                public void gotResult(int i, String s) {
                                    if (i==0){
                                        Toast.makeText ( LiaoTActivity.this, "发送成功", Toast.LENGTH_SHORT ).show ();
                                        getMapC ();
                                        getMapD ();
                                        presenter.recordlist ( headerMap,queryMap );
                                        edit.setText ( "" );
                                    }else {
                                        Toast.makeText ( LiaoTActivity.this, "发送失败", Toast.LENGTH_SHORT ).show ();
                                    }
                                }
                            } );

                            MessageSendingOptions options = new MessageSendingOptions();
                            options.setRetainOffline(false);
                            JMessageClient.sendMessage(message);
                        }
                    } );
                }
            }
        });
    }


    /**
     *  接收在线消息
     **/
    public void onEvent(MessageEvent event) {
        //获取事件发生的会话对象
        Message newMessage = event.getMessage();//获取此次离线期间会话收到的新消息列表
        TextContent textContent = (TextContent) newMessage.getContent ();
        String text = textContent.getText ();

        getMapC ();
        getMapD ();
        presenter.recordlist ( headerMap,queryMap );
    }


    @Override
    protected void initView() {
        super.initView ();
        edit = findViewById ( R.id.edit_sendmessage_zyj );
        but_send = findViewById ( R.id. but_send);
        recycle = findViewById ( R.id.lv_chat_dialog );
    }

    @Override
    public void success(EndInquiryBean endInquiryBean) {
//        Toast.makeText ( this, endInquiryBean.getMessage (), Toast.LENGTH_SHORT ).show ();
        edit.setText ( "" );
    }

    @Override
    public void success(CurrentBean currentBean) {
        recordId = currentBean.getResult ().getRecordId ();
    }

    @Override
    public void success(RecordListBean recordListBean) {
        Toast.makeText ( this,recordListBean.getMessage (), Toast.LENGTH_SHORT ).show ();
        List<RecordListBean.ResultBean> result = recordListBean.getResult ();
        List<RecordListBean.ResultBean> reverserResult = new ArrayList<> ();
        // 反转集合 使最新消息在最下面
        for (int i = result.size() - 1; i >= 0; i--) {
            reverserResult.add(result.get(i));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false );
        recycle.setLayoutManager ( linearLayoutManager );
        RecirdListRecycleAdapter recirdListRecycleAdapter = new RecirdListRecycleAdapter ( reverserResult, this );
        recycle.setAdapter ( recirdListRecycleAdapter );
    }

    @Override
    public void fuilerror(String e) {
       Log.e ( "TAG",e);
    }

    public void getMapC( ){
        headerMap = new HashMap<> (  );
        headerMap.put ( "userId","434" );
        headerMap.put ( "sessionId","1577327626255434" );
    }

    public void getMapD( ){
        queryMap = new HashMap<> (  );
        queryMap.put ( "inquiryId",recordId );
        queryMap.put ( "page","1" );
        queryMap.put ( "count","10" );
    }
}
