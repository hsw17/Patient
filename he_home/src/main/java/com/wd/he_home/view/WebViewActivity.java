package com.wd.he_home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

public class WebViewActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {

    private WebView webView;

    @Override
    protected int bindLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String umpUrl = intent.getStringExtra("umpUrl");
        webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient(){
            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);  //设置WebView属性,运行执行js脚本
        webView.loadUrl(umpUrl);          //调用loadUrl方法为WebView加入链接
        setContentView(webView);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }


    @Override
    public void HomeViewSuccess(Object obj) {


    }

    @Override
    public void HomeViewError(String e) {
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            // 返回上一页面
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
