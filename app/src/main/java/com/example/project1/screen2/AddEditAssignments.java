package com.example.project1.screen2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.databinding.AddEditAssignmentBinding;
import com.example.project1.models.Assignment;

import java.util.Date;

public class AddEditAssignments extends Fragment {

    private AddEditAssignmentBinding binding;

    private EditText title;
    private EditText associatedClass;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddEditAssignmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.class_input);
        associatedClass = view.findViewById(R.id.time_input);

        Button submit = view.findViewById(R.id.submit);

        int data = AddEditAssignmentsArgs.fromBundle(getArguments()).getIndex();

        if (data != -1) {
            Assignment a = AssignmentList.assignments.get(data);
            System.out.println(data);
            title.setText(a.getTitle());
            associatedClass.setText(a.getClassName());
            submit.setText("Edit");
        } else {
            submit.setText("Add");
        }

        EditText field1 = view.findViewById(R.id.class_input);
        EditText field2 = view.findViewById(R.id.time_input);
        CalendarView field3 = view.findViewById(R.id.calendar_view);

        submit.setOnClickListener(l -> {
            AddEditAssignmentsDirections.ActionAddEditAssignments2ToAssignmentList2 action =
                    AddEditAssignmentsDirections.actionAddEditAssignments2ToAssignmentList2()
                    .setData(new Assignment(field1.getText().toString(), new Date(field3.getDate()),
                            field2.getText().toString()))
                            .setIndex(data);

            NavHostFragment.findNavController(AddEditAssignments.this).navigate(action);
        });


        view.findViewById(R.id.cancel).setOnClickListener(l -> {
            NavHostFragment.findNavController(AddEditAssignments.this).navigate(
                    AddEditAssignmentsDirections.actionAddEditAssignments2ToAssignmentList2());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
