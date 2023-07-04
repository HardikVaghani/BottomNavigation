package com.app.fuddu.bottomnavigationwithtablayout.ui.home;

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

import com.app.fuddu.bottomnavigationwithtablayout.Adapter.HomeViewPagerAdapter;
import com.app.fuddu.bottomnavigationwithtablayout.R;
import com.app.fuddu.bottomnavigationwithtablayout.databinding.FragmentHomeBinding;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.one.OneFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.three.ThreeFragment;
import com.app.fuddu.bottomnavigationwithtablayout.ui.home.two.TwoFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        tabLayout = root.findViewById(R.id.homeTabLayout);
        viewPager2 = root.findViewById(R.id.homeViewPager2);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());

//        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(requireActivity(), fragments);
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(requireActivity().getSupportFragmentManager(), requireActivity().getLifecycle(),fragments);
        viewPager2.setAdapter(homeViewPagerAdapter);

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

        // Connect ViewPager2 with TabLayout
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