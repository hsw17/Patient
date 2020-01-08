package com.bw.inquerymodel.view.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.bw.inquerymodel.R;
import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.EndInquiryBean;

import com.bw.inquerymodel.bean.ResultBean;
import com.bw.inquerymodel.contract.DocTorContract;
import com.bw.inquerymodel.presenter.IPresenter;
import com.bw.inquerymodel.view.adapter.DocTorRecycleAdapter;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.Logger;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Route(path = "/inquerymodel/activity")
public class InqueryMainActivity extends BaseActivity<IPresenter> implements DocTorContract.IMainView {

    private String TAG = "InqueryMainActivity";
    private TabLayout dtablayout;
    private TabLayout tablouy;
    private int doctorId;
    private int condition = 1;
    private int sortBy;
    private Map<String, Object> queryMap;
    private List<DoctorListBean.ResultBean> doctorListresult;
    private List<DepartmentBean.ResultBean> result;
    private SimpleDraweeView doctor_simple;
    private TextView docname;
    private TextView address;
    private TextView zhiwei;
    private TextView haoping;
    private TextView huanmber;
    private Button zixun;
    private Boolean flag = false;
    private RecyclerView doctor_recycle;
    private TextView servciePrcie;
    private Map<String, Object> headerMap;
    private int doctorIds;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main_inqure;
    }

    @Override
    protected IPresenter setPresenter() {
        return new IPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        presenter.department ();
    }

    @Override
    protected void initView() {
        super.initView ();
        dtablayout = findViewById ( R.id.dtablayout );
        tablouy = findViewById ( R.id.tablouy );
        doctor_simple = findViewById ( R.id.doctor_simple );
        docname = findViewById ( R.id.docname );
        address = findViewById ( R.id.address );
        zhiwei = findViewById ( R.id.zhiwei );
        haoping = findViewById ( R.id.haoping );
        huanmber = findViewById ( R.id.huanmber );
        zixun = findViewById ( R.id.zixun );
        doctor_recycle = findViewById ( R.id.doctor_recycle );
        servciePrcie = findViewById ( R.id.servciePrcie );

        zixun.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                 getMapC (  );
                Toast.makeText ( InqueryMainActivity.this, "1", Toast.LENGTH_SHORT ).show ();
            }
        } );

        for (int i = 0; i < 4; i++) {
            tablouy.addTab ( tablouy.newTab () );
        }

        tablouy.getTabAt ( 0 ).setText ( "综合" );
        tablouy.getTabAt ( 1 ).setText ( "好评" );
        tablouy.getTabAt ( 2 ).setText ( "咨询数" );
        tablouy.getTabAt ( 3 ).setText ( "价格" );


        dtablayout.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition ();
                doctorIds = result.get ( position ).getId ();
                getMapB ( doctorIds,1,1 );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition ();
                doctorIds = result.get ( position ).getId ();
                getMapB ( doctorIds,1,1 );
            }
        } );

        tablouy.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition ();
                if (position < 3){
                    getMapB ( doctorIds,position+1,1 );
                    flag = true;
                }else if (position == 3 && flag == true){
                    sortBy = 1;
                    getMapB ( doctorIds,position+1,sortBy );
                    flag = false;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition ();
                if (position < 3 && flag == false){
                    getMapB ( doctorIds,position+1,1 );
                    flag = true;
                }else if (position == 3 && flag == true){
                    sortBy = 1;
                    getMapB ( doctorIds,position+1,sortBy );
                    flag = false;
                }
            }
        } );

        doctor_simple.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( InqueryMainActivity.this, InqueryActivity.class );
                intent.putExtra ( "doctorId",String.valueOf ( doctorId ) );
                startActivity ( intent );
            }
        } );


    }

    //医生列表
    @Override
    public void success(DoctorListBean doctorList) {
        doctorListresult = doctorList.getResult ();
        if (doctorListresult.size ()>0){
            doctorId = doctorListresult.get ( 0 ).getDoctorId ();
            String imagePic = doctorListresult.get ( 0 ).getImagePic ();
            String doctorName = doctorListresult.get ( 0 ).getDoctorName ();
            String jobTitle = doctorListresult.get ( 0 ).getJobTitle ();
            String inauguralHospital = doctorListresult.get ( 0 ).getInauguralHospital ();
            String praise = doctorListresult.get ( 0 ).getPraise ();
            int serverNum = doctorListresult.get ( 0 ).getServerNum ();
            int servicePrices = doctorListresult.get ( 0 ).getServicePrice ();
            servciePrcie.setText ( servicePrices+"H币/1次" );

            doctor_simple.setImageURI ( imagePic );
            docname.setText ( doctorName );
            zhiwei.setText ( jobTitle );
            address.setText ( inauguralHospital );
            haoping.setText ("好评率 "+ praise );
            huanmber.setText ( "服务人数 "+ serverNum );

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false );
            doctor_recycle.setLayoutManager ( linearLayoutManager );
            DocTorRecycleAdapter docTorRecycleAdapter = new DocTorRecycleAdapter ( this, doctorListresult );
            doctor_recycle.setAdapter ( docTorRecycleAdapter );

            docTorRecycleAdapter.setDoctorSimple ( new DocTorRecycleAdapter.DoctorSimple () {
                @Override
                public void setsimple(String simple, String doctorName, String jobTitle, String inauguralHospital, String praise, String serverNum,int dictroIds,int servicePrice) {
                    doctor_simple.setImageURI ( simple );
                    docname.setText ( doctorName );
                    zhiwei.setText ( jobTitle );
                    address.setText ( inauguralHospital );
                    haoping.setText ("好评率 "+ praise );
                    huanmber.setText ( "服务人数 "+ serverNum );
                    servciePrcie.setText ( servicePrice+"H币/1次" );
                    doctorId = dictroIds;
                }
            } );
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false );
            doctor_recycle.setLayoutManager ( linearLayoutManager );
            DocTorRecycleAdapter docTorRecycleAdapter = new DocTorRecycleAdapter ( this, doctorListresult );
            doctor_recycle.setAdapter ( docTorRecycleAdapter );
            Toast.makeText ( this, "暂无数据", Toast.LENGTH_SHORT ).show ();
        }

    }

    //科室列表
    @Override
    public void success(DepartmentBean departmentBean) {
        result = departmentBean.getResult ();
        doctorIds = result.get ( 0 ).getId ();
        getMapB ( doctorIds,condition,1 );

        for (int i = 0; i < result.size (); i++) {
            dtablayout.addTab ( dtablayout.newTab () );
        }

        for (int i = 0; i < result.size () ; i++) {
            dtablayout.getTabAt ( i ).setText ( result.get ( i ).getDepartmentName () );
        }
    }

    //查询当前问诊
    @Override
    public void success(CurrentBean currentBean) {
        String message = currentBean.getMessage ();
        if (message.equals ( "当前无问诊" )){
            AlertDialog.Builder builder = new AlertDialog.Builder ( this );
            View view = LinearLayout.inflate ( this, R.layout.alter_b_layout, null );
            TextView quxiao = view.findViewById ( R.id.quxiaob );
            TextView tozixun = view.findViewById ( R.id.tozixun );
            builder.setView ( view );

            AlertDialog alertDialog = builder.create ();
            alertDialog.show ();

            quxiao.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.cancel ();
                }
            } );
            tozixun.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.cancel ();
                    getMapD ();
                }
            } );
        }else if (message.equals ( "查询成功" )){
            AlertDialog.Builder builder = new AlertDialog.Builder ( this );
            View view = LinearLayout.inflate ( this, R.layout.alter_layout, null );
            TextView quxiao = view.findViewById ( R.id.quxiao );
            TextView tojies = view.findViewById ( R.id.tojies );
            builder.setView ( view );

            int recordId = currentBean.getResult ().getRecordId ();

            AlertDialog alertDialog = builder.create ();
            alertDialog.show ();

            quxiao.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss ();
                }
            } );
            tojies.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss ();
                    getMapE ( recordId );

                }
            } );
        }
    }

    //咨询医生
    @Override
    public void success(ResultBean resultBean) {
        String message = resultBean.getMessage ();
        if (message.equals ( "H币不足" )){
            AlertDialog.Builder builder = new AlertDialog.Builder ( this );
            View view = LinearLayout.inflate ( this, R.layout.alter_c_ayout, null );
            TextView quxiaoc = view.findViewById ( R.id.quxiaoc );
            TextView tochongz = view.findViewById ( R.id.tochongz );
            builder.setView ( view );

            AlertDialog alertDialog = builder.create ();
            alertDialog.show ();

            quxiaoc.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss ();
                }
            } );

            tochongz.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss ();
                }
            } );
        }else if (message.equals ( "当前医生服务数已达到上限" )){
            AlertDialog.Builder builder = new AlertDialog.Builder ( this );
            View view = LinearLayout.inflate ( this, R.layout.alter_a_layout, null );
            TextView queding = view.findViewById ( R.id.queding );
            builder.setView ( view );

            AlertDialog alertDialog = builder.create ();
            alertDialog.show ();

            queding.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss ();
                }
            } );
        }else {
            String doctorUserName = resultBean.getDoctorUserName ();
            Intent intent = new Intent ( InqueryMainActivity.this, LiaoTActivity.class );
            intent.putExtra ( "doctorUserName",doctorUserName );
            intent.putExtra ( "doctorId",String.valueOf ( doctorId ) );
            startActivity ( intent );
        }
    }
   //结束咨询
    @Override
    public void success(EndInquiryBean endInquiryBean) {
        Toast.makeText ( this, endInquiryBean.getMessage (), Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void fuilerror(String e) {
        Logger.d ( TAG,e );
    }

    public void getMapB(int deptId,int condition,int sortBy ){
        queryMap = new HashMap<> (  );
        queryMap.put ( "deptId",deptId );
        queryMap.put ( "condition",condition );
        queryMap.put ( "sortBy",sortBy );
        queryMap.put ( "page",1 );
        queryMap.put ( "count",6 );

        presenter.doctorList ( queryMap );
    }

    public void getMapC( ){
        headerMap = new HashMap<> (  );
        headerMap.put ( "userId","434" );
        headerMap.put ( "sessionId","1577327626255434" );
        presenter.current ( headerMap );
    }
    public void getMapD(){
        headerMap = new HashMap<> (  );
        headerMap.put ( "userId","434" );
        headerMap.put ( "sessionId","1577327626255434" );

        presenter.result ( headerMap,doctorId);
    }

    public void getMapE(int recordId){
        headerMap = new HashMap<> (  );
        headerMap.put ( "userId","434" );
        headerMap.put ( "sessionId","1577327626255434" );

        presenter.endinquiry ( headerMap,recordId);
    }
}
