package com.app.fuddu.bottomnavigationwithtablayout.ui.home.three;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.fuddu.bottomnavigationwithtablayout.R;

public class ThreeFragment extends Fragment {

    private ThreeViewModel mViewModel;

    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ThreeViewModel.class);
        // TODO: Use the ViewModel
    }

}