package com.wd.mymodlue.view.activity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.app.App;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.HeadPicBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import androidx.core.app.ActivityCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MessageActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    //需要的权限数组 读/写/相机
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.my_information_Avatar)
    SimpleDraweeView myInformationAvatar;
    @BindView(R2.id.my_information_Avatar_a)
    RelativeLayout myInformationAvatarA;
    @BindView(R2.id.my_information_name)
    TextView myInformationName;
    @BindView(R2.id.a2)
    ImageView a2;
    @BindView(R2.id.my_information_name_a)
    RelativeLayout myInformationNameA;
    @BindView(R2.id.my_information_gender)
    ImageView myInformationGender;
    @BindView(R2.id.b1)
    ImageView b1;
    @BindView(R2.id.my_information_gender_a)
    RelativeLayout myInformationGenderA;
    @BindView(R2.id.my_information_height)
    TextView myInformationHeight;
    @BindView(R2.id.my_information_bodyweight)
    TextView myInformationBodyweight;
    @BindView(R2.id.my_information_age)
    TextView myInformationAge;
    @BindView(R2.id.b2)
    ImageView b2;
    @BindView(R2.id.my_information_Sign)
    RelativeLayout myInformationSign;
    @BindView(R2.id.my_information_mailbox)
    TextView myInformationMailbox;
    @BindView(R2.id.my_information_mailbox_a)
    RelativeLayout myInformationMailboxA;
    @BindView(R2.id.my_information_weixin)
    TextView myInformationWeixin;
    @BindView(R2.id.c2)
    ImageView c2;
    @BindView(R2.id.my_information_weixin_a)
    RelativeLayout myInformationWeixinA;
    @BindView(R2.id.my_information_Certification)
    TextView myInformationCertification;
    @BindView(R2.id.d1)
    ImageView d1;
    @BindView(R2.id.my_information_Certification_a)
    RelativeLayout myInformationCertificationA;
    @BindView(R2.id.my_information_Bankcard)
    TextView myInformationBankcard;
    @BindView(R2.id.d2)
    ImageView d2;
    @BindView(R2.id.my_information_Bankcard_a)
    RelativeLayout myInformationBankcardA;
    @BindView(R2.id.but_shoot)
    Button butShoot;
    @BindView(R2.id.but_photo)
    Button butPhoto;
    @BindView(R2.id.but_finish)
    Button butFinish;
    @BindView(R2.id.linear_gone)
    LinearLayout linearGone;
    private int id;
    private String sessionId;

    @Override
    protected int bindLayout() {
        return R.layout.activity_message;
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
        id = (int) login.getSharedPreference("id", 0);
        sessionId = (String) login.getSharedPreference("sessionId", "");

//          返回
        fanhui.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
//        点击头像上传
        myInformationAvatar.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                linearGone.setVisibility(
                        View.VISIBLE
                );
            }

            @Override
            protected void onFastClick() {

            }
        });
//        相机
        butShoot.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                //检查是否已经获得相机的权限
                if(verifyPermissions(MessageActivity.this,PERMISSIONS_STORAGE[2]) == 0){
                    ActivityCompat.requestPermissions(MessageActivity.this, PERMISSIONS_STORAGE, 3);
                }else{
                    //已经有权限
                    Intent intent = new Intent ( MediaStore.ACTION_IMAGE_CAPTURE );
                    startActivityForResult ( intent,101 );
                }
            }

            @Override
            protected void onFastClick() {

            }
        });
//        相册
        butPhoto.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent(Intent.ACTION_PICK);  //跳转到 ACTION_IMAGE_CAPTURE
                intent.setType("image/*");
                startActivityForResult(intent,100);
            }

            @Override
            protected void onFastClick() {

            }
        });
        butFinish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

                linearGone.setVisibility(View.GONE);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        修改昵称
        myInformationNameA.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.NicknameActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        修改性别
        myInformationGenderA.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.GenderActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
//      体征
        myInformationSign.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.FeatureActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",id);
        map.put("sessionId",sessionId);
        //判断返回码不等于0
        if (requestCode != RESULT_CANCELED) {
            //读取返回码
            switch (requestCode) {
                case 100:   //相册返回的数据（相册的返回码）
                    if (data!=null) {
                        Uri uri01 = data.getData();
                        if (uri01!=null) {
                            Log.i("aaa", "onActivityResult: " + uri01);
                            String[] str = {MediaStore.Images.Media.DATA};
//                    游标
                            Cursor cursor = getContentResolver().query(uri01, str, null, null, null);
//                  如果没有找到该列名,会抛出IllegalArgumentException异常
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            cursor.moveToFirst();

                            String path = cursor.getString(columnIndexOrThrow);
                            Log.i("aaa", "onActivityResult: " + path);
//                    文件
                            File file = new File(path);
//                      创建请求体
                            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                            MultipartBody.Part formData = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                            Log.i("aaa", "onActivityResult: " + formData);

                            presenter.onloadHeadPic(map, formData);
                            linearGone.setVisibility(View.GONE);
                        }
                    }else{
                        linearGone.setVisibility(View.GONE);

                        return;
                    }

                    break;
                case 101:  //相机返回的数据（相机的返回码）
                    if (data!=null) {
                        try {

                            Bitmap bitmap = data.getParcelableExtra("data");
                            if (bitmap != null) {
                                File file1 = saveBitmapFile(bitmap);
//                        File file1 = new File(Environment.getExternalStorageDirectory(), "fileImg.jpg");//相机取图片数据文件
                                RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                                MultipartBody.Part formData1 = MultipartBody.Part.createFormData("image", file1.getName(), requestBody1);
                                presenter.onloadHeadPic(map, formData1);
                                linearGone.setVisibility(View.GONE
                                );
                            } else {
                                linearGone.setVisibility(View.GONE);
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        linearGone.setVisibility(View.GONE);
                        return;
                    }
                    break;
            }
        }
    }

    public File saveBitmapFile(Bitmap bitmap) {
        String timeStamp = String.valueOf(new Date().getTime());
        File  file = new File( Environment.getExternalStorageDirectory() +
                File.separator + timeStamp+".jpg");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    @Override
    public void onSuccess(Object obj) {
        HeadPicBean headPicBean= (HeadPicBean) obj;
        if ("0000".equals(headPicBean.status)) {
            ToastUtils.show(headPicBean.message);
            myInformationAvatar.setImageURI(headPicBean.result);
        }else {
            ToastUtils.show(headPicBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {

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
