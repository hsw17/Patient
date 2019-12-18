package com.wd.he_home.util;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.he_home.R;
import com.wd.he_home.bean.HomeSearchBean;

import java.util.List;



public class DoctorSearchVoListAdapter extends BaseQuickAdapter<HomeSearchBean.ResultBean.DoctorSearchVoListBean, BaseViewHolder> {


    public DoctorSearchVoListAdapter(int layoutResId,  List<HomeSearchBean.ResultBean.DoctorSearchVoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeSearchBean.ResultBean.DoctorSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name, item.getDoctorName());
    }
}
