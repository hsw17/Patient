// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.headTextName = Utils.findRequiredViewAsType(source, R.id.head_text_name, "field 'headTextName'", TextView.class);
    target.relayLayout = Utils.findRequiredViewAsType(source, R.id.relay_layout, "field 'relayLayout'", RelativeLayout.class);
    target.settingImageView = Utils.findRequiredViewAsType(source, R.id.setting_image_view, "field 'settingImageView'", SimpleDraweeView.class);
    target.settingTextName = Utils.findRequiredViewAsType(source, R.id.setting_text_name, "field 'settingTextName'", TextView.class);
    target.settingImageName = Utils.findRequiredViewAsType(source, R.id.setting_image_name, "field 'settingImageName'", LinearLayout.class);
    target.settingImagePwd = Utils.findRequiredViewAsType(source, R.id.setting_image_pwd, "field 'settingImagePwd'", LinearLayout.class);
    target.settingTextClear = Utils.findRequiredViewAsType(source, R.id.setting_text_clear, "field 'settingTextClear'", TextView.class);
    target.settingImageClear = Utils.findRequiredViewAsType(source, R.id.setting_image_clear, "field 'settingImageClear'", RelativeLayout.class);
    target.settingImagePingLian = Utils.findRequiredViewAsType(source, R.id.setting_image_ping_lian, "field 'settingImagePingLian'", RelativeLayout.class);
    target.settingImageNewApp = Utils.findRequiredViewAsType(source, R.id.setting_image_new_app, "field 'settingImageNewApp'", RelativeLayout.class);
    target.settingImagePingHelp = Utils.findRequiredViewAsType(source, R.id.setting_image_ping_help, "field 'settingImagePingHelp'", RelativeLayout.class);
    target.settingImageMy = Utils.findRequiredViewAsType(source, R.id.setting_image_my, "field 'settingImageMy'", RelativeLayout.class);
    target.settingImageNewInvite = Utils.findRequiredViewAsType(source, R.id.setting_image_new_invite, "field 'settingImageNewInvite'", RelativeLayout.class);
    target.settingImageLogin = Utils.findRequiredViewAsType(source, R.id.setting_image_login, "field 'settingImageLogin'", RelativeLayout.class);
    target.settingImageLayout = Utils.findRequiredViewAsType(source, R.id.setting_image_layout, "field 'settingImageLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.headTextName = null;
    target.relayLayout = null;
    target.settingImageView = null;
    target.settingTextName = null;
    target.settingImageName = null;
    target.settingImagePwd = null;
    target.settingTextClear = null;
    target.settingImageClear = null;
    target.settingImagePingLian = null;
    target.settingImageNewApp = null;
    target.settingImagePingHelp = null;
    target.settingImageMy = null;
    target.settingImageNewInvite = null;
    target.settingImageLogin = null;
    target.settingImageLayout = null;
  }
}
