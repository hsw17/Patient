package com.wd.he_home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.he_home.R;
import com.wd.he_home.bean.CorrespondingsymptomsBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/16.
 * function：
 */
public class CorrespondingsymptomsAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<CorrespondingsymptomsBean.ResultBean> resultBeans;

    public CorrespondingsymptomsAdapter(Context context, List<CorrespondingsymptomsBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.commonsymptoms_adapter, parent, false);
        return new CorrespHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CorrespHolder) {
            ((CorrespHolder) holder).corresp_name.setText(resultBeans.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class CorrespHolder extends RecyclerView.ViewHolder {

        private TextView corresp_name;

        public CorrespHolder(@NonNull View itemView) {
            super(itemView);
            corresp_name = itemView.findViewById(R.id.commons_name);
        }
    }
}
