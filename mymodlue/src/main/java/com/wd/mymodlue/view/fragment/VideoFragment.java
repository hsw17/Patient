package com.wd.mymodlue.view.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.VideoCollectBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.VideoAdapter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * date:2019/12/24
 * author:贺少伟(盗)
 * function:
 */
public class VideoFragment extends BaseFragment<Persenter> implements IViewContract.IView {
    @BindView(R2.id.record_linear_layout)
    LinearLayout recordLinearLayout;

    RecyclerView reListView;
    private SPUtils login;
    private Map<String, Object> map;
    private Map<String, Object> oap;
    @Override
    protected int bindLayout() {
        return R.layout.item_fragment_video;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    protected void initView() {
        super.initView();
        reListView=getActivity().findViewById(R.id.re_list_view);
        ToastUtils.init(getContext());
//        获取存储内容
        login = new SPUtils(getContext(), "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        oap = new HashMap<>();
        oap.put("page", 1);
        oap.put("count", 10);
        fpresenter.onVideoCollectionList(map, oap);

    }

    @Override
    public void onSuccess(Object obj) {
        VideoCollectBean videoCollectBean= (VideoCollectBean) obj;
        if ("0000".equals(videoCollectBean.status)) {
            List<VideoCollectBean.ResultBean> result = videoCollectBean.result;
            if (result.size()==0) {
                recordLinearLayout.setVisibility(View.VISIBLE);
                return;
            }else{
                VideoAdapter videoAdapter = new VideoAdapter(result);
                reListView.setLayoutManager(new LinearLayoutManager(getContext()));
                reListView.setAdapter(videoAdapter);
                videoAdapter.setAreaView(new VideoAdapter.AreaView() {
                    @Override
                    public void onCurress(int id) {
                        fpresenter.onVideoCollection(map,id);
                    }

                    @Override
                    public void onCurre(IjkVideoView IjkView) {

                    }
                });

            }

        }else{
            ToastUtils.show(videoCollectBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean= (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            fpresenter.onVideoCollectionList(map, oap);

        }else{
            ToastUtils.show(userBean.message);
        }
    }

    @Override
    public void onSuccessTwo(Object two) {

    }

    @Override
    public void onSuccessThree(Object three) {

    }

    @Override
    public void onSuccessFour(Object four) {

    }

    @Override
    public void onFail(String str) {

    }
}
