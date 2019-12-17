package com.bw.videomodule.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.videomodule.R;
import com.bw.videomodule.bean.VideolistBean;

import java.util.List;

public class TikTokAdapter extends RecyclerView.Adapter<TikTokAdapter.VideoHolder> {
    private List<VideolistBean.ResultBean> result;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";

//    private List<VideoBean> videos;
    private Context context;

//    public TikTokAdapter(List<VideoBean> videos, Context context) {
//        this.videos = videos;
//        this.context = context;
//    }


    public TikTokAdapter(List<VideolistBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate( R.layout.item_tik_tok, parent, false);
        return new VideoHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final VideoHolder holder, int position) {
        Glide.with(context)
                .load(path)
                .placeholder(android.R.color.white)
                .into(holder.thumb);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        private ImageView thumb;

        VideoHolder(View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.thumb);
        }
    }
}