package com.app.fuddu.bottomnavigationwithtablayout.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter2 extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public TabAdapter2(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();//jetla tab che tatla j number deavana che(chat,call,status)return ma

    }

    //ahiya title set thay che (indexing 0 thi thay che)
    @Override
    public CharSequence getPageTitle(int position) {
        /*        return super.getPageTitle(position);*/
        return fragmentTitleList.get(position);
    }

    public CharSequence getTitle(int position) {
        return fragmentTitleList.get(position);
    }
}//have main ma