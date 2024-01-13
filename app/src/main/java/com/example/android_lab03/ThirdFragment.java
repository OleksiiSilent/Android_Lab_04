package com.example.android_lab03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.android_lab03.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThirdNext.setOnClickListener(view12 -> NavHostFragment.findNavController(ThirdFragment.this)
                .navigate(R.id.action_ThirdFragment_to_FirstFragment));

        binding.buttonThirdPrevious.setOnClickListener(view1 -> NavHostFragment.findNavController(ThirdFragment.this)
                .navigate(R.id.action_ThirdFragment_to_SecondFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
