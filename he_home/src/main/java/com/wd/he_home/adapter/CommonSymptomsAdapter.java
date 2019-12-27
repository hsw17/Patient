package com.wd.he_home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    private int oneon;

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
        if (holder instanceof commonsyHolder) {
            ((commonsyHolder) holder).commons_name.setText(resultBean.get(position).getDepartmentName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = resultBean.get(position).getId();

                    getClickItem.ClickItem(id, position + "");
                    notifyDataSetChanged();

                }
            });
            if (position == getmPosition()) {
                ((commonsyHolder) holder).commons_name.setBackgroundColor(Color.WHITE);
                ((commonsyHolder) holder).commons_linear.setBackgroundColor(context.getResources().getColor(R.color.blue));
            } else {
//            否则的话就全白色初始化背景
                ((commonsyHolder) holder).commons_name.setBackgroundColor(Color.parseColor("#D5D5D8"));
                ((commonsyHolder) holder).commons_linear.setBackgroundColor(context.getResources().getColor(R.color.gray));
            }
        }
    }

    @Override
    public int getItemCount() {
        return resultBean.size();
    }

    public class commonsyHolder extends RecyclerView.ViewHolder {
        private final TextView commons_name;
        private final LinearLayout commons_linear;

        public commonsyHolder(@NonNull View itemView) {
            super(itemView);
            commons_name = itemView.findViewById(R.id.commons_name);
            commons_linear = itemView.findViewById(R.id.commons_linear);
        }
    }

    public getClickItem getClickItem;

    public void onGetClickItem(getClickItem getClickItem) {
        this.getClickItem = getClickItem;
    }

    public interface getClickItem {

        void ClickItem(String id, String position);
    }

    private int mPosition;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }
}
