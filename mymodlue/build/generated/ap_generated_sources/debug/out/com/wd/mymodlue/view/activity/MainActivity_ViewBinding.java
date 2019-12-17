// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.Button;
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

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.myImageSimple = Utils.findRequiredViewAsType(source, R.id.my_image_simple, "field 'myImageSimple'", SimpleDraweeView.class);
    target.myTextLogin = Utils.findRequiredViewAsType(source, R.id.my_text_login, "field 'myTextLogin'", TextView.class);
    target.myButtonSingIn = Utils.findRequiredViewAsType(source, R.id.my_button_sing_in, "field 'myButtonSingIn'", Button.class);
    target.linearLay = Utils.findRequiredViewAsType(source, R.id.linear_lay, "field 'linearLay'", LinearLayout.class);
    target.myButtonInquiry = Utils.findRequiredViewAsType(source, R.id.my_button_inquiry, "field 'myButtonInquiry'", RelativeLayout.class);
    target.myButtonHistory = Utils.findRequiredViewAsType(source, R.id.my_button_history, "field 'myButtonHistory'", RelativeLayout.class);
    target.reLatiview = Utils.findRequiredViewAsType(source, R.id.re_latiview, "field 'reLatiview'", RelativeLayout.class);
    target.myButtonRecord = Utils.findRequiredViewAsType(source, R.id.my_button_record, "field 'myButtonRecord'", LinearLayout.class);
    target.myButtonWallet = Utils.findRequiredViewAsType(source, R.id.my_button_wallet, "field 'myButtonWallet'", LinearLayout.class);
    target.myButtonCollect = Utils.findRequiredViewAsType(source, R.id.my_button_collect, "field 'myButtonCollect'", LinearLayout.class);
    target.myButtonSuggest = Utils.findRequiredViewAsType(source, R.id.my_button_suggest, "field 'myButtonSuggest'", LinearLayout.class);
    target.myButtonVideo = Utils.findRequiredViewAsType(source, R.id.my_button_video, "field 'myButtonVideo'", LinearLayout.class);
    target.myButtonPatientsCircle = Utils.findRequiredViewAsType(source, R.id.my_button_patients_circle, "field 'myButtonPatientsCircle'", LinearLayout.class);
    target.myButtonAttention = Utils.findRequiredViewAsType(source, R.id.my_button_attention, "field 'myButtonAttention'", LinearLayout.class);
    target.myButtonTask = Utils.findRequiredViewAsType(source, R.id.my_button_task, "field 'myButtonTask'", LinearLayout.class);
    target.myButtonSet = Utils.findRequiredViewAsType(source, R.id.my_button_set, "field 'myButtonSet'", LinearLayout.class);
    target.linearMy = Utils.findRequiredViewAsType(source, R.id.linear_my, "field 'linearMy'", LinearLayout.class);
    target.myTextTitle = Utils.findRequiredViewAsType(source, R.id.my_text_title, "field 'myTextTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.myImageSimple = null;
    target.myTextLogin = null;
    target.myButtonSingIn = null;
    target.linearLay = null;
    target.myButtonInquiry = null;
    target.myButtonHistory = null;
    target.reLatiview = null;
    target.myButtonRecord = null;
    target.myButtonWallet = null;
    target.myButtonCollect = null;
    target.myButtonSuggest = null;
    target.myButtonVideo = null;
    target.myButtonPatientsCircle = null;
    target.myButtonAttention = null;
    target.myButtonTask = null;
    target.myButtonSet = null;
    target.linearMy = null;
    target.myTextTitle = null;
  }
}
