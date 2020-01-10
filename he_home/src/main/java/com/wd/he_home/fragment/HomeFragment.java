package com.wd.he_home.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.google.android.material.tabs.TabLayout;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.wd.he_home.R;
import com.wd.he_home.R2;
import com.wd.he_home.adapter.EnquirySectionAdapter;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.fragment.jiankangzixun.Fitnessweightloss_Fragment;
import com.wd.he_home.fragment.jiankangzixun.Healthbeauty_Fragment;
import com.wd.he_home.fragment.jiankangzixun.MedicalnewsFragment;
import com.wd.he_home.fragment.jiankangzixun.Medicalnews_oneFragment;
import com.wd.he_home.presenter.HomePresenter;
import com.wd.he_home.util.vp.CustomScrollViewPager;
import com.wd.he_home.view.CommonActivity;
import com.wd.he_home.view.MainHomeActivity;
import com.wd.he_home.view.SearchPageActivity;
import com.wd.he_home.view.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * date:2020/1/9
 * author:贺少伟(盗)
 * function:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView{
    private NestedScrollView nestedScrollView;
    private EditText edit_shu;
    @BindView(R2.id.home_Title)
    TextView homeTitle;
    @BindView(R2.id.home_lore)
    LinearLayout homeLore;
    @BindView(R2.id.strut)
    View strut;
    @BindView(R2.id.disease_img)
    ImageView diseaseImg;
    @BindView(R2.id.drugs_img)
    ImageView drugsImg;
    @BindView(R2.id.home_inquiry)
    LinearLayout homeInquiry;
    @BindView(R2.id.home_evaluation)
    ImageView homeEvaluation;
    TabLayout homeTab;
    ViewPager homeVp;
    private List<String> strings;
    private List<Fragment> fragments;
    private BannerBean bannerBean;
    private XBanner homeXbannerTop;
    private CustomScrollViewPager customScrollViewPager;
    private Intent intent;
    private RecyclerView home_XRecyclerView;
    private ImageView touxiang;

    //    private Button inten;
    @Override
    protected int bindLayout() {
        return R.layout.item_home;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        //防止事件冲突
        nestedScrollView = getActivity().findViewById(R.id.main_NestedScrollView);
        touxiang = getActivity().findViewById(R.id.touxiang);
        nestedScrollView.setNestedScrollingEnabled(false);
        edit_shu = getActivity().findViewById(R.id.edit_shu);
        edit_shu.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                //跳转到搜索页面
                startActivity(new Intent(context(), SearchPageActivity.class));
            }

            @Override
            protected void onFastClick() {

            }
        });
        homeTab = getActivity().findViewById(R.id.home_tab);
        homeVp = getActivity().findViewById(R.id.home_vp);
        home_XRecyclerView = getActivity().findViewById(R.id.home_XRecyclerView);
        homeXbannerTop = getActivity().findViewById(R.id.home_xbanner_top);
//        inten = getActivity().findViewById(R.id.inten);
//        inten.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ARouter.getInstance().build("/he_bing/activity").navigation();
//            }
//        });
        touxiang.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                ARouter.getInstance().build("/mymodlue/activity").navigation();
            }

            @Override
            protected void onFastClick() {

            }
        });
        //banner
        fpresenter.HomePresenterBanner();
        //查询科室
        fpresenter.HomePresenterChaXunKeShi();
        //健康咨询
        fpresenter.HomePresenterJianKangZiXun();
        //添加页面
        fragments = new ArrayList<>();
        fragments.add(new HealthHighlightsFragment());
        fragments.add(new MedicalnewsFragment());
        fragments.add(new Medicalnews_oneFragment());
        fragments.add(new Healthbeauty_Fragment());
        fragments.add(new Fitnessweightloss_Fragment());
        //设置滑动
        strings = new ArrayList<>();
        strings.add("健康要闻");
        strings.add("医学动态");
        strings.add("医疗动态");
        strings.add("养生美容");
        strings.add("健身减肥");
        //设置联动
        homeVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }


            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        homeTab.setupWithViewPager(homeVp);
    }
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.home_Title) {
        } else if (id == R.id.home_lore) {
        } else if (id == R.id.strut) {
        } else if (id == R.id.disease_img) {//跳转到常见病症
            Intent intent = new Intent(getContext(), CommonActivity.class);
            intent.putExtra("one", 0 + "");
            startActivity(intent);
        } else if (id == R.id.drugs_img) {
            Intent intent;
            intent = new Intent(getContext(), CommonActivity.class);
            intent.putExtra("one", 1 + "");
            startActivity(intent);
        } else if (id == R.id.home_inquiry) {
        } else if (id == R.id.home_XRecyclerView) {
        } else if (id == R.id.home_evaluation) {
        } else if (id == R.id.home_tab) {
        } else if (id == R.id.home_vp) {
        }
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        //轮播图
        if (obj instanceof BannerBean) {
            bannerBean = (BannerBean) obj;
            List<BannerBean.ResultBean> result = bannerBean.getResult();
            homeXbannerTop.setData(result, null);
            homeXbannerTop.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(context()).load(result.get(position).getImageUrl())
                            .placeholder(R.mipmap.doctor)
                            .error(R.mipmap.dermatology)
                            .into((ImageView) view);
                }

            });
            homeXbannerTop.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
            //点击跳转新的页面
            homeXbannerTop.setOnItemClickListener(new XBanner.OnItemClickListener() {
                private Intent intent;

                @Override
                public void onItemClick(XBanner banner, int position) {
                    intent = new Intent(context(), WebViewActivity.class);
                    intent.putExtra("umpUrl", bannerBean.getResult().get(position).getJumpUrl());
                    startActivity(intent);
                }
            });
        } else if (obj instanceof EnquirySectionBean) {
            //查询科室
            EnquirySectionBean enquirySectionBean = (EnquirySectionBean) obj;
            List<EnquirySectionBean.ResultBean> result = enquirySectionBean.getResult();
            EnquirySectionAdapter enquirySectionAdapter = new EnquirySectionAdapter(getContext(), result);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            home_XRecyclerView.setLayoutManager(gridLayoutManager);
            home_XRecyclerView.setAdapter(enquirySectionAdapter);
            //接口回调传值
            enquirySectionAdapter.getEnqiryClick(new EnquirySectionAdapter.setEnqiryClick() {
                @Override
                public void setOnClick(String position) {
                   /* //挑战到问诊咨询
                    Intent intent = new Intent(MainHomeActivity.this,ConsultationActivity.class);
                   // intent.putExtra("position",position);
                    startActivity(intent);*/
                }
            });

        }/*else if (obj instanceof NewslistBean){
                //查询咨询列表
                NewslistBean newslistBean = (NewslistBean) obj;
                List<NewslistBean.ResultBean> result = newslistBean.getResult();
                //设置适配器
                NewslistAdapter newslistAdapter = new NewslistAdapter(result, context());
            }*/
    }

    @Override
    public void HomeViewError(String e) {
    }
}
