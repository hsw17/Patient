package com.bw.videomodule.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.videomodule.R;
import com.bw.videomodule.api.Contract;
import com.bw.videomodule.api.OnViewPagerListener;
import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;
import com.bw.videomodule.presenter.IPresenter;
import com.bw.videomodule.utils.TikTokController;
import com.bw.videomodule.utils.ViewPagerLayoutManager;
import com.bw.videomodule.view.adapter.TikTokAdapter;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.Logger;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity<IPresenter> implements Contract.IMainView {

    private List<VideoCategoryListBean.ResultBean> videoCategoryListBeanResult;
    private List<VideolistBean.ResultBean> videolistBeanResult;
    private TabLayout tablist;
    private RecyclerView mPlayer;
    private String TAG = "MainActivity";
    private IjkVideoView mIjkVideoView;
    private TikTokController mTikTokController;
    private int mCurrentPosition;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";
    private ViewPagerLayoutManager layoutManager;
    private int mPosition = 0;
    private FloatingActionButton pay;
    private FloatingActionButton shouchang;
    private FloatingActionButton danmu;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected IPresenter setPresenter() {
        return new IPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        tablist = findViewById ( R.id.tablist );
        mPlayer = findViewById ( R.id.video );
        pay = findViewById ( R.id.pay );
        shouchang = findViewById ( R.id.shouchang );
        danmu = findViewById ( R.id.danmu );
        presenter.videocategorylist ();

//        setStatusBarTransparent();

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle("抖音");
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

        mIjkVideoView = new IjkVideoView ( MainActivity.this );
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
        mTikTokController = new TikTokController (MainActivity.this);
        mIjkVideoView.setVideoController( mTikTokController );

        pay.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText ( MainActivity.this, mPosition+"", Toast.LENGTH_SHORT ).show ();
            }
        } );

    }

    @Override
    public void success(VideoCategoryListBean videoCategoryListBean) {
        videoCategoryListBeanResult = videoCategoryListBean.getResult ();

        int id = videoCategoryListBeanResult.get ( 0 ).getId ();
        getMap ( id );

        for (int i = 0; i < videoCategoryListBeanResult.size (); i++) {
            tablist.addTab ( tablist.newTab () );
        }

        for (int i = 0; i < videoCategoryListBeanResult.size (); i++) {
            tablist.getTabAt ( i ).setText ( videoCategoryListBean.getResult ().get ( i ).getName () );
        }

        tablist.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition ();
                layoutManager.removeAllViews ();
                int id = videoCategoryListBeanResult.get ( position ).getId ();
                getMap ( id );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                int position = tab.getPosition ();
//                Toast.makeText ( MainActivity.this, position+"", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

    @Override
    public void success(VideolistBean videolistBean) {
        videolistBeanResult = videolistBean.getResult ();

        if (layoutManager==null){
            layoutManager = new ViewPagerLayoutManager(MainActivity.this, OrientationHelper.VERTICAL,false);
        }

        mPlayer.setLayoutManager( layoutManager );
        TikTokAdapter tikTokAdapter = new TikTokAdapter( videolistBeanResult, MainActivity.this);
        mPlayer.setAdapter( tikTokAdapter );

        layoutManager.setOnViewPagerListener( new OnViewPagerListener () {
            @Override
            public void onInitComplete() {
                //自动播放第一条
                startPlay(0);
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                if (mCurrentPosition == position) {
                    mIjkVideoView.release();
                }
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                if (mCurrentPosition == position) return;
                mPosition = position;
                startPlay(position);
                mCurrentPosition = position;
            }
        });
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
            View decorView = MainActivity.this.getWindow().getDecorView();
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

    private void startPlay(int position) {
        View itemView = mPlayer.getChildAt(0);
        FrameLayout frameLayout = itemView.findViewById(R.id.container);
        Glide.with(this)
                .load(path)
                .placeholder(android.R.color.black)
                .into(mTikTokController.getThumb());
        ViewParent parent = mIjkVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(mIjkVideoView);
        }
        frameLayout.addView(mIjkVideoView);
        mIjkVideoView.setUrl(videolistBeanResult.get ( position ).getOriginalUrl ());
        mIjkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        mIjkVideoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIjkVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIjkVideoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIjkVideoView.release();
    }


    public void getMap(int categoryId){
        Map<String, Object> headerMap = new HashMap<> ();
        headerMap.put ( "userId", "441" );
        headerMap.put ( "sessionId", "1576409538322441" );

        Map<String, Object> queryMap = new HashMap<> ();
        queryMap.put ( "categoryId", categoryId );
        queryMap.put ( "page", 1 );
        queryMap.put ( "count", 5 );

        presenter.videoList ( headerMap,queryMap);
    }

}
