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

public class MessageActivity_ViewBinding implements Unbinder {
  private MessageActivity target;

  @UiThread
  public MessageActivity_ViewBinding(MessageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MessageActivity_ViewBinding(MessageActivity target, View source) {
    this.target = target;

    target.fanhui = Utils.findRequiredViewAsType(source, R.id.fanhui, "field 'fanhui'", ImageView.class);
    target.myInformationAvatar = Utils.findRequiredViewAsType(source, R.id.my_information_Avatar, "field 'myInformationAvatar'", SimpleDraweeView.class);
    target.myInformationAvatarA = Utils.findRequiredViewAsType(source, R.id.my_information_Avatar_a, "field 'myInformationAvatarA'", RelativeLayout.class);
    target.myInformationName = Utils.findRequiredViewAsType(source, R.id.my_information_name, "field 'myInformationName'", TextView.class);
    target.a2 = Utils.findRequiredViewAsType(source, R.id.a2, "field 'a2'", ImageView.class);
    target.myInformationNameA = Utils.findRequiredViewAsType(source, R.id.my_information_name_a, "field 'myInformationNameA'", RelativeLayout.class);
    target.myInformationGender = Utils.findRequiredViewAsType(source, R.id.my_information_gender, "field 'myInformationGender'", ImageView.class);
    target.b1 = Utils.findRequiredViewAsType(source, R.id.b1, "field 'b1'", ImageView.class);
    target.myInformationGenderA = Utils.findRequiredViewAsType(source, R.id.my_information_gender_a, "field 'myInformationGenderA'", RelativeLayout.class);
    target.myInformationHeight = Utils.findRequiredViewAsType(source, R.id.my_information_height, "field 'myInformationHeight'", TextView.class);
    target.myInformationBodyweight = Utils.findRequiredViewAsType(source, R.id.my_information_bodyweight, "field 'myInformationBodyweight'", TextView.class);
    target.myInformationAge = Utils.findRequiredViewAsType(source, R.id.my_information_age, "field 'myInformationAge'", TextView.class);
    target.b2 = Utils.findRequiredViewAsType(source, R.id.b2, "field 'b2'", ImageView.class);
    target.myInformationSign = Utils.findRequiredViewAsType(source, R.id.my_information_Sign, "field 'myInformationSign'", RelativeLayout.class);
    target.myInformationMailbox = Utils.findRequiredViewAsType(source, R.id.my_information_mailbox, "field 'myInformationMailbox'", TextView.class);
    target.myInformationMailboxA = Utils.findRequiredViewAsType(source, R.id.my_information_mailbox_a, "field 'myInformationMailboxA'", RelativeLayout.class);
    target.myInformationWeixin = Utils.findRequiredViewAsType(source, R.id.my_information_weixin, "field 'myInformationWeixin'", TextView.class);
    target.c2 = Utils.findRequiredViewAsType(source, R.id.c2, "field 'c2'", ImageView.class);
    target.myInformationWeixinA = Utils.findRequiredViewAsType(source, R.id.my_information_weixin_a, "field 'myInformationWeixinA'", RelativeLayout.class);
    target.myInformationCertification = Utils.findRequiredViewAsType(source, R.id.my_information_Certification, "field 'myInformationCertification'", TextView.class);
    target.d1 = Utils.findRequiredViewAsType(source, R.id.d1, "field 'd1'", ImageView.class);
    target.myInformationCertificationA = Utils.findRequiredViewAsType(source, R.id.my_information_Certification_a, "field 'myInformationCertificationA'", RelativeLayout.class);
    target.myInformationBankcard = Utils.findRequiredViewAsType(source, R.id.my_information_Bankcard, "field 'myInformationBankcard'", TextView.class);
    target.d2 = Utils.findRequiredViewAsType(source, R.id.d2, "field 'd2'", ImageView.class);
    target.myInformationBankcardA = Utils.findRequiredViewAsType(source, R.id.my_information_Bankcard_a, "field 'myInformationBankcardA'", RelativeLayout.class);
    target.butShoot = Utils.findRequiredViewAsType(source, R.id.but_shoot, "field 'butShoot'", Button.class);
    target.butPhoto = Utils.findRequiredViewAsType(source, R.id.but_photo, "field 'butPhoto'", Button.class);
    target.butFinish = Utils.findRequiredViewAsType(source, R.id.but_finish, "field 'butFinish'", Button.class);
    target.linearGone = Utils.findRequiredViewAsType(source, R.id.linear_gone, "field 'linearGone'", LinearLayout.class);
    target.myInformationGenderl = Utils.findRequiredViewAsType(source, R.id.my_information_genderl, "field 'myInformationGenderl'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MessageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fanhui = null;
    target.myInformationAvatar = null;
    target.myInformationAvatarA = null;
    target.myInformationName = null;
    target.a2 = null;
    target.myInformationNameA = null;
    target.myInformationGender = null;
    target.b1 = null;
    target.myInformationGenderA = null;
    target.myInformationHeight = null;
    target.myInformationBodyweight = null;
    target.myInformationAge = null;
    target.b2 = null;
    target.myInformationSign = null;
    target.myInformationMailbox = null;
    target.myInformationMailboxA = null;
    target.myInformationWeixin = null;
    target.c2 = null;
    target.myInformationWeixinA = null;
    target.myInformationCertification = null;
    target.d1 = null;
    target.myInformationCertificationA = null;
    target.myInformationBankcard = null;
    target.d2 = null;
    target.myInformationBankcardA = null;
    target.butShoot = null;
    target.butPhoto = null;
    target.butFinish = null;
    target.linearGone = null;
    target.myInformationGenderl = null;
  }
}
