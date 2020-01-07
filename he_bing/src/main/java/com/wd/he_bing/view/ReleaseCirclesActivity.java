package com.wd.he_bing.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_bing.R;
import com.wd.he_bing.adapter.ConsultationTwoAdapter;
import com.wd.he_bing.adapter.IllnessAdapter;
import com.wd.he_bing.bean.CDepartmentlistBean;
import com.wd.he_bing.bean.CGenJuKeShiBean;
import com.wd.he_bing.bean.PostPatientCircleBean;
import com.wd.he_bing.contract.CHomeContract;
import com.wd.he_bing.presenter.CHomePresenter;
import com.wd.he_bing.utils.CustomImgPickerPresenter;
import com.wd.he_bing.utils.WeChatPresenter;
import com.ypx.imagepicker.ImagePicker;
import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.data.OnImagePickCompleteListener;
import com.ypx.imagepicker.presenter.IPickerPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ReleaseCirclesActivity extends BaseActivity<CHomePresenter> implements CHomeContract.CHomeView {
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    @BindView(R.id.release_sickCircle_iv_user_head_pic)
    ImageView releaseSickCircleIvUserHeadPic;
    @BindView(R.id.patient_iv_user_message)
    ImageView patientIvUserMessage;
    @BindView(R.id.release_circle_et_title)
    EditText releaseCircleEtTitle;
    @BindView(R.id.release_circle_tv_choose_department)
    TextView releaseCircleTvChooseDepartment;
    @BindView(R.id.release_circle_iv_choose_department)
    RelativeLayout releaseCircleIvChooseDepartment;
    @BindView(R.id.release_circle_tv_choose_disease)
    TextView releaseCircleTvChooseDisease;
    @BindView(R.id.release_circle_iv_choose_disease)
    RelativeLayout releaseCircleIvChooseDisease;
    @BindView(R.id.release_circle_et_detail)
    EditText releaseCircleEtDetail;
    @BindView(R.id.release_circle_et_treatmentHospital)
    EditText releaseCircleEtTreatmentHospital;
    @BindView(R.id.release_circle_tv_startTime)
    TextView releaseCircleTvStartTime;
    @BindView(R.id.release_circle_iv_startTime)
    RelativeLayout releaseCircleIvStartTime;
    @BindView(R.id.release_circle_tv_endTime)
    TextView releaseCircleTvEndTime;
    @BindView(R.id.release_circle_iv_endTime)
    RelativeLayout releaseCircleIvEndTime;
    @BindView(R.id.release_circle_et_treatmentProcess)
    EditText releaseCircleEtTreatmentProcess;
    @BindView(R.id.release_circle_iv_upload_Picture)
    GridLayout releaseCircleIvUploadPicture;
    @BindView(R.id.release_circle_iv_delete_Picture)
    ImageView releaseCircleIvDeletePicture;
    @BindView(R.id.swit)
    Switch swit;
    @BindView(R.id.button_hbi3)
    Button buttonHbi3;
    @BindView(R.id.aaa)
    TextView aaa;
    @BindView(R.id.xuanshangedu_linear)
    LinearLayout xuanshangeduLinear;
    @BindView(R.id.release_circle_btn_publish)
    Button releaseCircleBtnPublish;
    @BindView(R.id.release_circle_linear_sick_circle)
    LinearLayout releaseCircleLinearSickCircle;

    private RecyclerView popup_recycler_department;
    private PopupWindow popupWindow;
    private String id;
    private RecyclerView popup_recycler_disease;
    private List<MultipartBody.Part> picture;
    private PopupWindow popWindowDisease;
    private int sickCircleId;
    private GridLayout mGridLayout;
    private List<MultipartBody.Part> parts = new ArrayList<>();
    private ArrayList<ImageItem> picList = new ArrayList<>();
    private String zhang;
    private String mi;


    @Override
    protected int bindLayout() {
        return R.layout.activity_release_circles;
    }

    @Override
    protected CHomePresenter setPresenter() {
        return new CHomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        mGridLayout = findViewById(R.id.release_circle_iv_upload_Picture);
    }

    @Override
    protected void initData() {
        super.initData();
        initDate();
        refreshGridLayout();
        //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //悬赏额度的开关
        swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    xuanshangeduLinear.setVisibility(View.VISIBLE);
                } else {
                    xuanshangeduLinear.setVisibility(View.GONE);
                }
            }
        });
        //开始时间
        releaseCircleIvStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        releaseCircleTvStartTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        //结束时间
        releaseCircleIvEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        releaseCircleTvEndTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        releaseCircleIvChooseDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //查询科室列表
                initPopuWindows(view);
            }
        });
        //对应病症
        releaseCircleIvChooseDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据科室查询对应病症
                initPopWindowDisease(v);
            /*    presenter.CHomePresenterChaXunBingZheng(id + "");
                Toast.makeText(ReleaseCirclesActivity.this, "2222", Toast.LENGTH_SHORT).show();*/
            }
        });
    }

    private void initPopWindowDisease(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_popip_disease, null, false);
        popup_recycler_disease = view.findViewById(R.id.popup_recycler_disease);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        popWindowDisease = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindowDisease.setAnimationStyle(R.anim.anim_pop);  //设置加载动画
        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popWindowDisease.setTouchable(true);
        popWindowDisease.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindowDisease.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindowDisease.showAsDropDown(v, 50, 0);

        presenter.CHomePresenterChaXunBingZheng(id);
    }

    private void initPopuWindows(View view) {
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_popip_department, null, false);
        popup_recycler_department = view1.findViewById(R.id.popup_recycler_department);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        popupWindow = new PopupWindow(view1,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popupWindow.showAsDropDown(view, 50, 0);
        presenter.CHomePresenterKeShiLieBiao();
    }

    private void initDate() {
        SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
        zhang = login.getString("zhang", "");
        mi = login.getString("mi", "");
    /*    userId = (int) SpUtils.get(this, Constant.Sp_userId, 0);
        sessionId = (String) SpUtils.get(this, Constant.Sp_sessionId, "");*/
        //点击发布圈子

        releaseCircleBtnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //标题
                String title = releaseCircleEtTitle.getText().toString().trim();
                //病症详情
                String detail = releaseCircleEtDetail.getText().toString().trim();
                //病症描述
                String disease = releaseCircleTvChooseDisease.getText().toString().trim();
                //治疗医院
                String treatmentHospital = releaseCircleEtTreatmentHospital.getText().toString().trim();
                //治疗开始时间 格式’2018-3-26’
                String treatmentStartTime = releaseCircleTvStartTime.getText().toString().trim();
                //	治疗结束时间 格式’2018-6-26’

                String treatmentEndTime = releaseCircleTvEndTime.getText().toString().trim();

                String treatmentProcess = releaseCircleEtTreatmentProcess.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "标题不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(detail)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请输入病症详情", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(disease)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "病症描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(disease)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "病症描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentStartTime)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请选择治疗开始时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentEndTime)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请选择治疗结束时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentHospital)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请输入治疗医院", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentProcess)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "治疗过程描述", Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String, Object> map = new HashMap<>();
                map.put("title", title);
                map.put("departmentId", id);
                map.put("disease", disease);
                map.put("detail", detail);
                map.put("treatmentHospital", treatmentHospital);
                map.put("treatmentStartTime", treatmentStartTime);
                map.put("treatmentEndTime", treatmentEndTime);
                map.put("treatmentProcess", treatmentProcess);
                map.put("amount", 0);
                //调发布圈子接口
                presenter.CHomePresenterFaBuBingYouQuan(zhang + "", mi, map);
            }
        });
    }

    @Override
    public void CHomeViewSuccess(Object obj) {
        if (obj instanceof CDepartmentlistBean) {
            CDepartmentlistBean cDepartmentlistBean = (CDepartmentlistBean) obj;
            List<CDepartmentlistBean.ResultBean> result = cDepartmentlistBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            ConsultationTwoAdapter consultationTwoAdapter = new ConsultationTwoAdapter(result, this);
            popup_recycler_department.setLayoutManager(linearLayoutManager);
            popup_recycler_department.setAdapter(consultationTwoAdapter);
            consultationTwoAdapter.setSetOnItemClickListen(new ConsultationTwoAdapter.SetOnItemClickListen() {
                @Override
                public void setOnItemClik(int i) {
                    id = result.get(i).getId();
                    releaseCircleTvChooseDepartment.setText(result.get(i).getDepartmentName());
                    Toast.makeText(ReleaseCirclesActivity.this, result.get(i).getDepartmentName(), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            });
        } else if (obj instanceof CGenJuKeShiBean) {
            CGenJuKeShiBean cGenJuKeShiBean = (CGenJuKeShiBean) obj;
            List<CGenJuKeShiBean.ResultBean> result = cGenJuKeShiBean.getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            IllnessAdapter illnessAdapter = new IllnessAdapter(result, this);
            popup_recycler_disease.setLayoutManager(gridLayoutManager);
            popup_recycler_disease.setAdapter(illnessAdapter);
            illnessAdapter.setSetOnItemClicks(new IllnessAdapter.SetOnItemClicks() {
                @Override
                public void setOnItems(int i) {
                    String name = result.get(i).getName();
                    releaseCircleTvChooseDisease.setText(name + "");
                    popWindowDisease.dismiss();
                }
            });
        } else if (obj instanceof PostPatientCircleBean) {
            PostPatientCircleBean postPatientCircleBean = (PostPatientCircleBean) obj;
            if (postPatientCircleBean.getStatus().equals("0000")) {
                Toast.makeText(this, postPatientCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
                sickCircleId = postPatientCircleBean.getResult();
                Log.i("sickCircleId", "publishSuccess: " + "sickCircleId" + sickCircleId);
                if (picture != null) {
                    //上传图片
                    presenter.CHomePresenterShangChuanTuPian(zhang, mi, "sickCircleId", picture);
                } else {
                    //做任务
                    presenter.CHomePresenterZuoRenWu(zhang, mi, "1003");
                    finish();
                }
                notifyAll();
            } else {
                Toast.makeText(this, postPatientCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void CHomeViewError(String e) {

    }

    /**
     * 刷新图片显示
     */
    private void refreshGridLayout() {
        mGridLayout.setVisibility(View.VISIBLE);
        mGridLayout.removeAllViews();
        int num = picList.size();
        final int picSize = (getScreenWidth() - dp(20)) / 4;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(picSize, picSize);
        if (num >= 6) {
            mGridLayout.setVisibility(View.VISIBLE);
            for (int i = 0; i < num; i++) {
                RelativeLayout view = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.a_layout_pic_select, null);
                view.setLayoutParams(params);
                view.setPadding(dp(5), dp(5), dp(5), dp(5));
                setPicItemClick(view, i);
                mGridLayout.addView(view);
            }
        } else {
            mGridLayout.setVisibility(View.VISIBLE);
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(dp(5), dp(5), dp(5), dp(5));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPick();
                }
            });
            for (int i = 0; i < num; i++) {
                RelativeLayout view = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.a_layout_pic_select, null);
                view.setLayoutParams(params);
                view.setPadding(dp(5), dp(5), dp(5), dp(5));
                setPicItemClick(view, i);
                mGridLayout.addView(view);
            }
            mGridLayout.addView(imageView);
        }
    }

    public void setPicItemClick(RelativeLayout layout, final int pos) {
        ImageView iv_pic = (ImageView) layout.getChildAt(0);
        ImageView iv_close = (ImageView) layout.getChildAt(1);
        Glide.with(context()).load(picList.get(pos).path).into(iv_pic);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picList.remove(pos);
                refreshGridLayout();
            }
        });
        iv_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preview(pos);
            }
        });
    }

    public int dp(float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, this.getResources().getDisplayMetrics());
    }

    /**
     * 获得屏幕宽度
     */
    public int getScreenWidth() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        assert wm != null;
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    private void startPick() {
        pick(6 - picList.size());
    }

    private void preview(int pos) {
        IPickerPresenter presenter = true ? new WeChatPresenter() : new CustomImgPickerPresenter();
        //开启编辑预览
        ImagePicker.preview(this, presenter, picList, pos, new OnImagePickCompleteListener() {
            @Override
            public void onImagePickComplete(ArrayList<ImageItem> items) {
                //图片编辑回调，主线程
                picList.clear();
                picList.addAll(items);
                refreshGridLayout();
            }
        });
    }
    private void pick(int count) {
        final IPickerPresenter presenter = true ? new WeChatPresenter() : new CustomImgPickerPresenter();
        ImagePicker.withMulti(presenter)//指定presenter
                .setMaxCount(count)//设置选择的最大数
                .setColumnCount(4)//设置显示列数
                .showCamera(true)//设置是否显示拍照按钮（在列表第一个）
                .setMaxVideoDuration(120000)//设置视频可选择的最大时长
                //设置只能选择视频或图片
                .setSinglePickImageOrVideoType(true)
                //设置只能选择一个视频
                .setVideoSinglePick(true)
                //设置下次选择需要屏蔽的图片或视频（简单点就是不可重复选择）
                .setShieldList(new ArrayList<String>())
                //设置下次选择需要带入的图片和视频（简单点就是记录上次选择的图片，可以取消之前选择）
                .setLastImageList(new ArrayList<String>())
                //调用多选
                .pick(this, new OnImagePickCompleteListener() {
                    @Override
                    public void onImagePickComplete(ArrayList<ImageItem> items) {
                        //处理回调回来的图片信息，主线程
                        //处理回调回来的图片信息，主线程
                        picList.addAll(items);
                        String path = items.get(0).path;
                        if (path != null) {
                            File file = new File(path);
                            RequestBody requestBody = MultipartBody.create(MediaType.parse("image/*"), file);
                            MultipartBody.Part part = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
                            parts.add(part);
                            refreshGridLayout();
                        }
                    }
                });
    }
}
