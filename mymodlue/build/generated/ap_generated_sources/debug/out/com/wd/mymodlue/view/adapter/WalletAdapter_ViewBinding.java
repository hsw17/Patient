// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WalletAdapter_ViewBinding implements Unbinder {
  private WalletAdapter target;

  @UiThread
  public WalletAdapter_ViewBinding(WalletAdapter target, View source) {
    this.target = target;

    target.walleTextName = Utils.findRequiredViewAsType(source, R.id.walle_text_name, "field 'walleTextName'", TextView.class);
    target.walleTextTime = Utils.findRequiredViewAsType(source, R.id.walle_text_time, "field 'walleTextTime'", TextView.class);
    target.walleTextManay = Utils.findRequiredViewAsType(source, R.id.walle_text_manay, "field 'walleTextManay'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WalletAdapter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.walleTextName = null;
    target.walleTextTime = null;
    target.walleTextManay = null;
  }
}
