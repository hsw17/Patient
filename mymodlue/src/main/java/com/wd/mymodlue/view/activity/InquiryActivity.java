package com.wd.mymodlue.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.CurrencyNoticeListBean;
import com.wd.mymodlue.modle.bean.CurrentInquiryRecordBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InquiryActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.record_imag_view)
    SimpleDraweeView recordImagView;
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.text_jobTitle)
    TextView textJobTitle;
    @BindView(R2.id.text_department)
    TextView textDepartment;
    @BindView(R2.id.text_long)
    TextView textLong;
    @BindView(R2.id.liner_message)
    LinearLayout linerMessage;
    @BindView(R2.id.text_view_jeixu)
    TextView textViewJeixu;
    @BindView(R2.id.text_view_finish)
    TextView textViewFinish;
    @BindView(R2.id.rela_view)
    RelativeLayout relaView;
    @BindView(R2.id.record_linear_layout)
    RelativeLayout recordLinearLayout;
    private Map<String, Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.activity_inquiry;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        ToastUtils.init(this);
//        获取存储内容
        SPUtils login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        presenter.onInquiryRecord(map);
//      返回
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        CurrentInquiryRecordBean currentInquiryRecordBean= (CurrentInquiryRecordBean) obj;
        if ("0000".equals(currentInquiryRecordBean.status)) {
            CurrentInquiryRecordBean.ResultBean result = currentInquiryRecordBean.result;
            if (result.equals(null)){
                relaView.setVisibility(View.GONE);
                recordLinearLayout.setVisibility(View.VISIBLE);
                return;
            }else {
                relaView.setVisibility(View.VISIBLE);
                recordLinearLayout.setVisibility(View.GONE);
                recordImagView.setImageURI(result.imagePic);
                textName.setText(result.doctorName);
                textJobTitle.setText(result.jobTitle);
                textDepartment.setText(result.department);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                        "yyyy.MM.dd HH:mm");
                String format = simpleDateFormat.format(result.inquiryTime);
                textLong.setText("阅读时间   "+format);
//               取消问诊
                textViewFinish.setOnClickListener(new CustomClickListener() {
                    @Override
                    protected void onSingleClick() {
                        presenter.onEndInquiry(map,result.recordId);
                    }

                    @Override
                    protected void onFastClick() {

                    }
                });
            }

        }else{
            ToastUtils.show(currentInquiryRecordBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean = (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            relaView.setVisibility(View.GONE);
            recordLinearLayout.setVisibility(View.VISIBLE);
        } else {
            ToastUtils.show(userBean.message);

        }
    }

    @Override
    public void onSuccessTwo(Object two) {

    }

    @Override
    public void onSuccessThree(Object three) {

    }

    @Override
    public void onSuccessFour(Object four) {

    }

    @Override
    public void onFail(String str) {

    }

}
