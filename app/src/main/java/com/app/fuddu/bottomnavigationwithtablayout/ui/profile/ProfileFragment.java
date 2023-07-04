package com.app.fuddu.bottomnavigationwithtablayout.ui.profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.fuddu.bottomnavigationwithtablayout.Adapter.ProfilePageAdapter;
import com.app.fuddu.bottomnavigationwithtablayout.R;
import com.app.fuddu.bottomnavigationwithtablayout.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    private FragmentProfileBinding binding;
    private View root;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_profile, container, false);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        tabLayout = root.findViewById(R.id.profileTabLayout);
        viewPager = root.findViewById(R.id.profileViewPager);

        tabLayout.addTab(tabLayout.newTab().setText("One"));
        tabLayout.addTab(tabLayout.newTab().setText("Two"));
        tabLayout.addTab(tabLayout.newTab().setText("Three"));
        tabLayout.addTab(tabLayout.newTab().setText("Four"));
        tabLayout.addTab(tabLayout.newTab().setText("Five"));

        ProfilePageAdapter profilePageAdapter = new ProfilePageAdapter(requireActivity().getSupportFragmentManager(), 5);
        viewPager.setAdapter(profilePageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4) {
                    profilePageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}