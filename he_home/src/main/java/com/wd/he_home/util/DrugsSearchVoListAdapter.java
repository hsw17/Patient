package com.wd.he_home.util;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.he_home.R;
import com.wd.he_home.bean.HomeSearchBean;

import java.util.List;


public class DrugsSearchVoListAdapter extends BaseQuickAdapter<HomeSearchBean.ResultBean.DrugsSearchVoListBean, BaseViewHolder> {


    public DrugsSearchVoListAdapter(int layoutResId,  List<HomeSearchBean.ResultBean.DrugsSearchVoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeSearchBean.ResultBean.DrugsSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name, item.getDrugsName());

    }
}
