package com.example.project1.screen2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.databinding.AddEditAssignmentBinding;

import java.util.Random;

public class AddEditAssignments extends Fragment {

    private AddEditAssignmentBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddEditAssignmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        boolean editing = AddEditAssignmentsArgs.fromBundle(getArguments()).getEditing();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
