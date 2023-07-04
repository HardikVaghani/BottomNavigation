package com.app.fuddu.bottomnavigationwithtablayout.ui.dashboard.score;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.fuddu.bottomnavigationwithtablayout.R;

public class ScoreFragment extends Fragment {

    private ScoreViewModel mViewModel;

    public static ScoreFragment newInstance() {
        return new ScoreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        // TODO: Use the ViewModel
    }

}