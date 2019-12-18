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

public class TaskActivity_ViewBinding implements Unbinder {
  private TaskActivity target;

  @UiThread
  public TaskActivity_ViewBinding(TaskActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskActivity_ViewBinding(TaskActivity target, View source) {
    this.target = target;

    target.headDetailsBack = Utils.findRequiredViewAsType(source, R.id.head_details_back, "field 'headDetailsBack'", ImageView.class);
    target.bonusSignItemDay = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day, "field 'bonusSignItemDay'", TextView.class);
    target.bonusSignItemRight = Utils.findRequiredView(source, R.id.bonus_sign_item_right, "field 'bonusSignItemRight'");
    target.bonusSignItemLeft2 = Utils.findRequiredView(source, R.id.bonus_sign_item_left2, "field 'bonusSignItemLeft2'");
    target.bonusSignItemDay2 = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day2, "field 'bonusSignItemDay2'", TextView.class);
    target.bonusSignItemRight2 = Utils.findRequiredView(source, R.id.bonus_sign_item_right2, "field 'bonusSignItemRight2'");
    target.bonusSignItemLeft3 = Utils.findRequiredView(source, R.id.bonus_sign_item_left3, "field 'bonusSignItemLeft3'");
    target.bonusSignItemDay3 = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day3, "field 'bonusSignItemDay3'", TextView.class);
    target.bonusSignItemRight3 = Utils.findRequiredView(source, R.id.bonus_sign_item_right3, "field 'bonusSignItemRight3'");
    target.bonusSignItemLeft4 = Utils.findRequiredView(source, R.id.bonus_sign_item_left4, "field 'bonusSignItemLeft4'");
    target.bonusSignItemDay4 = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day4, "field 'bonusSignItemDay4'", TextView.class);
    target.bonusSignItemRight4 = Utils.findRequiredView(source, R.id.bonus_sign_item_right4, "field 'bonusSignItemRight4'");
    target.bonusSignItemLeft5 = Utils.findRequiredView(source, R.id.bonus_sign_item_left5, "field 'bonusSignItemLeft5'");
    target.bonusSignItemDay5 = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day5, "field 'bonusSignItemDay5'", TextView.class);
    target.bonusSignItemRight5 = Utils.findRequiredView(source, R.id.bonus_sign_item_right5, "field 'bonusSignItemRight5'");
    target.bonusSignItemLeft6 = Utils.findRequiredView(source, R.id.bonus_sign_item_left6, "field 'bonusSignItemLeft6'");
    target.bonusSignItemDay6 = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day6, "field 'bonusSignItemDay6'", TextView.class);
    target.bonusSignItemRight6 = Utils.findRequiredView(source, R.id.bonus_sign_item_right6, "field 'bonusSignItemRight6'");
    target.bonusSignItemLeft7 = Utils.findRequiredView(source, R.id.bonus_sign_item_left7, "field 'bonusSignItemLeft7'");
    target.bonusSignItemDay7 = Utils.findRequiredViewAsType(source, R.id.bonus_sign_item_day7, "field 'bonusSignItemDay7'", TextView.class);
    target.taskLinearRun = Utils.findRequiredViewAsType(source, R.id.task_linear_run, "field 'taskLinearRun'", LinearLayout.class);
    target.accessibilityReListView = Utils.findRequiredViewAsType(source, R.id.accessibility_re_list_view, "field 'accessibilityReListView'", RecyclerView.class);
    target.accessibilityReList = Utils.findRequiredViewAsType(source, R.id.accessibility_re_list, "field 'accessibilityReList'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headDetailsBack = null;
    target.bonusSignItemDay = null;
    target.bonusSignItemRight = null;
    target.bonusSignItemLeft2 = null;
    target.bonusSignItemDay2 = null;
    target.bonusSignItemRight2 = null;
    target.bonusSignItemLeft3 = null;
    target.bonusSignItemDay3 = null;
    target.bonusSignItemRight3 = null;
    target.bonusSignItemLeft4 = null;
    target.bonusSignItemDay4 = null;
    target.bonusSignItemRight4 = null;
    target.bonusSignItemLeft5 = null;
    target.bonusSignItemDay5 = null;
    target.bonusSignItemRight5 = null;
    target.bonusSignItemLeft6 = null;
    target.bonusSignItemDay6 = null;
    target.bonusSignItemRight6 = null;
    target.bonusSignItemLeft7 = null;
    target.bonusSignItemDay7 = null;
    target.taskLinearRun = null;
    target.accessibilityReListView = null;
    target.accessibilityReList = null;
  }
}
