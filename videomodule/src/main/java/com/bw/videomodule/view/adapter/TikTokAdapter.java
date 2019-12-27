package com.bw.videomodule.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.videomodule.R;
import com.bw.videomodule.bean.VideolistBean;
import com.bw.videomodule.utils.TikTokController;
import com.dueeeke.videoplayer.listener.OnVideoViewStateChangeListener;
import com.dueeeke.videoplayer.player.IjkPlayer;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;

import java.util.List;

public class TikTokAdapter extends RecyclerView.Adapter<TikTokAdapter.VideoHolder> {
    private List<VideolistBean.ResultBean> result;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";
    private Context context;

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

        holder.ijkplayer.setUrl ( result.get ( position ).getShearUrl () );
        holder.ijkplayer.start ();
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        private final IjkVideoView ijkplayer;

        VideoHolder(View itemView) {
            super(itemView);
            ijkplayer = itemView.findViewById ( R.id.ijkplayer );
        }
    }
}