package com.wd.he_home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bwie.mvplibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.wd.he_home.R;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.fragment.changjian.CommonDrugsFragment;
import com.wd.he_home.fragment.changjian.CommonSymptomsFragment;
import com.wd.he_home.presenter.HomePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：CommonActivity 常见病症，常见药品  第一个
 * @data（日期）: 2019/12/16
 * @time（时间）: 9:06
 * @author（作者）: Liuhe
 **/
public class CommonActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {

    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;
    private ViewPager commonVp;
    private TabLayout CommonTables;

    private EditText editText;

    @Override
    protected int bindLayout() {
        return R.layout.activity_common;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        editText = findViewById(R.id.comm_edit_shu);
        commonVp = findViewById(R.id.common_vp);
        CommonTables = findViewById(R.id.common_tables);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommonActivity.this, SearchPageActivity.class));
            }
        });
        strings = new ArrayList<>();
        strings.add("常见病症");
        strings.add("常见药品");
        fragments = new ArrayList<>();
        fragments.add(new CommonSymptomsFragment());
        fragments.add(new CommonDrugsFragment());
        //设置适配器
        commonVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        //设置联动
        CommonTables.setupWithViewPager(commonVp);
        Intent intent = getIntent();
        int one = Integer.parseInt(intent.getStringExtra("one"));
        if (one == 0) {
            CommonTables.getTabAt(0).select();
        } else if (one == 1) {
            CommonTables.getTabAt(1).select();
        }
    }

    @Override
    public void HomeViewSuccess(Object obj) {
    }

    @Override
    public void HomeViewError(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.common_tables) {
        } else if (id == R.id.common_vp) {
        }
    }
}
