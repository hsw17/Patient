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
import butterknife.internal.Utils;
import com.wd.he_bing.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CPatientCircleDetailsActivity_ViewBinding implements Unbinder {
  private CPatientCircleDetailsActivity target;

  @UiThread
  public CPatientCircleDetailsActivity_ViewBinding(CPatientCircleDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CPatientCircleDetailsActivity_ViewBinding(CPatientCircleDetailsActivity target,
      View source) {
    this.target = target;

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
  }
}
