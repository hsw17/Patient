package com.bw.inquerymodel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.inquerymodel.R;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/20
 * @Description:
 */
public class DocTorRecycleAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<DoctorListBean.ResultBean> doctorListresult;

    public DocTorRecycleAdapter(Context context, List<DoctorListBean.ResultBean> doctorListresult) {
        this.context = context;
        this.doctorListresult = doctorListresult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.doctor_list_layout, parent, false );
        return new DViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
           if (holder instanceof DViewHolder){
               DViewHolder dViewHolder = (DViewHolder) holder;
               String imagePic = doctorListresult.get ( position ).getImagePic ();
               String doctorName = doctorListresult.get ( position ).getDoctorName ();

               dViewHolder.doc_simple.setImageURI ( imagePic );
               dViewHolder.dco_name.setText ( doctorName );

               holder.itemView.setOnClickListener ( new View.OnClickListener () {
                   @Override
                   public void onClick(View v) {
                       int doctorId = doctorListresult.get ( position ).getDoctorId ();
                       String imagePic = doctorListresult.get ( position ).getImagePic ();
                       String doctorName = doctorListresult.get ( position ).getDoctorName ();
                       String jobTitle = doctorListresult.get ( position ).getJobTitle ();
                       String inauguralHospital = doctorListresult.get ( position ).getInauguralHospital ();
                       String praise = doctorListresult.get ( position ).getPraise ();
                       int serverNum = doctorListresult.get ( position ).getServerNum ();
                       int servicePrice = doctorListresult.get ( position ).getServicePrice ();

                       doctorSimple.setsimple ( imagePic,doctorName,jobTitle,inauguralHospital,praise,String.valueOf ( serverNum ),doctorId,servicePrice );
                   }
               } );
           }
    }

    @Override
    public int getItemCount() {
        return doctorListresult.size ();
    }

    public class DViewHolder extends RecyclerView.ViewHolder{

        private final TextView dco_name;
        private final SimpleDraweeView doc_simple;

        public DViewHolder(@NonNull View itemView) {
            super ( itemView );
            dco_name = itemView.findViewById ( R.id.dco_name );
            doc_simple = itemView.findViewById ( R.id.doc_simple );
        }
    }


    private DoctorSimple doctorSimple;

    public void setDoctorSimple(DoctorSimple doctorSimple) {
        this.doctorSimple = doctorSimple;
    }

    public interface DoctorSimple{
        void setsimple(String simple,String doctorName,String jobTitle,String inauguralHospital,String praise,String serverNum,int doctroId
        ,int servicePrice);
    }
}
