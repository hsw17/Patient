package com.bw.videomodule.view.fragmnet;


import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.bw.videomodule.view.adapter.TikTokAdapter;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.utils.Logger;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/18
 * @Description:
 */
public class VideoFragmentRegimen extends BaseFragment<IPresenter> implements Contract.IMainView {
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
    private ImageView pouse;
    private ImageView starta;
    private TextView goumai;
    private TextView buynumber;

    @Override
    public void success(VideoCategoryListBean videoCategoryListBean) {
        videoCategoryListBeanResult = videoCategoryListBean.getResult ();

        int id = videoCategoryListBeanResult.get ( 5 ).getId ();
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
                mCurrentPosition = position;

                startPlay(position);


                String title = videolistBeanResult.get ( position ).getTitle ();
                String abstracts = videolistBeanResult.get ( position ).getAbstracts ();
                int buyNum = videolistBeanResult.get ( position ).getBuyNum ();
                buynumber.setText ( buyNum+"万人\n已购买" );

                videoname.setText ( title );
                videotext.setText ( abstracts );
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




        starta.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                mIjkVideoView.start ();
                starta.setVisibility ( View.GONE );
            }
        } );

        pouse.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                mIjkVideoView.pause();
                starta.setVisibility (View.VISIBLE);
            }
        } );

        shouchang.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                getMapC ( mPosition );
            }
        } );

        fpresenter.videocategorylist ();

        mIjkVideoView = new IjkVideoView ( getActivity () );
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
        mTikTokController = new TikTokController (getActivity ());
        mIjkVideoView.setVideoController( mTikTokController );

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
    }


    private void startPlay(int position) {
        View itemView = video.getChildAt(0);
        FrameLayout frameLayout = itemView.findViewById(R.id.container);
        Glide.with(getActivity ())
                .load(path)
                .placeholder(android.R.color.black)
                .into(mTikTokController.getThumb());
        ViewParent parent = mIjkVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(mIjkVideoView);
        }
        frameLayout.addView(mIjkVideoView);
        mIjkVideoView.setUrl(videolistBeanResult.get ( position ).getShearUrl ());
        mIjkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        mIjkVideoView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mIjkVideoView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mIjkVideoView.resume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
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
}
