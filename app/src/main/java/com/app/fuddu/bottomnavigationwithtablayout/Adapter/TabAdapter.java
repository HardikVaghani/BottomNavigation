package com.app.fuddu.bottomnavigationwithtablayout.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStateAdapter {
    private static final List<Fragment> fragmentList = new ArrayList<>();
    private static final List<String> fragmentTitleList = new ArrayList<>();

    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public static void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Return a unique identifier for each fragment
        return fragmentList.get(position).hashCode();
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    @Override
    public boolean containsItem(long itemId) {
        // Check if the adapter contains a fragment with the given identifier
        for (Fragment fragment : fragmentList) {
            if (fragment.hashCode() == itemId) {
                return true;
            }
        }
        return false;
    }

    public static CharSequence getTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
