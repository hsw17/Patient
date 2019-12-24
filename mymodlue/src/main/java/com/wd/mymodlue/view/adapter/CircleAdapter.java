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
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.CollectionListBean;
import com.wd.mymodlue.modle.bean.HistoryBean;

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
public class CircleAdapter extends XRecyclerView.Adapter<CircleAdapter.MovieViewHolder> {
    List<CollectionListBean.ResultBean> result;

    public CircleAdapter(List<CollectionListBean.ResultBean> result) {
        this.result = result;
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_circle, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.textCriceName.setText(result.get(i).title);
        movieViewHolder.textCriceDisease.setText(result.get(i).disease);
        movieViewHolder.textCriceCollectionNum.setText("收藏   "+result.get(i).collectionNum);
        movieViewHolder.textCriceCommentNum.setText("建议   "+result.get(i).commentNum);
        String format = simpleDateFormat.format(result.get(i).createTime);
        movieViewHolder.textCriceTime.setText(format);
        movieViewHolder.linerview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                ImageView viewById = view.findViewById(R.id.text_crice_imag);
                viewById.setVisibility(View.VISIBLE);
            }
        });
        movieViewHolder.textCriceImag.setOnClickListener(new CustomClickListener() {
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
        ImageView textCriceImag;
        TextView textCriceName;
        TextView textCriceDisease;
        TextView textCriceCollectionNum;
        TextView textCriceCommentNum;
        TextView textCriceTime;
        LinearLayout linerview;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            textCriceImag = itemView.findViewById(R.id.text_crice_imag);
            textCriceName = itemView.findViewById(R.id.text_crice_name);
            textCriceDisease = itemView.findViewById(R.id.text_crice_disease);
            textCriceCollectionNum = itemView.findViewById(R.id.text_crice_collectionNum);
            textCriceCommentNum = itemView.findViewById(R.id.text_crice_commentNum);
            textCriceTime = itemView.findViewById(R.id.text_crice_time);
            linerview = itemView.findViewById(R.id.liner_view);
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
