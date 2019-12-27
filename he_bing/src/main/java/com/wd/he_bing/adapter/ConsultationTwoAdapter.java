package com.wd.he_bing.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.he_bing.R;
import com.wd.he_bing.bean.CDepartmentlistBean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/17 16:03
 * @change
 * @chang time
 * @class describe
 */
public class ConsultationTwoAdapter extends RecyclerView.Adapter<ConsultationTwoAdapter.Holder> {
    private List<CDepartmentlistBean.ResultBean> list;
    private Context context;
    private int  Oneon;
    public ConsultationTwoAdapter(List<CDepartmentlistBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.consultationtwo_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.consultationtwo_name.setText(list.get(position).getDepartmentName());

        if (Oneon==position){
            holder.consultationtwo_name.setTextColor(Color.BLUE);
        }else {
            holder.consultationtwo_name.setTextColor(Color.GRAY);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oneon=position;
                notifyDataSetChanged();
                setOnItemClickListen.setOnItemClik(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final TextView consultationtwo_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            consultationtwo_name = itemView.findViewById(R.id.consultationtwo_name);
        }
    }
    public interface SetOnItemClickListen{
        void setOnItemClik(int i);
    }
    private SetOnItemClickListen setOnItemClickListen;

    public void setSetOnItemClickListen(SetOnItemClickListen setOnItemClickListen) {
        this.setOnItemClickListen = setOnItemClickListen;
    }
}
