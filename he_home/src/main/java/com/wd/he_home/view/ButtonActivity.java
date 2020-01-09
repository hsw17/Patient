package com.wd.he_home.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.R2;
import com.wd.he_home.adapter.ViewAdapter;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.fragment.HomeFragment;
import com.wd.he_home.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
@Route(path = "/hehome/activity")
public class ButtonActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {


    @BindView(R2.id.view_pag_er)
    ViewPager viewPagEr;
    @BindView(R2.id.home_tav_false)
    ImageView homeTavFalse;
    @BindView(R2.id.home_tav_true)
    ImageView homeTavTrue;
    @BindView(R2.id.relative_layout_home)
    RelativeLayout relativeLayoutHome;
    @BindView(R2.id.video_tav_false)
    ImageView videoTavFalse;
    @BindView(R2.id.video_tav_true)
    ImageView videoTavTrue;
    @BindView(R2.id.relative_layout_video)
    RelativeLayout relativeLayoutVideo;
    @BindView(R2.id.circle_tav_false)
    ImageView circleTavFalse;
    List<Fragment> list = new ArrayList<>();
    List<RelativeLayout> rlist = new ArrayList<>();
    @BindView(R2.id.relative_layout_circle)
    RelativeLayout relativeLayoutCircle;

    @Override
    protected int bindLayout() {
        return R.layout.activity_button;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Fragment fragment_circle = (Fragment) ARouter.getInstance().build("/fragment_circle/fragment").navigation();
        Fragment fragment_video = (Fragment) ARouter.getInstance().build("/fragment_video/fragment").navigation();


        list.add(new HomeFragment());
//        list.add(fragment_circle);
//        list.add(fragment_video);
        rlist.add(relativeLayoutHome);
        rlist.add(relativeLayoutCircle);
        rlist.add(relativeLayoutVideo);
        ViewAdapter viewAdapter=new ViewAdapter(getSupportFragmentManager(),list);
        viewPagEr.setAdapter(viewAdapter);
    }

    @Override
    public void HomeViewSuccess(Object obj) {

    }

    @Override
    public void HomeViewError(String e) {

    }


}
