package com.geeks.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NextFragment extends Fragment {

    private TextView textResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();


    }


    private void initListener(){
        Bundle bundle = getArguments();
        if (bundle != null) {
            int number = bundle.getInt("number", 0);
            textResult.setText(String.valueOf(number));
        }
    }
    private void initView(View view) {
        textResult = view.findViewById(R.id.textResult);
    }
}