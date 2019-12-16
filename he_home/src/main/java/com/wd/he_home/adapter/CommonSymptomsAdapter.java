package com.wd.he_home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.he_home.R;
import com.wd.he_home.bean.EnquirySectionBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/16.
 * function：
 */
public class CommonSymptomsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<EnquirySectionBean.ResultBean> resultBean;

    public CommonSymptomsAdapter(Context context, List<EnquirySectionBean.ResultBean> resultBean) {
        this.context = context;
        this.resultBean = resultBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.commonsymptoms_adapter, parent, false);
        return new commonsyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof commonsyHolder){
            ((commonsyHolder) holder).commons_name.setText(resultBean.get(position).getDepartmentName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = resultBean.get(position).getId();
                    getClickItem.ClickItem(id);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return resultBean.size();
    }
    public class commonsyHolder extends RecyclerView.ViewHolder{

        private final TextView commons_name;

        public commonsyHolder(@NonNull View itemView) {
            super(itemView);
            commons_name = itemView.findViewById(R.id.commons_name);
        }
    }
    public  getClickItem getClickItem;
    public void onGetClickItem(getClickItem getClickItem){
        this.getClickItem = getClickItem;
    }
    public interface  getClickItem{
        void ClickItem(String departmentId);
    }
}
