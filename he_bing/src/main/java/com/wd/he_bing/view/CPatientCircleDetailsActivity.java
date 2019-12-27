package com.wd.he_bing.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_bing.R;
import com.wd.he_bing.R2;
import com.wd.he_bing.bean.CPatientCircleDetailsBean;
import com.wd.he_bing.contract.CHomeContract;
import com.wd.he_bing.presenter.CHomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CPatientCircleDetailsActivity extends BaseActivity<CHomePresenter> implements CHomeContract.CHomeView {


    @BindView(R2.id.c_patient_iv_user_head_pic)
    ImageView cPatientIvUserHeadPic;
    @BindView(R2.id.c_patient_activity_tv_title)
    TextView cPatientActivityTvTitle;
    @BindView(R2.id.c_patient_iv_user_message)
    ImageView cPatientIvUserMessage;
    @BindView(R2.id.c_patient_relative_titlebar)
    RelativeLayout cPatientRelativeTitlebar;
    @BindView(R2.id.c_patient_activity_tv_adoptNickName)
    TextView cPatientActivityTvAdoptNickName;
    @BindView(R2.id.c_patient_activity_tv_disease)
    TextView cPatientActivityTvDisease;
    @BindView(R2.id.c_patient_activity_tv_department)
    TextView cPatientActivityTvDepartment;
    @BindView(R2.id.c_patient_activity_tv_detail)
    TextView cPatientActivityTvDetail;
    @BindView(R2.id.c_patient_activity_tv_treatment_time)
    TextView cPatientActivityTvTreatmentTime;
    @BindView(R2.id.c_patient_activity_tv_treatmentProcess)
    TextView cPatientActivityTvTreatmentProcess;
    @BindView(R2.id.c_patient_activity_iv_picture)
    ImageView cPatientActivityIvPicture;
    @BindView(R2.id.c_patient_activity_tv_commentNum)
    TextView cPatientActivityTvCommentNum;
    @BindView(R2.id.c_patient_activity_iv_content)
    ImageView cPatientActivityIvContent;
    @BindView(R2.id.c_patient_activity_tv_collectionNum)
    TextView cPatientActivityTvCollectionNum;
    @BindView(R2.id.c_img_HeadPic)
    ImageView cImgHeadPic;
    @BindView(R2.id.c_name_NickName)
    TextView cNameNickName;
    @BindView(R2.id.c_time_adoptTime)
    TextView cTimeAdoptTime;
    @BindView(R2.id.c_text_adoptComment)
    TextView cTextAdoptComment;
    @BindView(R2.id.c_adoptFlag)
    LinearLayout cAdoptFlag;
    @BindView(R2.id.c_recycler_sick_circle_comment_list)
    RecyclerView cRecyclerSickCircleCommentList;
    @BindView(R2.id.c_patient_activity_iv_cancel)
    ImageView cPatientActivityIvCancel;
    @BindView(R2.id.c_patient_activity_et_content)
    EditText cPatientActivityEtContent;
    @BindView(R2.id.c_patient_activity_iv_send_content)
    ImageView cPatientActivityIvSendContent;
    @BindView(R2.id.c_patient_activity_relative_content)
    RelativeLayout cPatientActivityRelativeContent;
    @BindView(R2.id.c_patient_activity_iv_intent_release_sickCircle)
    ImageView cPatientActivityIvIntentReleaseSickCircle;
    @BindView(R2.id.c_patient_activity_relative_release_sickCircle)
    RelativeLayout cPatientActivityRelativeReleaseSickCircle;


    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_cpatient_circle_details;
    }

    @Override
    protected void initData() {
        super.initData();
        ButterKnife.bind(this);
        //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        presenter.CHomePresenterBingYouQuanXiangQing("432", "1577170010986432", id);

        cPatientActivityIvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  mPresenter.onCircleComment(sickCircleId, userId + "", sessionId, 15, 1);
                cPatientActivityIvContent.setVisibility(View.VISIBLE);
                cPatientActivityIvIntentReleaseSickCircle.setVisibility(View.GONE);
            }
        });

        cPatientActivityIvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cPatientActivityRelativeContent.setVisibility(View.GONE);
                cPatientActivityRelativeReleaseSickCircle.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(cPatientActivityEtContent.getWindowToken(), 0);
            }
        });

        cPatientActivityIvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // presenter.CHomePresenterFaBuBingYouQuan(sickCircleId, userId + "", sessionId, 15, 1);
                cPatientActivityRelativeContent.setVisibility(View.VISIBLE);
                cPatientActivityRelativeReleaseSickCircle.setVisibility(View.GONE);
            }
        });
        cPatientActivityIvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cPatientActivityRelativeContent.setVisibility(View.GONE);
                cPatientActivityIvIntentReleaseSickCircle.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(cPatientActivityEtContent.getWindowToken(), 0);
            }
        });
        //评论
        cPatientActivityIvSendContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String et_content = cPatientActivityEtContent.getText().toString().trim();
                if (TextUtils.isEmpty(et_content)) {
                    Toast.makeText(CPatientCircleDetailsActivity.this, "输入的内容不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
               // Log.i("TAG", "onClick: " + "sickCircleId:" + sickCircleId);
                //mPresenter.onComment(sickCircleId, userId + "", sessionId, et_content);
            }
        });
    }

    @Override
    protected CHomePresenter setPresenter() {
        return new CHomePresenter();
    }

    @Override
    public void CHomeViewSuccess(Object obj) {
        if (obj instanceof CPatientCircleDetailsBean) {
            CPatientCircleDetailsBean cPatientCircleDetailsBean = (CPatientCircleDetailsBean) obj;
            CPatientCircleDetailsBean.ResultBean result = cPatientCircleDetailsBean.getResult();
            cPatientActivityTvTitle.setText(result.getTitle() + "");
            cPatientActivityTvAdoptNickName.setText(result.getAdoptNickName() + "");
            cPatientActivityTvDisease.setText(result.getDisease() + "");
            cPatientActivityTvDepartment.setText(result.getDepartment() + "");
            cPatientActivityTvDetail.setText(result.getDetail() + "");
            cPatientActivityTvTreatmentProcess.setText(result.getTreatmentProcess() + "");
            long treatmentStartTime = result.getTreatmentStartTime();
            long treatmentEndTime = result.getTreatmentEndTime();
            // String endTimes = DateUtils.times(treatmentEndTime);
            //String startTimes = DateUtils.times(treatmentStartTime);
            //c_patient_activity_tv_treatment_time.setText(startTimes + "----" + endTimes);
            Glide.with(this).load(result.getPicture())
                    .placeholder(R.mipmap.none_comment)
                    .error(R.mipmap.none_comment)
                    .into(cPatientActivityIvPicture);
            cPatientActivityTvCollectionNum.setText(result.getCollectionNum() + "");
        }
    }

    @Override
    public void CHomeViewError(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @OnClick({R.id.c_patient_iv_user_head_pic, R.id.c_patient_activity_tv_title, R.id.c_patient_iv_user_message, R.id.c_patient_relative_titlebar, R.id.c_patient_activity_tv_adoptNickName, R.id.c_patient_activity_tv_disease, R.id.c_patient_activity_tv_department, R.id.c_patient_activity_tv_detail, R.id.c_patient_activity_tv_treatment_time, R.id.c_patient_activity_tv_treatmentProcess, R.id.c_patient_activity_iv_picture, R.id.c_patient_activity_tv_commentNum, R.id.c_patient_activity_iv_content, R.id.c_patient_activity_tv_collectionNum, R.id.c_img_HeadPic, R.id.c_name_NickName, R.id.c_time_adoptTime, R.id.c_text_adoptComment, R.id.c_adoptFlag, R.id.c_recycler_sick_circle_comment_list, R.id.c_patient_activity_iv_cancel, R.id.c_patient_activity_et_content, R.id.c_patient_activity_iv_send_content, R.id.c_patient_activity_relative_content, R.id.c_patient_activity_iv_intent_release_sickCircle, R.id.c_patient_activity_relative_release_sickCircle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.c_patient_iv_user_head_pic:
                break;
            case R.id.c_patient_activity_tv_title:
                break;
            case R.id.c_patient_iv_user_message:
                break;
            case R.id.c_patient_relative_titlebar:
                break;
            case R.id.c_patient_activity_tv_adoptNickName:
                break;
            case R.id.c_patient_activity_tv_disease:
                break;
            case R.id.c_patient_activity_tv_department:
                break;
            case R.id.c_patient_activity_tv_detail:
                break;
            case R.id.c_patient_activity_tv_treatment_time:
                break;
            case R.id.c_patient_activity_tv_treatmentProcess:
                break;
            case R.id.c_patient_activity_iv_picture:
                break;
            case R.id.c_patient_activity_tv_commentNum:
                break;
            //对话框点击
            case R.id.c_patient_activity_iv_content:

                break;
            case R.id.c_patient_activity_tv_collectionNum:
                break;
            case R.id.c_img_HeadPic:
                break;
            case R.id.c_name_NickName:
                break;
            case R.id.c_time_adoptTime:
                break;
            case R.id.c_text_adoptComment:
                break;
            case R.id.c_adoptFlag:
                break;
            case R.id.c_recycler_sick_circle_comment_list:
                break;
            //图标
            case R.id.c_patient_activity_iv_cancel:
                break;
            case R.id.c_patient_activity_et_content:
                break;
            case R.id.c_patient_activity_iv_send_content:
                break;
            case R.id.c_patient_activity_relative_content:
                break;
            case R.id.c_patient_activity_iv_intent_release_sickCircle:
                Intent intent1 = new Intent(CPatientCircleDetailsActivity.this, ReleaseCirclesActivity.class);
                startActivity(intent1);
                break;
            case R.id.c_patient_activity_relative_release_sickCircle:
                break;
        }
    }
}
