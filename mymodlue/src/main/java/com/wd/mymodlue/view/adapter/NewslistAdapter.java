package com.wd.mymodlue.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.facebook.drawee.view.SimpleDraweeView;


import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.NewslistBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.http.Url;

/**
 * author: [Liu He]
 * data: 2019/12/15.
 * function：
 */
public class NewslistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewslistBean.ResultBean>resultBeans;
    private Context context;
    private   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    public NewslistAdapter(List<NewslistBean.ResultBean> resultBeans, Context context) {
        this.resultBeans = resultBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        String[] split = resultBeans.get(position).thumbnail.split(";");
        if (split.length == 1) {
            return 0;
        } else if (split.length == 3) {
            return 1;
        }
        return 2;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                View inflate = LayoutInflater.from(context).inflate(R.layout.newlist_one_layout, parent, false);
                return new Newlist_one_Holder(inflate);
            case 1:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.newlist_two_layout, parent, false);
                return new Newlist_two_Holder(inflate1);
            case 2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.newlist_three_layout, parent, false);
                return new Newlist_three_Holder(inflate2);
        }
        return  null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Date date = new Date(resultBeans.get(position).releaseTime);
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                ((Newlist_one_Holder) holder).text_name.setText(resultBeans.get(position).source);
                ((Newlist_one_Holder) holder).text_title.setText(resultBeans.get(position).title);
//                Glide.with(context).load(resultBeans.get(position).thumbnail).into(((Newlist_one_Holder) holder).simple);
                ((Newlist_one_Holder) holder).simple.setImageURI(resultBeans.get(position).thumbnail);
                simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                ((Newlist_one_Holder) holder).text_time.setText(simpleDateFormat.format(date));
                holder.itemView.setOnClickListener(new View.OnClickListener() {

                    private Intent intent;

                    @Override
                    public void onClick(View view) {
//                        intent = new Intent(context, FindInfoActivity.class);
//                        intent.putExtra("in_id", resultBeans.get(position).getId());
//                        context.startActivity(intent);
                    }
                });
                break;
            case 1:
                ((Newlist_two_Holder) holder).text_title.setText(resultBeans.get(position).title);
                ((Newlist_two_Holder) holder).text_name.setText(resultBeans.get(position).source);

                String[] split = resultBeans.get(position).thumbnail.split(";");
//                Glide.with(context).load(split[0]).into(((Newlist_two_Holder) holder).simple1);
//                Glide.with(context).load(split[1]).into(((Newlist_two_Holder) holder).simple2);
//                Glide.with(context).load(split[2]).into(((Newlist_two_Holder) holder).simple3);
                ((Newlist_two_Holder) holder).simple1.setImageURI(split[0]);
                ((Newlist_two_Holder) holder).simple2.setImageURI(split[1]);
                ((Newlist_two_Holder) holder).simple3.setImageURI(split[2]);
                ((Newlist_two_Holder) holder).text_time.setText(simpleDateFormat.format(date));
                holder.itemView.setOnClickListener(new View.OnClickListener() {

                    private Intent intent;

                    @Override
                    public void onClick(View view) {
//                        intent = new Intent(context, FindInfoActivity.class);
//                        intent.putExtra("in_id", resultBeans.get(position).getId());
//                        context.startActivity(intent);
                    }
                });
                break;
            case 2:
                ((Newlist_three_Holder) holder).text_name.setText(resultBeans.get(position).source);
                ((Newlist_three_Holder) holder).text_title.setText(resultBeans.get(position).title);
                simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                ((Newlist_three_Holder) holder).text_time.setText(simpleDateFormat.format(date));
                holder.itemView.setOnClickListener(new View.OnClickListener() {

                    private Intent intent;
                    @Override
                    public void onClick(View view) {
//                        intent = new Intent(context, FindInfoActivity.class);
//                        intent.putExtra("in_id", resultBeans.get(position).getId());
//                        context.startActivity(intent);
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
    public class Newlist_one_Holder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simple;
        private TextView text_title, text_name, text_time;
        public Newlist_one_Holder(@NonNull View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            text_title = itemView.findViewById(R.id.text_title);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
        }
    }
    public class Newlist_two_Holder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simple1, simple2, simple3;
        private TextView text_title, text_name, text_time;
        public Newlist_two_Holder(@NonNull View itemView) {
            super(itemView);
            text_time = itemView.findViewById(R.id.text_time);
            text_title = itemView.findViewById(R.id.text_title);
            text_name = itemView.findViewById(R.id.text_name);
            simple1 = itemView.findViewById(R.id.simple1);
            simple2 = itemView.findViewById(R.id.simple2);
            simple3 = itemView.findViewById(R.id.simple3);
        }
    }
    public class Newlist_three_Holder extends RecyclerView.ViewHolder{
        private TextView text_title, text_name, text_time;
        public Newlist_three_Holder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
        }
    }
    public onClickNew onClickNew;
    public void getOnClickNew(onClickNew onClickNew){
        this.onClickNew =onClickNew;
    }
    public interface onClickNew{
        void setOnClick(String inid);
    }
}
