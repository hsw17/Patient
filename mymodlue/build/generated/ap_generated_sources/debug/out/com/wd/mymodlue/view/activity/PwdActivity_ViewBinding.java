// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PwdActivity_ViewBinding implements Unbinder {
  private PwdActivity target;

  @UiThread
  public PwdActivity_ViewBinding(PwdActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PwdActivity_ViewBinding(PwdActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.editOldPassword = Utils.findRequiredViewAsType(source, R.id.edit_old_password, "field 'editOldPassword'", EditText.class);
    target.editNewPassword = Utils.findRequiredViewAsType(source, R.id.edit_new_password, "field 'editNewPassword'", EditText.class);
    target.editAgainNewPassword = Utils.findRequiredViewAsType(source, R.id.edit_again_new_password, "field 'editAgainNewPassword'", EditText.class);
    target.butAffirm = Utils.findRequiredViewAsType(source, R.id.but_affirm, "field 'butAffirm'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PwdActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.editOldPassword = null;
    target.editNewPassword = null;
    target.editAgainNewPassword = null;
    target.butAffirm = null;
  }
}
