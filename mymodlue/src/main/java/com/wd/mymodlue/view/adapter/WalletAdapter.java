package com.wd.mymodlue.view.adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.UserConsumptionRecordListBean;

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
public class WalletAdapter extends XRecyclerView.Adapter<WalletAdapter.MovieViewHolder> {
    List<UserConsumptionRecordListBean.ResultBean> result;
    @BindView(R2.id.walle_text_name)
    TextView walleTextName;
    @BindView(R2.id.walle_text_time)
    TextView walleTextTime;
    @BindView(R2.id.walle_text_manay)
    TextView walleTextManay;


    public WalletAdapter(List<UserConsumptionRecordListBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_wallot, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        movieViewHolder.walleTextName.setText(result.get(i).remark);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(result.get(i).createTime);
        movieViewHolder.walleTextTime.setText(format);
        if (result.get(i).direction==1){
            movieViewHolder.walleTextManay.setTextColor(Color.RED);
            movieViewHolder.walleTextManay.setText("+"+result.get(i).changeNum+"H币");
        }else if (result.get(i).direction==2){
            movieViewHolder.walleTextManay.setTextColor(Color.BLUE);
            movieViewHolder.walleTextManay.setText("+"+result.get(i).changeNum+"H币");
        }

    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.walle_text_name)
        TextView walleTextName;
        @BindView(R2.id.walle_text_time)
        TextView walleTextTime;
        @BindView(R2.id.walle_text_manay)
        TextView walleTextManay;

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
