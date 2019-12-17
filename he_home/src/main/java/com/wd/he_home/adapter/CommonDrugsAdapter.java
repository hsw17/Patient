package com.wd.he_home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.he_home.R;
import com.wd.he_home.bean.DrugClassificationBean;

import java.util.List;

import butterknife.OnClick;

/**
 *@describe(描述)：CommonDrugsAdapter   药品分类
 *@data（日期）: 2019/12/16
 *@time（时间）: 13:34
 *@author（作者）: Liuhe
 **/
public class CommonDrugsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DrugClassificationBean.ResultBean>list;

    public CommonDrugsAdapter(Context context, List<DrugClassificationBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.drugclass_layout, parent, false);
        return new CommonDrugsHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommonDrugsHolder){
            ((CommonDrugsHolder) holder).drugclass_name.setText(list.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItem.getOnClickItem(list.get(position).getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class CommonDrugsHolder extends RecyclerView.ViewHolder{

        private final TextView drugclass_name;

        public CommonDrugsHolder(@NonNull View itemView) {
            super(itemView);
            drugclass_name = itemView.findViewById(R.id.drugclass_name);
        }
    }
    //接口回调
    public OnClickItem onClickItem;
    public void setOnClick(OnClickItem onClickItem){
        this.onClickItem =onClickItem;
    }
    public interface OnClickItem{
        void getOnClickItem(String drugsCategoryId);
    }
}
