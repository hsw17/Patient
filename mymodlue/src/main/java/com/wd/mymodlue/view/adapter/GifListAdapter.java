package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.GIfListBean;

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
public class GifListAdapter extends XRecyclerView.Adapter<GifListAdapter.MovieViewHolder> {
    List<GIfListBean.ResultBean> result;

    public GifListAdapter(List<GIfListBean.ResultBean> result) {
        this.result = result;
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_giflist, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.sim_play_image.setImageURI(result.get(i).pic);
        movieViewHolder.text_name.setText(result.get(i).name);
        movieViewHolder.text_name.setText(result.get(i).worth+"H币");
        movieViewHolder.button_sead.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                areaView.onCurre(result.get(i).id);
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
        private SimpleDraweeView sim_play_image;
        private TextView text_name;
        private TextView text_hb;
        private Button button_sead;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            sim_play_image = itemView.findViewById(R.id.sim_play_image);
            text_name = itemView.findViewById(R.id.text_name);
            text_hb = itemView.findViewById(R.id.text_hb);
            button_sead = itemView.findViewById(R.id.button_sead);
        }
    }

    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }

    AreaView areaView;

    public interface AreaView {
        void onCurress(int id);

        void onCurre(int id);
    }
}
