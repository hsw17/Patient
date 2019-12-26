package com.bw.inquerymodel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.inquerymodel.R;
import com.bw.inquerymodel.bean.RecordListBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import retrofit2.http.HeaderMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/26
 * @Description:
 */
public class RecirdListRecycleAdapter extends XRecyclerView.Adapter {
    private List<RecordListBean.ResultBean> result;
    private Context context;

    public RecirdListRecycleAdapter(List<RecordListBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = LayoutInflater.from ( context ).inflate ( R.layout.record_a_layout, parent, false );
            return new RAViewHolder ( view );
        }else if (viewType == 2){
            View view = LayoutInflater.from ( context ).inflate ( R.layout.record_a_layout, parent, false );
            return new RBViewHolder ( view );
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType ( position );
        if (itemViewType == 1){
            if (holder instanceof RAViewHolder){
                RAViewHolder raViewHolder = (RAViewHolder) holder;
                String userHeadPic = result.get ( position ).getUserHeadPic ();
                String content = result.get ( position ).getContent ();
                long askTime = result.get ( position ).getAskTime ();

                raViewHolder.user_simplea.setImageURI ( userHeadPic );
                raViewHolder.user_contenta.setText ( content );
            }
        }else if (itemViewType==2){
            if (holder instanceof RBViewHolder){
                RBViewHolder rbViewHolder = (RBViewHolder) holder;
                String userHeadPic = result.get ( position ).getUserHeadPic ();
                String content = result.get ( position ).getContent ();
                long askTime = result.get ( position ).getAskTime ();

                rbViewHolder.user_simpleb.setImageURI ( userHeadPic );
                rbViewHolder.user_contentb.setText ( content );

            }
        }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    @Override
    public int getItemViewType(int position) {
        int msgType = result.get ( position ).getMsgType ();
        if (msgType == 1){
            return 1;
        }else if (msgType==2){
            return 2;
        }
        return super.getItemViewType ( position );
    }

    public class RAViewHolder extends XRecyclerView.ViewHolder {

        private final TextView time_a;
        private final SimpleDraweeView user_simplea;
        private final TextView user_contenta;

        public RAViewHolder(@NonNull View itemView) {
            super ( itemView );
            time_a = itemView.findViewById ( R.id.time_A );
            user_simplea = itemView.findViewById ( R.id.user_simplea );
            user_contenta = itemView.findViewById ( R.id.user_contenta );
        }
    }
    public class RBViewHolder extends XRecyclerView.ViewHolder {

        private final TextView time_b;
        private final SimpleDraweeView user_simpleb;
        private final TextView user_contentb;

        public RBViewHolder(@NonNull View itemView) {
            super ( itemView );
            time_b = itemView.findViewById ( R.id.time_B );
            user_simpleb = itemView.findViewById ( R.id.user_simpleb );
            user_contentb = itemView.findViewById ( R.id.user_contentb );
        }
    }
}
