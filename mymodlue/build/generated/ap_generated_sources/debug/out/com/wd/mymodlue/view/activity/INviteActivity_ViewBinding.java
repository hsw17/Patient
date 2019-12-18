// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class INviteActivity_ViewBinding implements Unbinder {
  private INviteActivity target;

  @UiThread
  public INviteActivity_ViewBinding(INviteActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public INviteActivity_ViewBinding(INviteActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.headTextName = Utils.findRequiredViewAsType(source, R.id.head_text_name, "field 'headTextName'", TextView.class);
    target.relayLayout = Utils.findRequiredViewAsType(source, R.id.relay_layout, "field 'relayLayout'", RelativeLayout.class);
    target.inviteEditCode = Utils.findRequiredViewAsType(source, R.id.invite_edit_code, "field 'inviteEditCode'", EditText.class);
    target.inviteButtonCode = Utils.findRequiredViewAsType(source, R.id.invite_button_code, "field 'inviteButtonCode'", LinearLayout.class);
    target.inviteSimplView = Utils.findRequiredViewAsType(source, R.id.invite_simpl_view, "field 'inviteSimplView'", SimpleDraweeView.class);
    target.inviteButtonFriend = Utils.findRequiredViewAsType(source, R.id.invite_button_friend, "field 'inviteButtonFriend'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    INviteActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.headTextName = null;
    target.relayLayout = null;
    target.inviteEditCode = null;
    target.inviteButtonCode = null;
    target.inviteSimplView = null;
    target.inviteButtonFriend = null;
  }
}
