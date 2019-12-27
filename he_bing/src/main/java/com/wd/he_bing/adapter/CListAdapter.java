package com.wd.he_bing.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.he_bing.R;
import com.wd.he_bing.bean.CListBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/19.
 * function：
 */
public class CListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CListBean.ResultBean>list;

    public CListAdapter(Context context, List<CListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.clist_adapter, parent, false);
        return new CListHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CListHolder){
            ((CListHolder) holder).tv.setText(list.get(position).getTitle());
            String s = String.valueOf(list.get(position).getReleaseTime());
            String format = DateFormatUtil.format(s);
            ((CListHolder) holder).time.setText(format);
            ((CListHolder) holder).common.setText(list.get(position).getDetail());
            ((CListHolder) holder).sick_circle_amount.setText(list.get(position).getAmount()+"");
            ((CListHolder) holder).item_shoucang.setText(list.get(position).getCollectionNum()+"");
            ((CListHolder) holder).item_jianyi.setText(list.get(position).getCommentNum()+"");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cListClick.setClistClick(list.get(position).getSickCircleId());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class DateFormatUtil{
        public static String format(String date){
            if (TextUtils.isEmpty(date))
                return null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");
            Long aLong = new Long(date);
            return simpleDateFormat.format(aLong);
        }
    }
    public class CListHolder extends RecyclerView.ViewHolder{
        private final TextView common,item_shoucang,sick_circle_amount;
        private final TextView tv,item_jianyi;
        private final TextView time;
        public CListHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.clist_circle_tv2);
            common = itemView.findViewById(R.id.clist_circle_common);
            sick_circle_amount = itemView.findViewById(R.id.clist_sick_circle_amount);
            time = itemView.findViewById(R.id.clist_circle_time);
            item_jianyi = itemView.findViewById(R.id.clist_item_jianyi);
            item_shoucang = itemView.findViewById(R.id.clist_item_shoucang);
        }
    }
    //跳转传值
    public CListClick cListClick;
    public void getCLick(CListClick cListClick){
        this.cListClick = cListClick;
    }
    public  interface CListClick{
        void setClistClick(String id);
    }
}
