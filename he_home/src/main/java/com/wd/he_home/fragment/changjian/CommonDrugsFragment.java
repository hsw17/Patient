package com.wd.he_home.fragment.changjian;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwie.mvplibrary.base.BaseFragment;
import com.wd.he_home.R;
import com.wd.he_home.adapter.CommonDrugsAdapter;
import com.wd.he_home.adapter.CommonSymptomsAdapter;
import com.wd.he_home.adapter.DrugsListAdapter;
import com.wd.he_home.bean.DrugClassificationBean;
import com.wd.he_home.bean.DrugListBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.List;

/**
 * author: [Liu He]  //常见药品
 * data: 2019/12/16.
 * function：
 */
public class CommonDrugsFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {
    private RecyclerView commond_recycler, commond_recycler_one;
    private LinearLayout comm;
    private CommonDrugsAdapter commonDrugsAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.commondrugs_fragment;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        intent.getIntExtra("two", 1);
        comm = getActivity().findViewById(R.id.comm);
        commond_recycler = getActivity().findViewById(R.id.commond_recycler);
        commond_recycler_one = getActivity().findViewById(R.id.commond_recycler_one);
        fpresenter.HomePresenterYaoPinFenLei();
        fpresenter.HomePresenterYaoPinLieBiao("1", "1", "100");
    }
    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof DrugClassificationBean) {
            //药品分类
            DrugClassificationBean drugClassificationBean = (DrugClassificationBean) obj;
            List<DrugClassificationBean.ResultBean> result = drugClassificationBean.getResult();
            //这是线程管理
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            commond_recycler.setLayoutManager(linearLayoutManager);
            commonDrugsAdapter = new CommonDrugsAdapter(context(), result);
            commond_recycler.setAdapter(commonDrugsAdapter);
            //接口回调获取Id进行显示
            commonDrugsAdapter.setOnClick(new CommonDrugsAdapter.OnClickItem() {
                @Override
                public void getOnClickItem(String id, int position) {
                    Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
                    fpresenter.HomePresenterYaoPinLieBiao(id, "1", "100");
                    commonDrugsAdapter.setmPosition(position);
                    commonDrugsAdapter.notifyDataSetChanged();
                }
            });
        /*  commonDrugsAdapter.setOnClick(new CommonDrugsAdapter.OnClickItem() {
              @Override
              public void getOnClickItem(String id) {
                  fpresenter.HomePresenterYaoPinLieBiao("1", "1", "100");
                  commonDrugsAdapter.notifyDataSetChanged();
              }
          });*/
        } else if (obj instanceof DrugListBean) {
            //药品列表
            DrugListBean drugListBean = (DrugListBean) obj;
            List<DrugListBean.ResultBean> result = drugListBean.getResult();
            //线程管理
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context(), 3);
            commond_recycler_one.setLayoutManager(gridLayoutManager);
            //设置适配器
            DrugsListAdapter drugsListAdapter = new DrugsListAdapter(context(), result);
            commond_recycler_one.setAdapter(drugsListAdapter);
        }
    }

    @Override
    public void HomeViewError(String e) {

    }
}
