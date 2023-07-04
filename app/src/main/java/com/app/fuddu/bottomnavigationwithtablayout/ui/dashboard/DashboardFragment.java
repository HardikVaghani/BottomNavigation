package com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.app.fuddu.bottomnavigationwithtablayout.Adapter.DashboardViewPagerAdapter;
import com.app.fuddu.bottomnavigationwithtablayout.R;
import com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.match.MatchFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.score.ScoreFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.team.TeamFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import com.app.fuddu.bottomnavigationwithtablayout.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        tabLayout = root.findViewById(R.id.dashboardTabLayout);
        viewPager2 = root.findViewById(R.id.dashboardViewPager2);


        DashboardViewPagerAdapter dashboardViewPagerAdapter = new DashboardViewPagerAdapter(getActivity());
        dashboardViewPagerAdapter.addFragment(new TeamFragment());
        dashboardViewPagerAdapter.addFragment(new MatchFragment());
        dashboardViewPagerAdapter.addFragment(new ScoreFragment());

        viewPager2.setAdapter(dashboardViewPagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("NotifyDataSetChanged")
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

        viewPager2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(@NonNull View view) {

            }

            @Override
            public void onViewDetachedFromWindow(@NonNull View view) {

            }
        });
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Team");
                    break;
                case 1:
                    tab.setText("Match");
                    break;
                case 2:
                    tab.setText("Score");
                    break;
                default:
                    break;
            }

        }).attach();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
//TeamFragment ScoreFragment MatchFragment