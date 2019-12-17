package com.wd.he_home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.he_home.R;
import com.wd.he_home.bean.DrugListBean;
import com.wd.he_home.view.DrugDetailsActivity;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/16.
 * function：
 */
public class DrugsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DrugListBean.ResultBean> resultBeans;

    public DrugsListAdapter(Context context, List<DrugListBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.drugslist_adapter, parent, false);
        return new DrugsListHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DrugsListHolder) {
            ((DrugsListHolder) holder).drugslist_name.setText(resultBeans.get(position).getName());
            Glide.with(context).load(resultBeans.get(position).getPicture()).into(((DrugsListHolder) holder).drugslist_image);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DrugDetailsActivity.class);
                    intent.putExtra("id",resultBeans.get(position).getId());
                    intent.putExtra("name",resultBeans.get(position).getName());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class DrugsListHolder extends RecyclerView.ViewHolder {

        private final ImageView drugslist_image;
        private final TextView drugslist_name;

        public DrugsListHolder(@NonNull View itemView) {
            super(itemView);
            drugslist_image = itemView.findViewById(R.id.drugslist_image);
            drugslist_name = itemView.findViewById(R.id.drugslist_name);
        }
    }
    public interface onDrugslistClick{
    }
}
