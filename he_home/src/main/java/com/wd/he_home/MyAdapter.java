package com.wd.he_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.he_home.bean.DoctorlistBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/20.
 * function：
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DoctorlistBean.ResultBean>list;

    public MyAdapter(Context context, List<DoctorlistBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            Glide.with(context).load(list.get(position).getImagePic()).into(((MyHolder)holder).img);
            ((MyHolder)holder).name.setText(list.get(position).getDoctorName());
            ((MyHolder)holder).rela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCLickListener.onclick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (list.size()<3){
            return list.size();
        }
        return 3;
    }
    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private RelativeLayout rela;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name_item);
            rela=itemView.findViewById(R.id.rela);
        }
    }
    OnCLickListener onCLickListener;

    public void setOnCLickListener(OnCLickListener onCLickListener) {
        this.onCLickListener = onCLickListener;
    }

    public interface OnCLickListener{
        void onclick(int position);
    }
}
