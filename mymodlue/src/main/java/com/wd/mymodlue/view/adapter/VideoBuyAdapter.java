package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.dueeeke.videoplayer.listener.OnVideoViewStateChangeListener;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.VideoBuyBean;
import com.wd.mymodlue.modle.bean.VideoCollectBean;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

/**
 * date:2019/10/11
 * author:贺少伟(盗)
 * function:
 */
public class VideoBuyAdapter extends XRecyclerView.Adapter<VideoBuyAdapter.MovieViewHolder> {
    List<VideoBuyBean.ResultBean> result;


    public VideoBuyAdapter(List<VideoBuyBean.ResultBean> result) {
        this.result = result;
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_viedo, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.IjkView.setUrl(result.get(i).originalUrl);
        movieViewHolder.texttitle.setText(result.get(i).title);


        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd");
        String format1 = simpleDate.format(result.get(i).createTime);
        movieViewHolder.textDuanTime.setText(result.get(i).duration+":00");
        movieViewHolder.textTime.setText(format1);
        movieViewHolder.IjkView.setScreenScale(4);

        movieViewHolder.imageStart.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                movieViewHolder.IjkView.start();
                movieViewHolder.imageStart.setVisibility(View.GONE);
            }

            @Override
            protected void onFastClick() {

            }
        });
        movieViewHolder.IjkView.addOnVideoViewStateChangeListener(new OnVideoViewStateChangeListener() {
            @Override
            public void onPlayerStateChanged(int playerState) {
                movieViewHolder.IjkView.resume();

            }

            @Override
            public void onPlayStateChanged(int playState) {

            }
        });
        movieViewHolder.textDelete.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                areaView.onCurress(result.get(i).videoId);
            }

            @Override
            protected void onFastClick() {

            }
        });
        areaView.onCurre(movieViewHolder.IjkView);
        movieViewHolder.IjkView.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                movieViewHolder.IjkView.pause();
                movieViewHolder.imageStart.setVisibility(View.VISIBLE);

            }

            @Override
            protected void onFastClick() {

            }
        });

    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView imageStart;
        TextView textDuanTime;
        IjkVideoView IjkView;
        TextView textBuyNum;
        TextView textTime;
        TextView textDelete;
        TextView texttitle;
        RelativeLayout linerView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imageStart = itemView.findViewById(R.id.image_start);
            textDuanTime = itemView.findViewById(R.id.text_duan_time);
            IjkView = itemView.findViewById(R.id.Ijk_view);
            textBuyNum = itemView.findViewById(R.id.text_buyNum);
            textTime = itemView.findViewById(R.id.text_time);
            textDelete = itemView.findViewById(R.id.text_delete);
            linerView = itemView.findViewById(R.id.liner_view);
            texttitle = itemView.findViewById(R.id.text_title);
        }
    }

    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }

    AreaView areaView;

    public interface AreaView {
        void onCurress(int id);

        void onCurre(IjkVideoView IjkView);
    }
}
