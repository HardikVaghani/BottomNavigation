package com.app.fuddu.bottomnavigationwithtablayout.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.app.fuddu.bottomnavigationwithtablayout.Adapter.HomeViewPagerAdapter;
import com.app.fuddu.bottomnavigationwithtablayout.Adapter.NotificationsPageAdapter;
import com.app.fuddu.bottomnavigationwithtablayout.R;
import com.app.fuddu.bottomnavigationwithtablayout.databinding.FragmentNotificationsBinding;
import com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.match.MatchFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.score.ScoreFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.team.TeamFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.one.OneFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.three.ThreeFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.two.TwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        tabLayout = root.findViewById(R.id.notificationTabLayout);
        viewPager2 = root.findViewById(R.id.notificationViewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("One"));
        tabLayout.addTab(tabLayout.newTab().setText("Two"));
        tabLayout.addTab(tabLayout.newTab().setText("Three"));
        tabLayout.addTab(tabLayout.newTab().setText("Four"));
        tabLayout.addTab(tabLayout.newTab().setText("Five"));
        tabLayout.addTab(tabLayout.newTab().setText("Six"));
        tabLayout.addTab(tabLayout.newTab().setText("Seven"));
        tabLayout.addTab(tabLayout.newTab().setText("Eight"));
        tabLayout.addTab(tabLayout.newTab().setText("Nine"));
        tabLayout.addTab(tabLayout.newTab().setText("Ten"));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new TeamFragment());
        fragments.add(new ScoreFragment());
        fragments.add(new TwoFragment());
        fragments.add(new OneFragment());
        fragments.add(new MatchFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new MatchFragment());

        NotificationsPageAdapter notificationsPageAdapter = new NotificationsPageAdapter(requireActivity().getSupportFragmentManager(), requireActivity().getLifecycle(), fragments);
        viewPager2.setAdapter(notificationsPageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}