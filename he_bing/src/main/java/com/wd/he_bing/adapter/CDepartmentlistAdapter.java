package com.wd.he_bing.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wd.he_bing.R;
import com.wd.he_bing.bean.CDepartmentlistBean;
import java.util.List;
/**
 * @describe(描述)：CDepartmentlistAdapter 查询科室
 * @data（日期）: 2019/12/19
 * @time（时间）: 18:52
 * @author（作者）: Liuhe
 **/
public class CDepartmentlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CDepartmentlistBean.ResultBean> list;

    public CDepartmentlistAdapter(Context context, List<CDepartmentlistBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cdepart_adapter, parent, false);
        return new CDepartHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CDepartHolder) {
            ((CDepartHolder) holder).cdepatr_name.setText(list.get(position).getDepartmentName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = list.get(position).getId();
                    setOnClick.OnClick(id, position + "");
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CDepartHolder extends RecyclerView.ViewHolder {

        private final TextView cdepatr_name;
        private final LinearLayout cdepart_linear;

        public CDepartHolder(@NonNull View itemView) {
            super(itemView);
            cdepatr_name = itemView.findViewById(R.id.cdepatr_name);
            cdepart_linear = itemView.findViewById(R.id.cdepart_linear);

        }
    }

    public setOnClick setOnClick;

    public void getOnClick(setOnClick setOnClick) {
        this.setOnClick = setOnClick;
    }

    public interface setOnClick {
        void OnClick(String id, String position);
    }
    private int mPosition;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }
}
