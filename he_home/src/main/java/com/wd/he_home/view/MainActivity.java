package com.wd.he_home.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bwie.mvplibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.stx.xhb.xbanner.XBanner;
import com.wd.he_home.R;
import com.wd.he_home.adapter.EnquirySectionAdapter;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.bean.HealthinformationBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：MainActivity 首页
 * @data（日期）: 2019/12/14
 * @time（时间）: 8:21
 * @author（作者）: Liuhe
 **/
public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {


    @BindView(R.id.home_xbanner_top)
    XBanner homeXbannerTop;
    @BindView(R.id.home_Title)
    TextView homeTitle;
    @BindView(R.id.home_lore)
    LinearLayout homeLore;
    @BindView(R.id.strut)
    View strut;
    @BindView(R.id.disease_img)
    ImageView diseaseImg;
    @BindView(R.id.drugs_img)
    ImageView drugsImg;
    @BindView(R.id.home_inquiry)
    LinearLayout homeInquiry;
    @BindView(R.id.home_XRecyclerView)
    RecyclerView homeXRecyclerView;
    @BindView(R.id.home_evaluation)
    ImageView homeEvaluation;
    @BindView(R.id.home_tab)
    TabLayout homeTab;
    @BindView(R.id.home_vp)
    ViewPager homeVp;
    private ArrayList<String> strings;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }


    @Override
    protected void initData() {
        super.initData();
        //banner
        presenter.HomePresenterBanner();
        //查询科室
        presenter.HomePresenterChaXunKeShi();
        //设置滑动
        strings = new ArrayList<>();
        strings.add("健康要闻");
        strings.add("医学动态");
        strings.add("医疗动态");
        strings.add("养生美容");
        strings.add("健身减肥");

    }

    //轮播图
    @Override
    public void HomeViewBannerSuccess(Object obj) {
        BannerBean bannerBean = (BannerBean) obj;
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        homeXbannerTop.setData(result,null);
        homeXbannerTop.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(context()).load(result.get(position).getImageUrl()).into((ImageView) view);
            }
        });
        //健康咨询
        HealthinformationBean healthinformationBean = (HealthinformationBean) obj;
    }

    @Override
    public void HomeViewBannerError(String e) {

    }

    //查询科室
    @Override
    public void HomeViewChaXunKeShiSuccess(EnquirySectionBean enquirySectionBean) {
        List<EnquirySectionBean.ResultBean> result = enquirySectionBean.getResult();
        EnquirySectionAdapter enquirySectionAdapter = new EnquirySectionAdapter(MainActivity.this, result);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 4);
        homeXRecyclerView.setLayoutManager(gridLayoutManager);
        homeXRecyclerView.setAdapter(enquirySectionAdapter);

    }

    @Override
    public void HomeViewChaXunKeShiError(String e) {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_xbanner_top, R.id.home_Title, R.id.home_lore, R.id.strut, R.id.disease_img, R.id.drugs_img, R.id.home_inquiry, R.id.home_XRecyclerView, R.id.home_evaluation, R.id.home_tab, R.id.home_vp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_xbanner_top:
                break;
            case R.id.home_Title:
                break;
            case R.id.home_lore:
                break;
            case R.id.strut:
                break;
            case R.id.disease_img:
                break;
            case R.id.drugs_img:
                break;
            case R.id.home_inquiry:
                break;
            case R.id.home_XRecyclerView:
                break;
            case R.id.home_evaluation:
                break;
            case R.id.home_tab:
                break;
            case R.id.home_vp:
                break;
        }
    }
}
