package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.UserDoctorFollowBean;

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
public class AttenttionAdapter extends XRecyclerView.Adapter<AttenttionAdapter.MovieViewHolder> {
    List<UserDoctorFollowBean.ResultBean> result;


    public AttenttionAdapter(List<UserDoctorFollowBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_attention, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.simplImageView.setImageURI(result.get(i).imagePic);
        movieViewHolder.simplTextName.setText(result.get(i).departmentName);
        movieViewHolder.simplTextZhiwei.setText(result.get(i).jobTitle);
        movieViewHolder.simplTextYiyuang.setText(result.get(i).inauguralHospital);
        movieViewHolder.simplTextHpl.setText("好评率     " + result.get(i).praiseNum + "%");
        movieViewHolder.simplTextHzl.setText("服务患者数     " + result.get(i).number);
        movieViewHolder.linListTm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                movieViewHolder.simplTextQuxiao.setVisibility(View.VISIBLE);
                return true;
            }
        });
        movieViewHolder.simplTextQuxiao.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                areaView.onCurress(i);
                movieViewHolder.simplTextQuxiao.setVisibility(View.GONE);
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
        @BindView(R.id.simpl_image_view)
        SimpleDraweeView simplImageView;
        @BindView(R.id.simpl_text_name)
        TextView simplTextName;
        @BindView(R.id.simpl_text_zhiwei)
        TextView simplTextZhiwei;
        @BindView(R.id.linear_out)
        LinearLayout linearOut;
        @BindView(R.id.simpl_text_yiyuang)
        TextView simplTextYiyuang;
        @BindView(R.id.linear_two)
        LinearLayout linearTwo;
        @BindView(R.id.simpl_text_hpl)
        TextView simplTextHpl;
        @BindView(R.id.simpl_text_hzl)
        TextView simplTextHzl;
        @BindView(R.id.linear_tre)
        LinearLayout linearTre;
        @BindView(R.id.simpl_text_quxiao)
        TextView simplTextQuxiao;
        @BindView(R.id.lin_list_tm)
        LinearLayout linListTm;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

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
