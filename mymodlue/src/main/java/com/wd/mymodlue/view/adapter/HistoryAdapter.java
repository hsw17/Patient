package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
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
public class HistoryAdapter extends XRecyclerView.Adapter<HistoryAdapter.MovieViewHolder> {
    List<HistoryBean.ResultBean> result;

    private   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    public HistoryAdapter(List<HistoryBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_histry, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.simplImageView.setImageURI(result.get(i).imagePic);
        movieViewHolder.simplTextName.setText(result.get(i).doctorName);
        movieViewHolder.simplTextZhiwei.setText(result.get(i).jobTitle);
        String format = simpleDateFormat.format(result.get(i).inquiryTime);
        movieViewHolder.simplTextTime.setText(format);

    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.simpl_image_view)
        SimpleDraweeView simplImageView;
        @BindView(R2.id.simpl_text_name)
        TextView simplTextName;
        @BindView(R2.id.simpl_text_zhiwei)
        TextView simplTextZhiwei;
        @BindView(R2.id.linear_out)
        LinearLayout linearOut;
        @BindView(R2.id.simpl_text_yiyuang)
        TextView simplTextYiyuang;
        TextView simplTextTime;
        @BindView(R2.id.linear_two)
        LinearLayout linearTwo;

        Button simplButtonHistry;

        Button simplButtonEvaluate;
        @BindView(R2.id.linear_tre)
        LinearLayout linearTre;
        @BindView(R2.id.lin_list_tm)
        LinearLayout linListTm;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            simplTextTime=itemView.findViewById(R.id.simpl_text_time);
            simplButtonHistry=itemView.findViewById(R.id.simpl_button_histry);
            simplButtonEvaluate=itemView.findViewById(R.id.simpl_button_evaluate);
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
