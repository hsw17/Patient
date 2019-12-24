package com.wd.mymodlue.view.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * date:2019/9/28
 * author:贺少伟(盗)
 * function:
 */
public class FragAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> slist;

    public FragAdapter(@NonNull FragmentManager fm, List<Fragment> list, List<String> slist) {
        super(fm);
        this.list = list;
        this.slist = slist;
    }



    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position%list.size());
    }
}
