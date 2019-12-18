package com.wd.he_home.util;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.he_home.R;
import com.wd.he_home.bean.HomeSearchBean;

import java.util.List;


public class DiseaseSearchVoListAdapter extends BaseQuickAdapter<HomeSearchBean.ResultBean.DiseaseSearchVoListBean, BaseViewHolder> {


    public DiseaseSearchVoListAdapter(int layoutResId,  List<HomeSearchBean.ResultBean.DiseaseSearchVoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeSearchBean.ResultBean.DiseaseSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name, item.getDiseaseName());
    }


}
