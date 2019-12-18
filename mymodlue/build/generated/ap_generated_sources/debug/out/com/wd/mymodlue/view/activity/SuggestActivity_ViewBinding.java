// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SuggestActivity_ViewBinding implements Unbinder {
  private SuggestActivity target;

  @UiThread
  public SuggestActivity_ViewBinding(SuggestActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SuggestActivity_ViewBinding(SuggestActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.headTextName = Utils.findRequiredViewAsType(source, R.id.head_text_name, "field 'headTextName'", TextView.class);
    target.recordLinearLayout = Utils.findRequiredViewAsType(source, R.id.record_linear_layout, "field 'recordLinearLayout'", LinearLayout.class);
    target.suggestListView = Utils.findRequiredViewAsType(source, R.id.suggest_list_view, "field 'suggestListView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SuggestActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.headTextName = null;
    target.recordLinearLayout = null;
    target.suggestListView = null;
  }
}
