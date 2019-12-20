package com.bw.videomodule.view.fragmnet;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.videomodule.R;
import com.bw.videomodule.api.Contract;
import com.bw.videomodule.api.OnViewPagerListener;
import com.bw.videomodule.bean.CollectionBean;
import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;
import com.bw.videomodule.presenter.IPresenter;
import com.bw.videomodule.utils.TikTokController;
import com.bw.videomodule.utils.ViewPagerLayoutManager;
import com.bw.videomodule.view.activity.MainActivity;
import com.bw.videomodule.view.adapter.TikTokAdapter;
import com.bw.videomodule.view.weight.CenteredImageSpan;
import com.bw.videomodule.view.weight.DanmukuVideoView;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.utils.Logger;
import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.dueeeke.videoplayer.util.PlayerUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SpannedCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/18
 * @Description:
 */
public class VideoFragment extends BaseFragment<IPresenter> implements Contract.IMainView {
    DanmukuVideoView danmukuVideoView;
    private IjkVideoView mIjkVideoView;
    private TikTokController mTikTokController;
    private int mPosition = 0;
    private String TAG = "VideoFragment";
    private int mCurrentPosition;
    private List<VideoCategoryListBean.ResultBean> videoCategoryListBeanResult;
    private List<VideolistBean.ResultBean> videolistBeanResult;
    private ViewPagerLayoutManager layoutManager;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";
    private RecyclerView video;
    private FloatingActionButton pay;
    private FloatingActionButton shouchang;
    private FloatingActionButton danmu;
    private TextView videoname;
    private TextView videotext;
    private ImageView starta;
    private ImageView pouse;
    private LinearLayout goumai;
    private TextView buynumber;
    private FloatingActionButton shouchangs;
    private FloatingActionButton pays;
    private FloatingActionButton danmus;
    private TextView times;
    private int counts = 15;
    private DanmakuView mDanmakuView;
    private DanmakuContext mContext;
    private BaseDanmakuParser mParser;

    @Override
    public void success(VideoCategoryListBean videoCategoryListBean) {
        videoCategoryListBeanResult = videoCategoryListBean.getResult ();

        int id = videoCategoryListBeanResult.get ( 2 ).getId ();
        getMap ( id );
    }

    @Override
    public void success(VideolistBean videolistBean) {

        videolistBeanResult = videolistBean.getResult ();

        if (layoutManager==null){
            layoutManager = new ViewPagerLayoutManager (getActivity (), OrientationHelper.VERTICAL,false);
        }

        video.setLayoutManager( layoutManager );
        TikTokAdapter tikTokAdapter = new TikTokAdapter( videolistBeanResult, getActivity ());
        video.setAdapter( tikTokAdapter );


        int whetherBuy = videolistBeanResult.get ( 0 ).getWhetherBuy ();
        int whetherCollection = videolistBeanResult.get ( 0 ).getWhetherCollection ();

        if (whetherBuy == 1){
            //已收藏
            pay.hide ();
            pays.show ();
        }else if (whetherBuy==2){
            //未收藏
            pay.show ();
            pays.hide ();
        }

        if (whetherCollection==1){
            //已购买
            shouchang.hide ();
            shouchangs.show ();
        }else if (whetherCollection==2){
            //未购买
            shouchang.show ();
            shouchangs.hide ();
        }

        danmus.hide ();

        layoutManager.setOnViewPagerListener( new OnViewPagerListener () {
            @Override
            public void onInitComplete() {
                //自动播放第一条
                startPlay(0);

                String title = videolistBeanResult.get ( 0 ).getTitle ();
                String abstracts = videolistBeanResult.get ( 0 ).getAbstracts ();
                int buyNum = videolistBeanResult.get ( 0 ).getBuyNum ();
                buynumber.setText ( buyNum+"万人\n已购买" );
                videoname.setText ( title );
                videotext.setText ( abstracts );

                int whetherBuy = videolistBeanResult.get ( 0 ).getWhetherBuy ();
                if (whetherBuy == 1){
                    pay.hide ();
                    pays.show ();
                }
                int whetherCollection = videolistBeanResult.get ( 0 ).getWhetherCollection ();
                if (whetherCollection==1){
                    shouchang.hide ();
                    shouchangs.show ();
                }

                handler.sendEmptyMessage ( 1 );
                times.setText ( "15s" );
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                if (mCurrentPosition == position) {
                    danmukuVideoView.release();
                }


            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                if (mCurrentPosition == position) return;

                mPosition = position;
                mCurrentPosition = position;

                startPlay(position);

                String title = videolistBeanResult.get ( position ).getTitle ();
                String abstracts = videolistBeanResult.get ( position ).getAbstracts ();
                int buyNum = videolistBeanResult.get ( position ).getBuyNum ();
                buynumber.setText ( buyNum+"万人\n已购买" );

                videoname.setText ( title );
                videotext.setText ( abstracts );


                int whetherBuy = videolistBeanResult.get ( position ).getWhetherBuy ();
                if (whetherBuy == 1){
                    pay.hide ();
                    pays.show ();
                }
                int whetherCollection = videolistBeanResult.get ( position ).getWhetherCollection ();
                if (whetherCollection==1){
                    shouchang.hide ();
                    shouchangs.show ();
                }

                handler.sendEmptyMessage ( 1 );
                goumai.setVisibility ( View.VISIBLE );
                times.setText ( "15s" );
            }
        });

    }

    @Override
    public void success(CollectionBean collectionBean) {
        Toast.makeText ( getActivity (), collectionBean.getMessage (), Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void fuilerror(String e) {
        Logger.d ( TAG,e );
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_layout;
    }

    @Override
    protected IPresenter setPresenter() {
        return new IPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        initDanMuView ();
        setStatusBarTransparent();
        starta.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                danmukuVideoView.start ();
                starta.setVisibility ( View.GONE );
            }
        } );

        pouse.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                danmukuVideoView.pause();
                starta.setVisibility (View.VISIBLE);
            }
        } );

        shouchang.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                getMapC ( mPosition );
            }
        } );

        pay.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );

        pays.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );

        shouchangs.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                getMapC ( mPosition );
            }
        } );

        danmu.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                danmus.show ();
                showDanMu ( v );
                addDanmaku ( v );
//                danmu.hide ();
            }
        } );

        danmus.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                danmu.show ();
                hideDanMu ( v );
                danmus.hide ();
            }
        } );

        fpresenter.videocategorylist ();

//        mIjkVideoView = new IjkVideoView ( getActivity () );
////        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
////        mIjkVideoView.setPlayerConfig(config);
//        mTikTokController = new TikTokController (getActivity ());
//        mTikTokController.setPlayState ( 3 );
//        mIjkVideoView.setVideoController( mTikTokController );

        danmukuVideoView = new DanmukuVideoView ( getActivity () );
        danmukuVideoView.addDanmukuView ( mDanmakuView, mContext, mParser );
        PlayerConfig config = new PlayerConfig.Builder ().setLooping ().build ();
        danmukuVideoView.setPlayerConfig ( config );
        danmukuVideoView.setVideoController ( new StandardVideoController ( getActivity () ) );

        pay.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText ( getActivity (), mPosition+"", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

    @Override
    protected void initView() {
        super.initView ();
        video = getActivity ().findViewById ( R.id.video );
        pay = getActivity ().findViewById ( R.id.pay );
        shouchang = getActivity ().findViewById ( R.id.shouchang );
        danmu = getActivity ().findViewById ( R.id.danmu );
        videoname = getActivity ().findViewById ( R.id.videoname );
        videotext = getActivity ().findViewById ( R.id.videotext );
        starta = getActivity ().findViewById ( R.id.starta );
        pouse = getActivity ().findViewById ( R.id.pouse );
        goumai = getActivity ().findViewById ( R.id.goumai );
        buynumber = getActivity ().findViewById ( R.id.buynumber );
        shouchangs = getActivity ().findViewById ( R.id.shouchangs );
        pays = getActivity ().findViewById ( R.id.pays );
        danmus = getActivity ().findViewById ( R.id.danmus );
        times = getActivity ().findViewById ( R.id.times );
    }


    private void startPlay(int position) {

        View itemView = video.getChildAt(0);
        FrameLayout frameLayout = itemView.findViewById(R.id.container);
//        Glide.with(getActivity ())
//                .load(path)
//                .placeholder(android.R.color.white)
//                .into(mTikTokController.getThumb());
        ViewParent parent = danmukuVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(danmukuVideoView);
        }
        frameLayout.addView(danmukuVideoView);
        danmukuVideoView.setUrl(videolistBeanResult.get(position).getShearUrl ());
        danmukuVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        danmukuVideoView.start();
    }

    @Override
    public void onPause() {
        super.onPause ();
        danmukuVideoView.pause ();
    }

    @Override
    public void onResume() {
        super.onResume ();
    }

    @Override
    public void onDestroy() {
        super.onDestroy ();
        danmukuVideoView.release ();
    }


    public void getMap(int categoryId){
        Map<String, Object> headerMap = new HashMap<> ();
        headerMap.put ( "userId", "441" );
        headerMap.put ( "sessionId", "1576409538322441" );

        Map<String, Object> queryMap = new HashMap<> ();
        queryMap.put ( "categoryId", categoryId );
        queryMap.put ( "page", 1 );
        queryMap.put ( "count", 5 );

        fpresenter.videoList ( headerMap,queryMap);
    }

    public void getMapC(int categoryId){
        Map<String, Object> headerMap = new HashMap<> ();
        headerMap.put ( "userId", "441" );
        headerMap.put ( "sessionId", "1576582364721441" );

        Map<String, Object> queryMap = new HashMap<> ();
        queryMap.put ( "videoId", categoryId );

        fpresenter.collection ( headerMap,queryMap);
    }

    /**
     * 把状态栏设成透明
     */
    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getActivity ().getWindow().getDecorView();
            decorView.setOnApplyWindowInsetsListener((v, insets) -> {
                WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                return defaultInsets.replaceSystemWindowInsets(
                        defaultInsets.getSystemWindowInsetLeft(),
                        0,
                        defaultInsets.getSystemWindowInsetRight(),
                        defaultInsets.getSystemWindowInsetBottom());
            });
            ViewCompat.requestApplyInsets(decorView);
            getActivity ().getWindow().setStatusBarColor( ContextCompat.getColor(getActivity (), android.R.color.transparent));
        }
    }

    public void showDanMu(View view) {
        if (mDanmakuView != null) mDanmakuView.show ();
    }

    public void hideDanMu(View view) {
        if (mDanmakuView != null) mDanmakuView.hide ();

    }

    public void addDanmaku(View view) {
        mContext.setCacheStuffer ( new SpannedCacheStuffer (), null );
        BaseDanmaku danmaku = mContext.mDanmakuFactory.createDanmaku ( BaseDanmaku.TYPE_SCROLL_RL );
        if (danmaku == null || mDanmakuView == null) {
            return;
        }

        danmaku.text = "这是一条普通弹幕~";
        danmaku.priority = 0;  // 可能会被各种过滤器过滤并隐藏显示
        danmaku.isLive = false;
        danmaku.setTime ( mDanmakuView.getCurrentTime () + 1200 );
        danmaku.textSize = PlayerUtils.sp2px ( getActivity (), 12 );
        danmaku.textColor = Color.WHITE;
        danmaku.textShadowColor = Color.RED;
        // danmaku.underlineColor = Color.GREEN;
        danmaku.borderColor = Color.GREEN;
        mDanmakuView.addDanmaku ( danmaku );
    }

    public void addDanmakuWithDrawable(View view) {
        mContext.setCacheStuffer ( new BackgroundCacheStuffer (), null );
        BaseDanmaku danmaku = mContext.mDanmakuFactory.createDanmaku ( BaseDanmaku.TYPE_SCROLL_RL );
        if (danmaku == null || mDanmakuView == null) {
            return;
        }
        // for(int i=0;i<100;i++){
        // }
        Drawable drawable = ContextCompat.getDrawable ( getActivity (), R.mipmap.ic_launcher_round );
        int size = PlayerUtils.dp2px ( getActivity (), 20 );
        drawable.setBounds ( 0, 0, size, size );

//        danmaku.text = "这是一条弹幕";
        danmaku.text = createSpannable ( drawable );
//        danmaku.padding = 5;
        danmaku.priority = 0;  // 可能会被各种过滤器过滤并隐藏显示
        danmaku.isLive = false;
        danmaku.setTime ( mDanmakuView.getCurrentTime () + 1200 );
        danmaku.textSize = PlayerUtils.sp2px ( getActivity (), 12 );
        danmaku.textColor = Color.RED;
        danmaku.textShadowColor = Color.WHITE;
        // danmaku.underlineColor = Color.GREEN;
//        danmaku.borderColor = Color.GREEN;
        mDanmakuView.addDanmaku ( danmaku );

    }

    private SpannableStringBuilder createSpannable(Drawable drawable) {
        String text = "bitmap";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder ( text );
        CenteredImageSpan span = new CenteredImageSpan ( drawable );//ImageSpan.ALIGN_BOTTOM);
        spannableStringBuilder.setSpan ( span, 0, text.length (), Spannable.SPAN_INCLUSIVE_EXCLUSIVE );
        spannableStringBuilder.append ( " 这是一条自定义弹幕~" );
        return spannableStringBuilder;
    }



    private void initDanMuView() {
// 设置最大显示行数
        HashMap<Integer, Integer> maxLinesPair = new HashMap<> ();
        maxLinesPair.put ( BaseDanmaku.TYPE_SCROLL_RL, 5 ); // 滚动弹幕最大显示5行
        // 设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<> ();
        overlappingEnablePair.put ( BaseDanmaku.TYPE_SCROLL_RL, true );
        overlappingEnablePair.put ( BaseDanmaku.TYPE_FIX_TOP, true );

        mDanmakuView = new DanmakuView ( getActivity () );
        mContext = DanmakuContext.create ();
        mContext.setDanmakuStyle ( IDisplayer.DANMAKU_STYLE_STROKEN, 3 ).setDuplicateMergingEnabled ( false ).setScrollSpeedFactor ( 1.2f ).setScaleTextSize ( 1.2f )
//                .setCacheStuffer(new SpannedCacheStuffer(), null) // 图文混排使用SpannedCacheStuffer
                .setCacheStuffer ( new BackgroundCacheStuffer (), null )  // 绘制背景使用BackgroundCacheStuffer
                .setMaximumLines ( maxLinesPair )
                .preventOverlapping ( overlappingEnablePair ).setDanmakuMargin ( 40 );
        if (mDanmakuView != null) {
            mParser = new BaseDanmakuParser () {
                @Override
                protected IDanmakus parse() {
                    return new Danmakus ();
                }
            };
            mDanmakuView.setCallback ( new DrawHandler.Callback () {
                @Override
                public void updateTimer(DanmakuTimer timer) {
                }

                @Override
                public void drawingFinished() {

                }

                @Override
                public void danmakuShown(BaseDanmaku danmaku) {
//                    Log.d("DFM", "danmakuShown(): text=" + danmaku.text);
                }

                @Override
                public void prepared() {
                    mDanmakuView.start ();
                }
            } );
            mDanmakuView.setOnDanmakuClickListener ( new IDanmakuView.OnDanmakuClickListener () {

                @Override
                public boolean onDanmakuClick(IDanmakus danmakus) {
                    Log.d ( "DFM", "onDanmakuClick: danmakus size:" + danmakus.size () );
                    BaseDanmaku latest = danmakus.last ();
                    if (null != latest) {
                        Log.d ( "DFM", "onDanmakuClick: text of latest danmaku:" + latest.text );
                        return true;
                    }
                    return false;
                }

                @Override
                public boolean onDanmakuLongClick(IDanmakus danmakus) {
                    return false;
                }

                @Override
                public boolean onViewClick(IDanmakuView view) {
                    return false;
                }
            } );
            mDanmakuView.showFPS ( true );
            mDanmakuView.enableDanmakuDrawingCache ( true );
        }
    }


    private class BackgroundCacheStuffer extends SpannedCacheStuffer {


        // 通过扩展SimpleTextCacheStuffer或SpannedCacheStuffer个性化你的弹幕样式
        final Paint paint = new Paint ();

        @Override
        public void measure(BaseDanmaku danmaku, TextPaint paint, boolean fromWorkerThread) {
//            danmaku.padding = 5;  // 在背景绘制模式下增加padding
            super.measure ( danmaku, paint, fromWorkerThread );
        }

        @Override
        public void drawBackground(BaseDanmaku danmaku, Canvas canvas, float left, float top) {
            paint.setAntiAlias ( true );
            paint.setColor ( Color.parseColor ( "#65777777" ) );//黑色 普通
            int radius = PlayerUtils.dp2px ( getActivity (), 10 );
            canvas.drawRoundRect ( new RectF ( left, top, left + danmaku.paintWidth, top + danmaku.paintHeight ), radius, radius, paint );
        }

        @Override
        public void drawStroke(BaseDanmaku danmaku, String lineText, Canvas canvas, float left, float top, Paint paint) {
            // 禁用描边绘制
        }
    }


    Handler handler = new Handler (  ){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage ( msg );
            if (msg.what==1){
                counts--;
                 if (counts>0){
                    times.setText ( counts+"s" );
                    handler.sendEmptyMessageDelayed ( 1,1000 );
                }else{
                    counts = 15;
                    goumai.setVisibility ( View.GONE );
                }
            }
        }
    };
}
