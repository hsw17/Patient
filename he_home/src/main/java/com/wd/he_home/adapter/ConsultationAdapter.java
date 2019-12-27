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
 * data: 2019/12/19.
 * function：
 */
public class ConsultationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<EnquirySectionBean.ResultBean>list;

    public ConsultationAdapter(Context context, List<EnquirySectionBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.consultation_adapter, parent, false);
        return new ConsultationHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ConsultationHolder){
            ((ConsultationHolder) holder).consul_name.setText(list.get(position).getDepartmentName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ConsultationHolder extends RecyclerView.ViewHolder{

        private final TextView consul_name;

        public ConsultationHolder(@NonNull View itemView) {
            super(itemView);
            consul_name = itemView.findViewById(R.id.consul_name);
        }
    }
}
