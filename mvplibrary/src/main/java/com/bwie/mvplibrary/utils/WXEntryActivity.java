package com.bwie.mvplibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.bwie.mvplibrary.app.App;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * date:2019/10/19
 * author:贺少伟(盗)
 * function:
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        //登录回调
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:

                code = ((SendAuth.Resp) baseResp).code;

                finish();
                break;
            //用户拒绝授权
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                Toast.makeText(this, "用户拒绝授权", Toast.LENGTH_SHORT).show();
                finish();
                break;
            //用户取消
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                Toast.makeText(this, "用户取消", Toast.LENGTH_SHORT).show();

                finish();
                break;
            default:
                Toast.makeText(this, "签名错误", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    public String getCode() {
        return code;
    }


}
