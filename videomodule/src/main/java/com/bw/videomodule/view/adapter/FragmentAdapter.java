package com.bw.videomodule.view.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> tablist;

    public FragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, List<String> tablist) {
        super ( fm );
        this.fragmentList = fragmentList;
        this.tablist = tablist;
    }

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList, List<String> tablist) {
        super ( fm, behavior );
        this.fragmentList = fragmentList;
        this.tablist = tablist;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get ( i );
    }

    @Override
    public int getCount() {
        return fragmentList.size ();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return tablist.get ( position );
    }
}
