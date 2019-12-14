package com.wd.he_home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.he_home.R;
import com.wd.he_home.bean.EnquirySectionBean;

import java.util.List;
/**
 *@describe(描述)：EnquirySectionAdapter
 *@data（日期）: 2019/12/14
 *@time（时间）: 8:15
 *@author（作者）: Liuhe
 **/
public class EnquirySectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<EnquirySectionBean.ResultBean> resultBean;

    public EnquirySectionAdapter(Context context, List<EnquirySectionBean.ResultBean> resultBean) {
        this.context = context;
        this.resultBean = resultBean;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.enquiry_layout, parent, false);
        return new EnquirySectionHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EnquirySectionHolder) {
            ((EnquirySectionHolder) holder).item_dep_name.setText(resultBean.get(position).getDepartmentName());
            Glide.with(context).load(resultBean.get(position).getPic()).into(((EnquirySectionHolder) holder).item_dep_img);
        }
    }

    @Override
    public int getItemCount() {
        return resultBean.size();
    }

    public class EnquirySectionHolder extends RecyclerView.ViewHolder {

        private final ImageView item_dep_img;
        private final TextView item_dep_name;

        public EnquirySectionHolder(@NonNull View itemView) {
            super(itemView);
            item_dep_img = itemView.findViewById(R.id.item_dep_img);
            item_dep_name = itemView.findViewById(R.id.item_dep_name);
        }
    }
}
