package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.wd.mymodlue.modle.bean.DeleteArchivesBean;
import com.wd.mymodlue.modle.bean.UserArchivesBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(com.wd.mymodlue.R2.id.record_linear_layout)
    LinearLayout recordLinearLayout;
    @BindView(com.wd.mymodlue.R2.id.record_button_add)
    Button recordButtonAdd;
    @BindView(com.wd.mymodlue.R2.id.my_archives_relat)
    RelativeLayout myArchivesRelat;

    View vvv;
    TextView textBingzheng;
    TextView textNeike;
    TextView textXiangqing;
    TextView textTiantan;
    TextView textRiqi;
    TextView textJingli;
    SimpleDraweeView infoImg;
    LinearLayout myArchivesLinear;
    Button buttonDelete;
    Button buttonBianji;
    RelativeLayout myarchiveslayout;
    private SPUtils login;
    private Map<String, Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.activity_record;
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
        vvv = findViewById(R.id.vvv);
        textBingzheng = findViewById(R.id.text_bingzheng);
        textNeike = findViewById(R.id.text_neike);
        textXiangqing = findViewById(R.id.text_xiangqing);
        textTiantan = findViewById(R.id.text_tiantan);
        textRiqi = findViewById(R.id.text_riqi);
        textJingli = findViewById(R.id.text_jingli);
        infoImg = findViewById(R.id.info_img);
        myArchivesLinear = findViewById(R.id.my_archives_linear);
        buttonDelete = findViewById(R.id.button_delete);
        buttonBianji = findViewById(R.id.button_bianji);
        myarchiveslayout = findViewById(R.id.my_archives_layout);
        ToastUtils.init(this);
//        获取存储内容
        login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        presenter.onGetarchives(map);
//        返回
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent(RecordActivity.this, My_ModuleMainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
//        添加
        recordButtonAdd.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent("com.hl.CompileActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        UserArchivesBean userArchivesBean = (UserArchivesBean) obj;
        if (userArchivesBean.result != null) {
            if ("0000".equals(userArchivesBean.status)) {
                UserArchivesBean.ResultBean result = userArchivesBean.result;
                if (result == null) {
                    recordLinearLayout.setVisibility(View.VISIBLE);
                    myarchiveslayout.setVisibility(View.GONE);
                    return;
                } else {
                    recordLinearLayout.setVisibility(View.GONE);
                    myarchiveslayout.setVisibility(View.VISIBLE);
                    textBingzheng.setText(result.diseaseMain);
                    textNeike.setText(result.diseaseNow);
                    textXiangqing.setText(result.diseaseBefore);
                    textTiantan.setText(result.treatmentHospitalRecent);
                    textJingli.setText(result.treatmentProcess);
                    Date date = new Date(result.treatmentStartTime);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = new Date(result.treatmentEndTime);
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    textRiqi.setText(simpleDateFormat.format(date) + "-" + simpleDateFormat1.format(date1));
                    infoImg.setImageURI(result.picture);
//                format = simpleDateFormat.format(date);
//                format1 = simpleDateFormat1.format(date1);
//                Glide.with(this)
//                        .load(result.getPicture())
//                        .placeholder(R.mipmap.none_comment)
//                        .into(infoImg);
//                删除
                    buttonDelete.setOnClickListener(new CustomClickListener() {
                        @Override
                        protected void onSingleClick() {
                            presenter.onGetdeleteUserArchives(map, result.id);
                        }

                        @Override
                        protected void onFastClick() {

                        }
                    });
//                编辑
                    buttonBianji.setOnClickListener(new CustomClickListener() {
                        @Override
                        protected void onSingleClick() {
                            Intent intent = new Intent("com.hl.UpdateUserArchivesActivity");
                            intent.putExtra("id", result.id);
                            intent.putExtra("diseaseMain", result.diseaseMain);
                            intent.putExtra("diseaseNow", result.diseaseNow);
                            intent.putExtra("diseaseBefore", result.diseaseBefore);
                            intent.putExtra("treatmentHospitalRecent", result.treatmentHospitalRecent);
                            intent.putExtra("treatmentProcess", result.treatmentProcess);
                            startActivityForResult(intent, 1000);
                        }

                        @Override
                        protected void onFastClick() {

                        }
                    });
                }

            } else {
                ToastUtils.show(userArchivesBean.message);
            }
        } else {
            recordLinearLayout.setVisibility(View.VISIBLE);
            myArchivesRelat.setVisibility(View.GONE);
        }
    }

    //回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 2000) {
            //接受回传的值
            textBingzheng.setText(data.getStringExtra("main"));
            textNeike.setText(data.getStringExtra("now"));
            textXiangqing.setText(data.getStringExtra("before"));
            textTiantan.setText(data.getStringExtra("recent"));
            textJingli.setText(data.getStringExtra("process"));
            String starttimes = data.getStringExtra("starttimes");
            String endtimes = data.getStringExtra("endtimes");
            textRiqi.setText(starttimes + "-" + endtimes);

        }

    }

    @Override
    public void onSuccessOne(Object one) {
        DeleteArchivesBean deleteArchivesBean = (DeleteArchivesBean) one;
        if ("0000".equals(deleteArchivesBean.getStatus())) {
            ToastUtils.show(deleteArchivesBean.getMessage());
            presenter.onGetarchives(map);
        } else {
            ToastUtils.show(deleteArchivesBean.getMessage());
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
