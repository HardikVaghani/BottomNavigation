package com.app.fuddu.bottomnavigationwithtablayout.ui.home.two;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.fuddu.bottomnavigationwithtablayout.R;

public class TwoFragment extends Fragment {

    private TwoViewModel mViewModel;

    public static TwoFragment newInstance() {
        return new TwoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TwoViewModel.class);
        // TODO: Use the ViewModel
    }

}