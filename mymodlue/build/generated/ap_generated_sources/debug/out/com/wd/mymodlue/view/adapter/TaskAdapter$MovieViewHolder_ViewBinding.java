// Generated code from Butter Knife. Do not modify!
package com.wd.mymodlue.view.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.wd.mymodlue.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskAdapter$MovieViewHolder_ViewBinding implements Unbinder {
  private TaskAdapter.MovieViewHolder target;

  @UiThread
  public TaskAdapter$MovieViewHolder_ViewBinding(TaskAdapter.MovieViewHolder target, View source) {
    this.target = target;

    target.textName = Utils.findRequiredViewAsType(source, R.id.text_name, "field 'textName'", TextView.class);
    target.textHb = Utils.findRequiredViewAsType(source, R.id.text_hb, "field 'textHb'", TextView.class);
    target.firstButtonFinish = Utils.findRequiredViewAsType(source, R.id.first_button_finish, "field 'firstButtonFinish'", Button.class);
    target.firstButtonGoFinish = Utils.findRequiredViewAsType(source, R.id.first_button_go_finish, "field 'firstButtonGoFinish'", Button.class);
    target.collarButtonGoFinish = Utils.findRequiredViewAsType(source, R.id.collar_button_go_finish, "field 'collarButtonGoFinish'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskAdapter.MovieViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textName = null;
    target.textHb = null;
    target.firstButtonFinish = null;
    target.firstButtonGoFinish = null;
    target.collarButtonGoFinish = null;
  }
}
