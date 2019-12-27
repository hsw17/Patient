package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/10/11
 * author:贺少伟(盗)
 * function:
 */
public class ImageAdapter extends XRecyclerView.Adapter<ImageAdapter.MovieViewHolder> {
    List<String> result;


    public ImageAdapter(List<String> result) {
        this.result = result;
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_image, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.simPlayImager.setImageURI(result.get(i));
    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simPlayImager;
        LinearLayout linerView;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            simPlayImager = itemView.findViewById(R.id.sim_play_imager);
            linerView = itemView.findViewById(R.id.liner_view);

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
