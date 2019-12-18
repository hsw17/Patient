// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SuggestAdapter$MovieViewHolder_ViewBinding implements Unbinder {
  private SuggestAdapter.MovieViewHolder target;

  @UiThread
  public SuggestAdapter$MovieViewHolder_ViewBinding(SuggestAdapter.MovieViewHolder target,
      View source) {
    this.target = target;

    target.walletImageView = Utils.findRequiredViewAsType(source, R.id.wallet_image_view, "field 'walletImageView'", SimpleDraweeView.class);
    target.walletTextName = Utils.findRequiredViewAsType(source, R.id.wallet_text_name, "field 'walletTextName'", TextView.class);
    target.walletTextTitle = Utils.findRequiredViewAsType(source, R.id.wallet_text_title, "field 'walletTextTitle'", TextView.class);
    target.walletTextBing = Utils.findRequiredViewAsType(source, R.id.wallet_text_bing, "field 'walletTextBing'", TextView.class);
    target.walletTextTime = Utils.findRequiredViewAsType(source, R.id.wallet_text_time, "field 'walletTextTime'", TextView.class);
    target.walletTextJian = Utils.findRequiredViewAsType(source, R.id.wallet_text_jian, "field 'walletTextJian'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SuggestAdapter.MovieViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.walletImageView = null;
    target.walletTextName = null;
    target.walletTextTitle = null;
    target.walletTextBing = null;
    target.walletTextTime = null;
    target.walletTextJian = null;
  }
}
