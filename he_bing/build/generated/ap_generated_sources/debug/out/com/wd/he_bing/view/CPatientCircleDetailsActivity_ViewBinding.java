// Generated code from Butter Knife. Do not modify!
package com.wd.he_bing.view;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wd.he_bing.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CPatientCircleDetailsActivity_ViewBinding implements Unbinder {
  private CPatientCircleDetailsActivity target;

  private View view7f080072;

  private View view7f08006f;

  private View view7f080073;

  private View view7f080074;

  private View view7f080069;

  private View view7f08006e;

  private View view7f08006c;

  private View view7f08006d;

  private View view7f080071;

  private View view7f080070;

  private View view7f080065;

  private View view7f08006b;

  private View view7f080063;

  private View view7f08006a;

  private View view7f08005c;

  private View view7f080060;

  private View view7f080077;

  private View view7f080076;

  private View view7f08005b;

  private View view7f080075;

  private View view7f080062;

  private View view7f080061;

  private View view7f080066;

  private View view7f080067;

  private View view7f080064;

  private View view7f080068;

  @UiThread
  public CPatientCircleDetailsActivity_ViewBinding(CPatientCircleDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CPatientCircleDetailsActivity_ViewBinding(final CPatientCircleDetailsActivity target,
      View source) {
    this.target = target;

    View view;
    target.cPatientIvUserHeadPic = Utils.findRequiredViewAsType(source, R.id.c_patient_iv_user_head_pic, "field 'cPatientIvUserHeadPic'", ImageView.class);
    target.cPatientActivityTvTitle = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_title, "field 'cPatientActivityTvTitle'", TextView.class);
    target.cPatientIvUserMessage = Utils.findRequiredViewAsType(source, R.id.c_patient_iv_user_message, "field 'cPatientIvUserMessage'", ImageView.class);
    target.cPatientRelativeTitlebar = Utils.findRequiredViewAsType(source, R.id.c_patient_relative_titlebar, "field 'cPatientRelativeTitlebar'", RelativeLayout.class);
    target.cPatientActivityTvAdoptNickName = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_adoptNickName, "field 'cPatientActivityTvAdoptNickName'", TextView.class);
    target.cPatientActivityTvDisease = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_disease, "field 'cPatientActivityTvDisease'", TextView.class);
    target.cPatientActivityTvDepartment = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_department, "field 'cPatientActivityTvDepartment'", TextView.class);
    target.cPatientActivityTvDetail = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_detail, "field 'cPatientActivityTvDetail'", TextView.class);
    target.cPatientActivityTvTreatmentTime = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_treatment_time, "field 'cPatientActivityTvTreatmentTime'", TextView.class);
    target.cPatientActivityTvTreatmentProcess = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_treatmentProcess, "field 'cPatientActivityTvTreatmentProcess'", TextView.class);
    target.cPatientActivityIvPicture = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_iv_picture, "field 'cPatientActivityIvPicture'", ImageView.class);
    target.cPatientActivityTvCommentNum = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_commentNum, "field 'cPatientActivityTvCommentNum'", TextView.class);
    target.cPatientActivityIvContent = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_iv_content, "field 'cPatientActivityIvContent'", ImageView.class);
    target.cPatientActivityTvCollectionNum = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_tv_collectionNum, "field 'cPatientActivityTvCollectionNum'", TextView.class);
    target.cImgHeadPic = Utils.findRequiredViewAsType(source, R.id.c_img_HeadPic, "field 'cImgHeadPic'", ImageView.class);
    target.cNameNickName = Utils.findRequiredViewAsType(source, R.id.c_name_NickName, "field 'cNameNickName'", TextView.class);
    target.cTimeAdoptTime = Utils.findRequiredViewAsType(source, R.id.c_time_adoptTime, "field 'cTimeAdoptTime'", TextView.class);
    target.cTextAdoptComment = Utils.findRequiredViewAsType(source, R.id.c_text_adoptComment, "field 'cTextAdoptComment'", TextView.class);
    target.cAdoptFlag = Utils.findRequiredViewAsType(source, R.id.c_adoptFlag, "field 'cAdoptFlag'", LinearLayout.class);
    target.cRecyclerSickCircleCommentList = Utils.findRequiredViewAsType(source, R.id.c_recycler_sick_circle_comment_list, "field 'cRecyclerSickCircleCommentList'", RecyclerView.class);
    target.cPatientActivityIvCancel = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_iv_cancel, "field 'cPatientActivityIvCancel'", ImageView.class);
    target.cPatientActivityEtContent = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_et_content, "field 'cPatientActivityEtContent'", EditText.class);
    target.cPatientActivityIvSendContent = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_iv_send_content, "field 'cPatientActivityIvSendContent'", ImageView.class);
    target.cPatientActivityRelativeContent = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_relative_content, "field 'cPatientActivityRelativeContent'", RelativeLayout.class);
    target.cPatientActivityIvIntentReleaseSickCircle = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_iv_intent_release_sickCircle, "field 'cPatientActivityIvIntentReleaseSickCircle'", ImageView.class);
    target.cPatientActivityRelativeReleaseSickCircle = Utils.findRequiredViewAsType(source, R.id.c_patient_activity_relative_release_sickCircle, "field 'cPatientActivityRelativeReleaseSickCircle'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.c_patient_iv_user_head_pic, "method 'onViewClicked'");
    view7f080072 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_title, "method 'onViewClicked'");
    view7f08006f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_iv_user_message, "method 'onViewClicked'");
    view7f080073 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_relative_titlebar, "method 'onViewClicked'");
    view7f080074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_adoptNickName, "method 'onViewClicked'");
    view7f080069 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_disease, "method 'onViewClicked'");
    view7f08006e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_department, "method 'onViewClicked'");
    view7f08006c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_detail, "method 'onViewClicked'");
    view7f08006d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_treatment_time, "method 'onViewClicked'");
    view7f080071 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_treatmentProcess, "method 'onViewClicked'");
    view7f080070 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_iv_picture, "method 'onViewClicked'");
    view7f080065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_commentNum, "method 'onViewClicked'");
    view7f08006b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_iv_content, "method 'onViewClicked'");
    view7f080063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_tv_collectionNum, "method 'onViewClicked'");
    view7f08006a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_img_HeadPic, "method 'onViewClicked'");
    view7f08005c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_name_NickName, "method 'onViewClicked'");
    view7f080060 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_time_adoptTime, "method 'onViewClicked'");
    view7f080077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_text_adoptComment, "method 'onViewClicked'");
    view7f080076 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_adoptFlag, "method 'onViewClicked'");
    view7f08005b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_recycler_sick_circle_comment_list, "method 'onViewClicked'");
    view7f080075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_iv_cancel, "method 'onViewClicked'");
    view7f080062 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_et_content, "method 'onViewClicked'");
    view7f080061 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_iv_send_content, "method 'onViewClicked'");
    view7f080066 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_relative_content, "method 'onViewClicked'");
    view7f080067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_iv_intent_release_sickCircle, "method 'onViewClicked'");
    view7f080064 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_patient_activity_relative_release_sickCircle, "method 'onViewClicked'");
    view7f080068 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CPatientCircleDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cPatientIvUserHeadPic = null;
    target.cPatientActivityTvTitle = null;
    target.cPatientIvUserMessage = null;
    target.cPatientRelativeTitlebar = null;
    target.cPatientActivityTvAdoptNickName = null;
    target.cPatientActivityTvDisease = null;
    target.cPatientActivityTvDepartment = null;
    target.cPatientActivityTvDetail = null;
    target.cPatientActivityTvTreatmentTime = null;
    target.cPatientActivityTvTreatmentProcess = null;
    target.cPatientActivityIvPicture = null;
    target.cPatientActivityTvCommentNum = null;
    target.cPatientActivityIvContent = null;
    target.cPatientActivityTvCollectionNum = null;
    target.cImgHeadPic = null;
    target.cNameNickName = null;
    target.cTimeAdoptTime = null;
    target.cTextAdoptComment = null;
    target.cAdoptFlag = null;
    target.cRecyclerSickCircleCommentList = null;
    target.cPatientActivityIvCancel = null;
    target.cPatientActivityEtContent = null;
    target.cPatientActivityIvSendContent = null;
    target.cPatientActivityRelativeContent = null;
    target.cPatientActivityIvIntentReleaseSickCircle = null;
    target.cPatientActivityRelativeReleaseSickCircle = null;

    view7f080072.setOnClickListener(null);
    view7f080072 = null;
    view7f08006f.setOnClickListener(null);
    view7f08006f = null;
    view7f080073.setOnClickListener(null);
    view7f080073 = null;
    view7f080074.setOnClickListener(null);
    view7f080074 = null;
    view7f080069.setOnClickListener(null);
    view7f080069 = null;
    view7f08006e.setOnClickListener(null);
    view7f08006e = null;
    view7f08006c.setOnClickListener(null);
    view7f08006c = null;
    view7f08006d.setOnClickListener(null);
    view7f08006d = null;
    view7f080071.setOnClickListener(null);
    view7f080071 = null;
    view7f080070.setOnClickListener(null);
    view7f080070 = null;
    view7f080065.setOnClickListener(null);
    view7f080065 = null;
    view7f08006b.setOnClickListener(null);
    view7f08006b = null;
    view7f080063.setOnClickListener(null);
    view7f080063 = null;
    view7f08006a.setOnClickListener(null);
    view7f08006a = null;
    view7f08005c.setOnClickListener(null);
    view7f08005c = null;
    view7f080060.setOnClickListener(null);
    view7f080060 = null;
    view7f080077.setOnClickListener(null);
    view7f080077 = null;
    view7f080076.setOnClickListener(null);
    view7f080076 = null;
    view7f08005b.setOnClickListener(null);
    view7f08005b = null;
    view7f080075.setOnClickListener(null);
    view7f080075 = null;
    view7f080062.setOnClickListener(null);
    view7f080062 = null;
    view7f080061.setOnClickListener(null);
    view7f080061 = null;
    view7f080066.setOnClickListener(null);
    view7f080066 = null;
    view7f080067.setOnClickListener(null);
    view7f080067 = null;
    view7f080064.setOnClickListener(null);
    view7f080064 = null;
    view7f080068.setOnClickListener(null);
    view7f080068 = null;
  }
}
