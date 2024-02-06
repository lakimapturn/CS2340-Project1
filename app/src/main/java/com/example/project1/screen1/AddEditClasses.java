package com.example.project1.screen1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.databinding.AddEditClassBinding;
import com.example.project1.models.ClassInfo;

import java.util.Calendar;

public class AddEditClasses extends Fragment {

    private AddEditClassBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddEditClassBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText title = view.findViewById(R.id.class_input);
        EditText professorName = view.findViewById(R.id.instructor_input);
        TimePicker timePicker = view.findViewById(R.id.class_time_picker);
        Calendar time = Calendar.getInstance();

        Button submit = view.findViewById(R.id.submit);

        int data = AddEditClassesArgs.fromBundle(getArguments()).getIndex();

        if (data != -1) {
            ClassInfo c = ClassList.classList.get(data);

            title.setText(c.getCourseName());
            professorName.setText(c.getInstructor());
            timePicker.setHour(c.getTime().getHours());
            timePicker.setMinute(c.getTime().getMinutes());

            submit.setText("Edit");
        } else {
            submit.setText("Add");
        }

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener((view12, hourOfDay, minute) -> {
            time.set(Calendar.HOUR_OF_DAY, hourOfDay);
            time.set(Calendar.MINUTE, minute);
        });

        submit.setOnClickListener(l -> {
            AddEditClassesDirections.ActionAddEditClasses3ToClassList3 action =
                    AddEditClassesDirections.actionAddEditClasses3ToClassList3()
                            .setData(new ClassInfo(title.getText().toString(), time.getTime(),
                                    professorName.getText().toString()))
                            .setIndex(data);

            NavHostFragment.findNavController(AddEditClasses.this).navigate(action);
        });


        view.findViewById(R.id.cancel).setOnClickListener(l -> {
            NavHostFragment.findNavController(AddEditClasses.this).navigate(
                    AddEditClassesDirections.actionAddEditClasses3ToClassList3());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
