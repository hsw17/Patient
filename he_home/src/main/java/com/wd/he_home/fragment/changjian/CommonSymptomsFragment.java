package com.wd.he_home.fragment.changjian;

/**
 * author: [Liu He]
 * data: 2019/12/16.
 * function：
 */

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwie.mvplibrary.base.BaseFragment;
import com.wd.he_home.R;
import com.wd.he_home.adapter.CommonSymptomsAdapter;
import com.wd.he_home.adapter.CorrespondingsymptomsAdapter;
import com.wd.he_home.bean.CorrespondingsymptomsBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.List;

import butterknife.OnClick;

/**
 * @describe(描述)：CommonSymptomsFragment //常见病症
 * @data（日期）: 2019/12/16
 * @time（时间）: 9:08
 * @author（作者）: Liuhe
 **/
public class CommonSymptomsFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {

    private RecyclerView commonsOneRecycler, commonsTwoRecycler;
    private CommonSymptomsAdapter commonSymptomsAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.commonsymptoms_layout;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        commonsOneRecycler = getActivity().findViewById(R.id.commons_one_recycler);
        commonsTwoRecycler = getActivity().findViewById(R.id.commons_two_recycler);
        //科室
        fpresenter.HomePresenterChaXunKeShi();
        fpresenter.HomePresenterDuiYingBingZheng("7");
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof EnquirySectionBean) {
            //常见病症选择科室
            EnquirySectionBean enquirySectionBean = (EnquirySectionBean) obj;
            List<EnquirySectionBean.ResultBean> result = enquirySectionBean.getResult();
            commonSymptomsAdapter = new CommonSymptomsAdapter(context(), result);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            commonsOneRecycler.setLayoutManager(linearLayoutManager);
            commonsOneRecycler.setAdapter(commonSymptomsAdapter);
            commonSymptomsAdapter.onGetClickItem(new CommonSymptomsAdapter.getClickItem() {
                @Override
                public void ClickItem(String id, String position) {
                    fpresenter.HomePresenterDuiYingBingZheng(id);
                    commonSymptomsAdapter.setmPosition(Integer.parseInt(position));
                    commonSymptomsAdapter.notifyDataSetChanged();
                }
            });
        } else if (obj instanceof CorrespondingsymptomsBean) {
            //根据科室查询对应的症状
            CorrespondingsymptomsBean correspondingsymptomsBean = (CorrespondingsymptomsBean) obj;
            List<CorrespondingsymptomsBean.ResultBean> result = correspondingsymptomsBean.getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            commonsTwoRecycler.setLayoutManager(gridLayoutManager);
            CorrespondingsymptomsAdapter correspondingsymptomsAdapter = new CorrespondingsymptomsAdapter(context(), result);
            commonsTwoRecycler.setAdapter(correspondingsymptomsAdapter);
        }
    }

    @Override
    public void HomeViewError(String e) {
    }


    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.commons_one_recycler) {
        } else if (id == R.id.commons_two_recycler) {
        }
    }
}