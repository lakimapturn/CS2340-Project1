package com.example.project1.screen1;

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
import com.example.project1.components.TimePicker;
import com.example.project1.databinding.AddEditAssignmentBinding;
import com.example.project1.databinding.AddEditClassBinding;
import com.example.project1.models.Assignment;
import com.example.project1.models.ClassInfo;
import com.example.project1.models.Exam;
import com.example.project1.screen2.AddEditAssignmentsArgs;
import com.example.project1.screen2.AddEditAssignmentsDirections;
import com.example.project1.screen2.AssignmentList;
import com.example.project1.screen3.AddEditExams;
import com.example.project1.screen3.AddEditExamsDirections;

import java.util.Date;

public class AddEditClasses extends Fragment {

    private AddEditAssignmentBinding binding;

    private EditText title;
    private EditText professorName;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddEditAssignmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.class_input);
        professorName = view.findViewById(R.id.time_input);

        Button submit = view.findViewById(R.id.submit);

        int data = AddEditAssignmentsArgs.fromBundle(getArguments()).getIndex();

        if (data != -1) {
            Assignment a = AssignmentList.assignments.get(data);
            System.out.println(data);
            title.setText(a.getTitle());
            professorName.setText(a.getClassName());
            submit.setText("Edit");
        } else {
            submit.setText("Add");
        }

        EditText field1 = view.findViewById(R.id.class_input);
        EditText field2 = view.findViewById(R.id.time_input);
        EditText field3 = view.findViewById(R.id.instructor_input);

        submit.setOnClickListener(l -> {
//            AddEditClassesDirections.ActionAddEditClasses2ToClassList2 action =
//                    AddEditClassesDirections.actionAddEditClasses2ToExamList2()
//                            .setData(new ClassInfo(field1.getText().toString(), -------,
//                                    field3.getText().toString()))
//                            .setIndex(data);
//
//            NavHostFragment.findNavController(AddEditClasses.this).navigate(action);
        });


//        view.findViewById(R.id.cancel).setOnClickListener(l -> {
//            NavHostFragment.findNavController(AddEditClasses.this).navigate(
////                    AddEditClassesDirections.actionAddEditClasses2ToClassList2());
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
