package com.wd.he_home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.bean.ConsultationDetailsBean;
import com.wd.he_home.bean.NewslistBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.List;

public class FindInfoActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {

    private ImageView image_fanhui;
    private WebView webView;
    private ConsultationDetailsBean.ResultBean  result;
    private Intent intent;
    private String in_id;


    @Override
    protected int bindLayout() {
        return R.layout.activity_find_info;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        image_fanhui = findViewById(R.id.image_fanhui);
        webView = findViewById(R.id.find_webview);
    }
    @Override
    protected void initData() {
        super.initData();
        intent = getIntent();
        in_id = intent.getStringExtra("in_id");
        WebSettings settings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        // settings.setBlockNetworkImage(true);// 把图片加载放在最后来加载渲染
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        presenter.HomePresenterZiXunXiangQing("432","1576543952843432",in_id);
        //点击销毁
        image_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof ConsultationDetailsBean){
            ConsultationDetailsBean consultationDetailsBean = (ConsultationDetailsBean) obj;
            result = consultationDetailsBean.getResult();
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            webView.loadDataWithBaseURL(null,result.getContent(), "html/text", "utf-8", null);
            webView.setWebChromeClient(new WebChromeClient());
        }
    }

    @Override
    public void HomeViewError(String e) {

    }
}
