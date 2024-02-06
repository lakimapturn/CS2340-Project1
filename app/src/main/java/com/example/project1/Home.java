package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.databinding.AddEditTodoBinding;
import com.example.project1.databinding.HomeBinding;
import com.example.project1.screen4.AddEditToDo;

public class Home extends Fragment {

    private HomeBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button1 = view.findViewById(R.id.button);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.button4);

        button1.setOnClickListener(l -> {
            HomeDirections.ActionHome2ToAssignmentList action = HomeDirections.actionHome2ToAssignmentList();
            NavHostFragment.findNavController(Home.this).navigate(action);
        });

        button2.setOnClickListener(l -> {
            HomeDirections.ActionHome2ToToDoList action = HomeDirections.actionHome2ToToDoList();
            NavHostFragment.findNavController(Home.this).navigate(action);
        });

        button3.setOnClickListener(l -> {
            HomeDirections.ActionHome2ToClassList3 action = HomeDirections.actionHome2ToClassList3();
            NavHostFragment.findNavController(Home.this).navigate(action);
        });

        button4.setOnClickListener(l -> {
            HomeDirections.ActionHome2ToExamList action = HomeDirections.actionHome2ToExamList();
            NavHostFragment.findNavController(Home.this).navigate(action);
        });
    }
}
