package com.app.fuddu.bottomnavigationwithtablayout.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.fuddu.bottomnavigationwithtablayout.ui.home.one.OneFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.three.ThreeFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.two.TwoFragment;

public class ProfilePageAdapter extends FragmentPagerAdapter {
    int tabCount;
    public ProfilePageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            case 3:
                return new OneFragment();
            case 1:
            case 4:
                return new TwoFragment();
            case 2: return new ThreeFragment();
            default: return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
