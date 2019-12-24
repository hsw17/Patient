package com.wd.mymodlue.view.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.CollectionListBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.CircleAdapter;
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
public class CircleFragment extends BaseFragment<Persenter> implements IViewContract.IView {
    LinearLayout recordLinearLayout;
    RecyclerView circleListView;
    private Map<String, Object> map;
    private Map<String, Object> oap;

    @Override
    protected int bindLayout() {
        return R.layout.item_fragment_circle;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    protected void initView() {
        super.initView();
        circleListView=getActivity().findViewById(R.id.circle_list_view);
        recordLinearLayout=getActivity().findViewById(R.id.record_linear_layo);
        ToastUtils.init(getContext());
//        获取存储内容
        SPUtils login = new SPUtils(getContext(), "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        oap = new HashMap<>();
        oap.put("page", 1);
        oap.put("count", 10);
        fpresenter.onCollectionList(map, oap);

    }


    @Override
    public void onSuccess(Object obj) {
        CollectionListBean collectionListBean= (CollectionListBean) obj;
        if ("0000".equals(collectionListBean.status)) {
            List<CollectionListBean.ResultBean> result = collectionListBean.result;
            if (result.size()==0){
                recordLinearLayout.setVisibility(View.VISIBLE);
                return;
            }else {
                CircleAdapter circleAdapter=new CircleAdapter(result);
                circleListView.setLayoutManager(new LinearLayoutManager(getContext()));
                circleListView.setAdapter(circleAdapter);
                circleAdapter.setAreaView(new CircleAdapter.AreaView() {
                    @Override
                    public void onCurress(int id) {

                    }

                    @Override
                    public void onCurre(int id) {
                    fpresenter.onSickCollection(map,id);

                    }
                });
            }
        }else {
            ToastUtils.show(collectionListBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean= (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            fpresenter.onCollectionList(map, oap);

        }else {
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
