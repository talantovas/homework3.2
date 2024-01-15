package com.geeks.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainFragment extends Fragment {
    private TextView textView;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button nextFragment;

    private int number = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private void initView(View view) {
        textView = view.findViewById(R.id.textView);
        buttonPlus = view.findViewById(R.id.buttonPlus);
        buttonMinus = view.findViewById(R.id.buttonMinus);
        textView.setText(String.valueOf(number));
        nextFragment = view.findViewById(R.id.nextFragment);
    }

    private void initListener() {
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                updateTextView();
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number--;
                updateTextView();
            }
        });
        nextFragment.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt(MainActivity.KEY1, number);
            NextFragment nextFragment = new NextFragment();
            nextFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, nextFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void updateTextView() {
        textView.setText(String.valueOf(number));
    }
}