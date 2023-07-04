package com.app.fuddu.bottomnavigationwithtablayout.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class NotificationsPageAdapter extends FragmentStateAdapter {

    private List<Fragment> fragments;

    public NotificationsPageAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    public NotificationsPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
        this.fragments.add(fragment);
    }

    public NotificationsPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<Fragment> fragments) {
        super(fragmentManager, lifecycle);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
