package com.bw.inquerymodel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.inquerymodel.R;
import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/22
 * @Description:
 */
public class DoctroEvalutaeAdapter extends XRecyclerView.Adapter {
    private Context context;
    private List<DoctroinfoBean.ResultBean.CommentListBean> commentList;

    public DoctroEvalutaeAdapter(Context context, List<DoctroinfoBean.ResultBean.CommentListBean> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.evaluate_layout, parent, false );
        return new MViewHodler ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MViewHodler){
            MViewHodler mViewHodler = (MViewHodler) holder;
            String headPic = commentList.get ( position ).getHeadPic ();
            String nickName = commentList.get ( position ).getNickName ();
            long commentTime = commentList.get ( position ).getCommentTime ();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("HH");
            String format = simpleDateFormat.format ( commentTime );
            String content = commentList.get ( position ).getContent ();

            mViewHodler.user_image.setImageURI ( headPic );
            mViewHodler.user_name.setText ( nickName );
            mViewHodler.user_time.setText ( format+"小时前" );
            mViewHodler.user_context.setText ( content );
        }
    }

    @Override
    public int getItemCount() {
        return commentList.size ()==0 ? 0:commentList.size () ;
    }

    public class MViewHodler extends XRecyclerView.ViewHolder{

        private final SimpleDraweeView user_image;
        private final TextView user_name;
        private final TextView user_time;
        private final TextView user_context;

        public MViewHodler(@NonNull View itemView) {
            super ( itemView );
            user_image = itemView.findViewById ( R.id.user_image );
            user_name = itemView.findViewById ( R.id.user_name );
            user_time = itemView.findViewById ( R.id.user_time );
            user_context = itemView.findViewById ( R.id.user_context );
        }
    }
}
