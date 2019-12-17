package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.UserTaskListBean;

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
public class TaskAdapter extends XRecyclerView.Adapter<TaskAdapter.MovieViewHolder> {
    List<UserTaskListBean.ResultBean> result;

    public TaskAdapter(List<UserTaskListBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_area, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {

               movieViewHolder.textName.setText(result.get(i).taskName);
               movieViewHolder.textHb.setText("+"+result.get(i).reward);
                if (result.get(i).whetherReceive==1){
                    movieViewHolder.collarButtonGoFinish.setVisibility(View.VISIBLE);
                    movieViewHolder.firstButtonFinish.setVisibility(View.GONE);
                    movieViewHolder.firstButtonGoFinish.setVisibility(View.GONE);
                }else if (result.get(i).whetherReceive==2){
                    movieViewHolder.firstButtonFinish.setVisibility(View.VISIBLE);
                    movieViewHolder.collarButtonGoFinish.setVisibility(View.GONE);
                    movieViewHolder.firstButtonGoFinish.setVisibility(View.GONE);
                }else if (result.get(i).whetherReceive==3){
                    movieViewHolder.firstButtonGoFinish.setVisibility(View.VISIBLE);
                    movieViewHolder.collarButtonGoFinish.setVisibility(View.GONE);
                    movieViewHolder.firstButtonFinish.setVisibility(View.GONE);
                }
        movieViewHolder.firstButtonGoFinish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                areaView.onCurress(result.get(i).id);
            }

            @Override
            protected void onFastClick() {

            }
        });
        movieViewHolder.collarButtonGoFinish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

            }

            @Override
            protected void onFastClick() {

            }
        });
        movieViewHolder.firstButtonFinish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

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

        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_hb)
        TextView textHb;
        @BindView(R.id.first_button_finish)
        Button firstButtonFinish;
        @BindView(R.id.first_button_go_finish)
        Button firstButtonGoFinish;
        @BindView(R.id.collar_button_go_finish)
        Button collarButtonGoFinish;
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
