package com.wd.mymodlue.view.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.bwie.mvplibrary.app.App;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.HealthinformationBean;
import com.wd.mymodlue.modle.bean.NewslistBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.NewslistAdapter;
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
public class ConsultFragment extends BaseFragment<Persenter> implements IViewContract.IView {


    RecyclerView reccyListView;
    LinearLayout recordlinearlayout;
    private Map<String, Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.item_fragment_consult;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    protected void initView() {
        super.initView();
        reccyListView = getActivity().findViewById(R.id.reccy_list_view);
        recordlinearlayout = getActivity().findViewById(R.id.record_linear_layout);
        ToastUtils.init(getContext());
        map = new HashMap<>();
        map.put("plateId",1);
        map.put("page",1);
        map.put("count",10);
        fpresenter.onjiankangzixun(map);
    }


    @Override
    public void onSuccess(Object obj) {
        NewslistBean newslistBean= (NewslistBean) obj;
        if ("0000".equals(newslistBean.status)) {
            ToastUtils.show(newslistBean.message);
            List<NewslistBean.ResultBean> result = newslistBean.result;
            if (result.size()==0){
                recordlinearlayout.setVisibility(View.VISIBLE);
                return;
            }else {
                NewslistAdapter newslistAdapter=new NewslistAdapter(result, App.sContent);
                reccyListView.setLayoutManager(new LinearLayoutManager(getContext()));
                reccyListView.setAdapter(newslistAdapter);
            }

        }else {
            ToastUtils.show(newslistBean.message);
        }

    }

    @Override
    public void onSuccessOne(Object one) {

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
