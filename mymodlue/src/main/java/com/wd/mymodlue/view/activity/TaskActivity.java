package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.LoginBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.UserSignBean;
import com.wd.mymodlue.modle.bean.UserTaskListBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.TasAdapter;
import com.wd.mymodlue.view.adapter.TaskAdapter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.bonus_sign_item_day)
    TextView bonusSignItemDay;
    @BindView(R2.id.bonus_sign_item_right)
    View bonusSignItemRight;
    @BindView(R2.id.bonus_sign_item_left2)
    View bonusSignItemLeft2;
    @BindView(R2.id.bonus_sign_item_day2)
    TextView bonusSignItemDay2;
    @BindView(R2.id.bonus_sign_item_right2)
    View bonusSignItemRight2;
    @BindView(R2.id.bonus_sign_item_left3)
    View bonusSignItemLeft3;
    @BindView(R2.id.bonus_sign_item_day3)
    TextView bonusSignItemDay3;
    @BindView(R2.id.bonus_sign_item_right3)
    View bonusSignItemRight3;
    @BindView(R2.id.bonus_sign_item_left4)
    View bonusSignItemLeft4;
    @BindView(R2.id.bonus_sign_item_day4)
    TextView bonusSignItemDay4;
    @BindView(R2.id.bonus_sign_item_right4)
    View bonusSignItemRight4;
    @BindView(R2.id.bonus_sign_item_left5)
    View bonusSignItemLeft5;
    @BindView(R2.id.bonus_sign_item_day5)
    TextView bonusSignItemDay5;
    @BindView(R2.id.bonus_sign_item_right5)
    View bonusSignItemRight5;
    @BindView(R2.id.bonus_sign_item_left6)
    View bonusSignItemLeft6;
    @BindView(R2.id.bonus_sign_item_day6)
    TextView bonusSignItemDay6;
    @BindView(R2.id.bonus_sign_item_right6)
    View bonusSignItemRight6;
    @BindView(R2.id.bonus_sign_item_left7)
    View bonusSignItemLeft7;
    @BindView(R2.id.bonus_sign_item_day7)
    TextView bonusSignItemDay7;
    @BindView(R2.id.task_linear_run)
    LinearLayout taskLinearRun;
    @BindView(R2.id.accessibility_re_list_view)
    RecyclerView accessibilityReListView;
    @BindView(R2.id.accessibility_re_list)
    RecyclerView accessibilityReList;
    private LoginBean loginBean;
    private Map<String, Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.activity_task;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        ToastUtils.init(this);
//        获取存储内容
        SPUtils login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        presenter.doFindUserSign(map);
        presenter.doHetherSignToday(map);
        presenter.doFindUserTaskList(map);
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent(TaskActivity.this,My_ModuleMainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    public void onSuccess(Object obj) {
        UserBean userBean = (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            presenter.doFindUserSign(map);

        } else {
            ToastUtils.show(userBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserSignBean userSignBean = (UserSignBean) one;
        if ("0000".equals(userSignBean.status)) {

        } else {

        }
    }

    @Override
    public void onSuccessTwo(Object two) {
        UserSignBean userSignBean = (UserSignBean) two;
        if ("0000".equals(userSignBean.status)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bonusSignItemDay.postInvalidate();
                    bonusSignItemDay2.postInvalidate();
                    bonusSignItemDay3.postInvalidate();
                    bonusSignItemDay4.postInvalidate();
                    bonusSignItemDay5.postInvalidate();
                    bonusSignItemDay6.postInvalidate();
                    bonusSignItemDay7.postInvalidate();
                    bonusSignItemRight.postInvalidate();
                    bonusSignItemRight2.postInvalidate();
                    bonusSignItemRight3.postInvalidate();
                    bonusSignItemRight4.postInvalidate();
                    bonusSignItemRight5.postInvalidate();
                    bonusSignItemRight6.postInvalidate();
                    bonusSignItemLeft2.postInvalidate();
                    bonusSignItemLeft3.postInvalidate();
                    bonusSignItemLeft4.postInvalidate();
                    bonusSignItemLeft5.postInvalidate();
                    bonusSignItemLeft6.postInvalidate();
                    bonusSignItemLeft7.postInvalidate();
                }
            }).start();
            if (userSignBean.result == 0) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight2.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight3.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);

            } else if (userSignBean.result == 1) {
                bonusSignItemDay.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight3.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
            } else if (userSignBean.result == 2) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
            } else if (userSignBean.result == 3) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay3.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
            } else if (userSignBean.result == 4) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay4.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
            } else if (userSignBean.result == 5) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay5.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
            } else if (userSignBean.result == 6) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay6.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight6.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
            } else if (userSignBean.result == 7) {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay7.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight6.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_blue);
            }else {
                bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_day_checkin);
                bonusSignItemDay7.setBackgroundResource(R.mipmap.my_task_select);
                bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                bonusSignItemRight6.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft6.setBackgroundResource(R.color.color_blue);
                bonusSignItemLeft7.setBackgroundResource(R.color.color_blue);
            }
        } else {

        }
    }

    @Override
    public void onSuccessThree(Object three) {
        UserTaskListBean userTaskListBean = (UserTaskListBean) three;
        List<UserTaskListBean.ResultBean> result = userTaskListBean.result;
        List<UserTaskListBean.ResultBean> resultBeans=new ArrayList<>();
        List<UserTaskListBean.ResultBean> resultBean=new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).taskType==1){
                resultBeans.add(result.get(i));
            }else if (result.get(i).taskType==2){
                resultBean.add(result.get(i));
            }
        }
        TaskAdapter taskAdapter=new TaskAdapter(resultBeans);
        accessibilityReListView.setLayoutManager(new LinearLayoutManager(this));
        accessibilityReListView.setAdapter(taskAdapter);
        taskAdapter.setAreaView(new TaskAdapter.AreaView() {
            @Override
            public void onCurress(int id) {
//                完成任务
                presenter.doTask(map,id);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        accessibilityReListView.postInvalidate();

                    }
                }).start();
            }

            @Override
            public void onCurre(int id) {
//                  领取H币
                presenter.doReceiveReward(map,id);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        accessibilityReListView.postInvalidate();

                    }
                }).start();

            }
        });

        TasAdapter tasAdapter=new TasAdapter(resultBean);
        accessibilityReList.setLayoutManager(new LinearLayoutManager(this));
        accessibilityReList.setAdapter(tasAdapter);
        tasAdapter.setAreaView(new TasAdapter.AreaView() {
            @Override
            public void onCurress(int id) {
//                完成任务
                presenter.doTask(map,id);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        accessibilityReList.postInvalidate();

                    }
                }).start();
            }

            @Override
            public void onCurre(int id) {
//                  领取H币
                presenter.doReceiveReward(map,id);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        accessibilityReList.postInvalidate();

                    }
                }).start();

            }
        });



    }

    @Override
    public void onSuccessFour(Object four) {
        UserBean userBean= (UserBean) four;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
        }else {
            ToastUtils.show(userBean.message);
        }
    }



    @Override
    public void onFail(String str) {

    }


}
