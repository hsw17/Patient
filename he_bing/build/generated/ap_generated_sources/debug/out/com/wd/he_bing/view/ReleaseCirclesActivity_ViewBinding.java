// Generated code from Butter Knife. Do not modify!
package com.wd.he_bing.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.he_bing.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReleaseCirclesActivity_ViewBinding implements Unbinder {
  private ReleaseCirclesActivity target;

  @UiThread
  public ReleaseCirclesActivity_ViewBinding(ReleaseCirclesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReleaseCirclesActivity_ViewBinding(ReleaseCirclesActivity target, View source) {
    this.target = target;

    target.releaseSickCircleIvUserHeadPic = Utils.findRequiredViewAsType(source, R.id.release_sickCircle_iv_user_head_pic, "field 'releaseSickCircleIvUserHeadPic'", ImageView.class);
    target.patientIvUserMessage = Utils.findRequiredViewAsType(source, R.id.patient_iv_user_message, "field 'patientIvUserMessage'", ImageView.class);
    target.releaseCircleEtTitle = Utils.findRequiredViewAsType(source, R.id.release_circle_et_title, "field 'releaseCircleEtTitle'", EditText.class);
    target.releaseCircleTvChooseDepartment = Utils.findRequiredViewAsType(source, R.id.release_circle_tv_choose_department, "field 'releaseCircleTvChooseDepartment'", TextView.class);
    target.releaseCircleIvChooseDepartment = Utils.findRequiredViewAsType(source, R.id.release_circle_iv_choose_department, "field 'releaseCircleIvChooseDepartment'", RelativeLayout.class);
    target.releaseCircleTvChooseDisease = Utils.findRequiredViewAsType(source, R.id.release_circle_tv_choose_disease, "field 'releaseCircleTvChooseDisease'", TextView.class);
    target.releaseCircleIvChooseDisease = Utils.findRequiredViewAsType(source, R.id.release_circle_iv_choose_disease, "field 'releaseCircleIvChooseDisease'", RelativeLayout.class);
    target.releaseCircleEtDetail = Utils.findRequiredViewAsType(source, R.id.release_circle_et_detail, "field 'releaseCircleEtDetail'", EditText.class);
    target.releaseCircleEtTreatmentHospital = Utils.findRequiredViewAsType(source, R.id.release_circle_et_treatmentHospital, "field 'releaseCircleEtTreatmentHospital'", EditText.class);
    target.releaseCircleTvStartTime = Utils.findRequiredViewAsType(source, R.id.release_circle_tv_startTime, "field 'releaseCircleTvStartTime'", TextView.class);
    target.releaseCircleIvStartTime = Utils.findRequiredViewAsType(source, R.id.release_circle_iv_startTime, "field 'releaseCircleIvStartTime'", RelativeLayout.class);
    target.releaseCircleTvEndTime = Utils.findRequiredViewAsType(source, R.id.release_circle_tv_endTime, "field 'releaseCircleTvEndTime'", TextView.class);
    target.releaseCircleIvEndTime = Utils.findRequiredViewAsType(source, R.id.release_circle_iv_endTime, "field 'releaseCircleIvEndTime'", RelativeLayout.class);
    target.releaseCircleEtTreatmentProcess = Utils.findRequiredViewAsType(source, R.id.release_circle_et_treatmentProcess, "field 'releaseCircleEtTreatmentProcess'", EditText.class);
    target.releaseCircleIvUploadPicture = Utils.findRequiredViewAsType(source, R.id.release_circle_iv_upload_Picture, "field 'releaseCircleIvUploadPicture'", GridLayout.class);
    target.releaseCircleIvDeletePicture = Utils.findRequiredViewAsType(source, R.id.release_circle_iv_delete_Picture, "field 'releaseCircleIvDeletePicture'", ImageView.class);
    target.swit = Utils.findRequiredViewAsType(source, R.id.swit, "field 'swit'", Switch.class);
    target.buttonHbi3 = Utils.findRequiredViewAsType(source, R.id.button_hbi3, "field 'buttonHbi3'", Button.class);
    target.aaa = Utils.findRequiredViewAsType(source, R.id.aaa, "field 'aaa'", TextView.class);
    target.xuanshangeduLinear = Utils.findRequiredViewAsType(source, R.id.xuanshangedu_linear, "field 'xuanshangeduLinear'", LinearLayout.class);
    target.releaseCircleBtnPublish = Utils.findRequiredViewAsType(source, R.id.release_circle_btn_publish, "field 'releaseCircleBtnPublish'", Button.class);
    target.releaseCircleLinearSickCircle = Utils.findRequiredViewAsType(source, R.id.release_circle_linear_sick_circle, "field 'releaseCircleLinearSickCircle'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReleaseCirclesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.releaseSickCircleIvUserHeadPic = null;
    target.patientIvUserMessage = null;
    target.releaseCircleEtTitle = null;
    target.releaseCircleTvChooseDepartment = null;
    target.releaseCircleIvChooseDepartment = null;
    target.releaseCircleTvChooseDisease = null;
    target.releaseCircleIvChooseDisease = null;
    target.releaseCircleEtDetail = null;
    target.releaseCircleEtTreatmentHospital = null;
    target.releaseCircleTvStartTime = null;
    target.releaseCircleIvStartTime = null;
    target.releaseCircleTvEndTime = null;
    target.releaseCircleIvEndTime = null;
    target.releaseCircleEtTreatmentProcess = null;
    target.releaseCircleIvUploadPicture = null;
    target.releaseCircleIvDeletePicture = null;
    target.swit = null;
    target.buttonHbi3 = null;
    target.aaa = null;
    target.xuanshangeduLinear = null;
    target.releaseCircleBtnPublish = null;
    target.releaseCircleLinearSickCircle = null;
  }
}
