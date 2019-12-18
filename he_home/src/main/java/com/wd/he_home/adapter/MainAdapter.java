package com.wd.he_home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.wd.he_home.R;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.EnquirySectionBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/17.
 * function：
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BannerBean.ResultBean> beans;
    private List<EnquirySectionBean.ResultBean> resultBeans;
    private int itemViewType;
    private GridLayoutManager gridLayoutManager;

    public MainAdapter(Context context, List<BannerBean.ResultBean> beans, List<EnquirySectionBean.ResultBean> resultBeans) {
        this.context = context;
        this.beans = beans;
        this.resultBeans = resultBeans;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        }else if (position==1){
            return 1;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View inflate = LayoutInflater.from(context).inflate(R.layout.main_xbanner_layout, parent, false);
                return new oneMainHolder(inflate);
         /*   case 1:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.main_chang_layout, parent, false);
                return new twoMainHolder(inflate1);*/
            case 1:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.main_keshi_layout, parent, false);
                return new ThreeMainHolder(inflate2);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                if (holder instanceof oneMainHolder){
                    ((oneMainHolder) holder).main_xbanner_top.setData(beans,null);
                    ((oneMainHolder) holder).main_xbanner_top.setmAdapter(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, Object model, View view, int position) {
                            Glide.with(context).load(beans.get(position).getImageUrl());
                        }
                    });
                }
                break;
            case 1:
                if (holder instanceof ThreeMainHolder){
                    gridLayoutManager = new GridLayoutManager(context, 4);
                    ((ThreeMainHolder) holder).main_recycler.setLayoutManager(gridLayoutManager);
                    EnquirySectionAdapter enquirySectionAdapter = new EnquirySectionAdapter(context, resultBeans);
                    ((ThreeMainHolder) holder).main_recycler.setAdapter(enquirySectionAdapter);
                }
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    //xbanner
    public class oneMainHolder extends RecyclerView.ViewHolder {

        private final XBanner main_xbanner_top;

        public oneMainHolder(@NonNull View itemView) {
            super(itemView);
            main_xbanner_top = itemView.findViewById(R.id.main_xbanner_top);

        }
    }

/*    //常见症状
    public class twoMainHolder extends RecyclerView.ViewHolder {

        private final ImageView main_disease_img, main_drugs_img;

        public twoMainHolder(@NonNull View itemView) {
            super(itemView);
            main_disease_img = itemView.findViewById(R.id.main_disease_img);
            main_drugs_img = itemView.findViewById(R.id.main_drugs_img);


        }
    }*/

    //查询科室
    public class ThreeMainHolder extends RecyclerView.ViewHolder {

        private final RecyclerView main_recycler;

        public ThreeMainHolder(@NonNull View itemView) {
            super(itemView);
            main_recycler = itemView.findViewById(R.id.main_recycler);

        }
    }
}
