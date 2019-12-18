// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WalletActivity_ViewBinding implements Unbinder {
  private WalletActivity target;

  @UiThread
  public WalletActivity_ViewBinding(WalletActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WalletActivity_ViewBinding(WalletActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.headTextName = Utils.findRequiredViewAsType(source, R.id.head_text_name, "field 'headTextName'", TextView.class);
    target.wallTextPrice = Utils.findRequiredViewAsType(source, R.id.wall_text_price, "field 'wallTextPrice'", TextView.class);
    target.wallButtonLeft = Utils.findRequiredViewAsType(source, R.id.wall_button_left, "field 'wallButtonLeft'", Button.class);
    target.wallButtonRight = Utils.findRequiredViewAsType(source, R.id.wall_button_right, "field 'wallButtonRight'", Button.class);
    target.wallListView = Utils.findRequiredViewAsType(source, R.id.wall_list_view, "field 'wallListView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WalletActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.headTextName = null;
    target.wallTextPrice = null;
    target.wallButtonLeft = null;
    target.wallButtonRight = null;
    target.wallListView = null;
  }
}
