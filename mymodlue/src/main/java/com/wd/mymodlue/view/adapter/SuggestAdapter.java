package com.wd.mymodlue.view.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.UserCommentListBean;

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
public class SuggestAdapter extends XRecyclerView.Adapter<SuggestAdapter.MovieViewHolder> {
    List<UserCommentListBean.ResultBean> result;



    public SuggestAdapter(List<UserCommentListBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_sugint, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.walletImageView.setImageURI(result.get(i).releaseUserHeadPic);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy.MM.dd");
        String format = simpleDateFormat.format(result.get(i).adoptTime);
        movieViewHolder.walletTextTime.setText("采纳时间"+format);
        movieViewHolder.walletTextTitle.setText(result.get(i).title);
        movieViewHolder.walletTextName.setText(result.get(i).releaseUserNickName);
        movieViewHolder.walletTextBing.setText("主要病症："+result.get(i).disease);
        movieViewHolder.walletTextJian.setText(result.get(i).content);
    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.wallet_image_view)
        SimpleDraweeView walletImageView;
        @BindView(R2.id.wallet_text_name)
        TextView walletTextName;
        @BindView(R2.id.wallet_text_title)
        TextView walletTextTitle;
        @BindView(R2.id.wallet_text_bing)
        TextView walletTextBing;
        @BindView(R2.id.wallet_text_time)
        TextView walletTextTime;
        @BindView(R2.id.wallet_text_jian)
        TextView walletTextJian;

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
