// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BrightnessActivity_ViewBinding implements Unbinder {
  private BrightnessActivity target;

  @UiThread
  public BrightnessActivity_ViewBinding(BrightnessActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BrightnessActivity_ViewBinding(BrightnessActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.headTextName = Utils.findRequiredViewAsType(source, R.id.head_text_name, "field 'headTextName'", TextView.class);
    target.relayLayout = Utils.findRequiredViewAsType(source, R.id.relay_layout, "field 'relayLayout'", RelativeLayout.class);
    target.screenSeekbar = Utils.findRequiredViewAsType(source, R.id.screen_seekbar, "field 'screenSeekbar'", SeekBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BrightnessActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.headTextName = null;
    target.relayLayout = null;
    target.screenSeekbar = null;
  }
}
