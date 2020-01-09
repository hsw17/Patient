package com.wd.he_home.adapter;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * date:2019/10/11
 * author:贺少伟(盗)
 * function:
 */
public class ViewAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public ViewAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
