package com.bw.videomodule.view.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bw.videomodule.R;
import com.bw.videomodule.api.Contract;
import com.bw.videomodule.bean.CollectionBean;
import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;
import com.bw.videomodule.presenter.IPresenter;
import com.bw.videomodule.view.adapter.FragmentAdapter;
import com.bw.videomodule.view.fragmnet.VideoFragment;


import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.Logger;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/videomodule/activity")
public class VideoMainActivity extends BaseActivity<IPresenter> implements Contract.IMainView {

    private TabLayout tablist;
    private String TAG = "VideoMainActivity";
    private boolean flag = true;

    private ViewPager pager;
    private ImageView imagela;
    private List<VideoCategoryListBean.ResultBean> videoCategoryListBeanResult;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main_viedo;
    }

    @Override
    protected IPresenter setPresenter() {
        return new IPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        tablist = findViewById ( R.id.tablist );
        pager = findViewById ( R.id.pager );
        imagela = findViewById ( R.id.imagela );

        presenter.videocategorylist ();

        imagela.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                ObjectAnimator translationX = new ObjectAnimator().ofFloat( imagela,"translationX",0,0);
                ObjectAnimator translationY = new ObjectAnimator().ofFloat( imagela,"translationY",0,110f);

                AnimatorSet animatorSet = new AnimatorSet();  //组合动画
                animatorSet.playTogether(translationX,translationY); //设置动画
                animatorSet.setDuration(90);  //设置动画时间
                if (flag==true){
                    animatorSet.start();
                    flag = false;
                }

                tablist.setVisibility ( View.VISIBLE );
            }
        } );

    }

    @Override
    public void success(VideoCategoryListBean videoCategoryListBean) {
        videoCategoryListBeanResult = videoCategoryListBean.getResult ();
        Logger.d ( TAG,videoCategoryListBeanResult.size ()+"" );

        List<String> tablists = new ArrayList<> (  );
        for (int i = 0; i <videoCategoryListBeanResult.size () ; i++) {
            tablists.add ( videoCategoryListBeanResult.get ( i ).getName () );
        }

        List<Fragment> fragmentList = new ArrayList<> (  );
        fragmentList.add ( new VideoFragment () );
//        fragmentList.add ( new VideoFragmentSense () );
//        fragmentList.add ( new VideoFragmentFitness () );
//        fragmentList.add ( new VideoFragmentHaird () );
//        fragmentList.add ( new VideoFragmentHeart ());
//        fragmentList.add ( new VideoFragmentRegimen ());

        FragmentAdapter fragmentAdapter = new FragmentAdapter ( getSupportFragmentManager (), fragmentList ,tablists);
        pager.setAdapter ( fragmentAdapter );

        tablist.setupWithViewPager ( pager );

        tablist.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                ObjectAnimator translationX = new ObjectAnimator().ofFloat(imagela,"translationX",0,0);
                ObjectAnimator translationY = new ObjectAnimator().ofFloat(imagela,"translationY",110f,0);

                AnimatorSet animatorSet = new AnimatorSet();  //组合动画
                animatorSet.playTogether(translationX,translationY); //设置动画
                animatorSet.setDuration(90);  //设置动画时间
                animatorSet.start();
                flag = true;
                tablist.setVisibility ( View.GONE );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
    }

    @Override
    public void success(VideolistBean videolistBean) {
         videolistBean.getResult ();
    }

    @Override
    public void success(CollectionBean collectionBean) {
        Toast.makeText ( this, collectionBean.getMessage (), Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void fuilerror(String e) {
        Logger.d ( TAG,e );
    }

    /**
     * 把状态栏设成透明
     */
    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = VideoMainActivity.this.getWindow().getDecorView();
            decorView.setOnApplyWindowInsetsListener((v, insets) -> {
                WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                return defaultInsets.replaceSystemWindowInsets(
                        defaultInsets.getSystemWindowInsetLeft(),
                        0,
                        defaultInsets.getSystemWindowInsetRight(),
                        defaultInsets.getSystemWindowInsetBottom());
            });
            ViewCompat.requestApplyInsets(decorView);
            getWindow().setStatusBarColor( ContextCompat.getColor(this, android.R.color.transparent));
        }
    }
}
