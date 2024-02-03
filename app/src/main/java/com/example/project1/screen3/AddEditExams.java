package com.example.project1.screen3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.databinding.AddEditExamBinding;
import com.example.project1.models.Exam;

import java.util.Calendar;
import java.util.Date;

public class AddEditExams extends Fragment {

    private AddEditExamBinding binding;

    private EditText location;
    private Calendar dateTime = Calendar.getInstance();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddEditExamBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        location = view.findViewById(R.id.location_input);

        Button submit = view.findViewById(R.id.submit);
        CalendarView calendarView = view.findViewById(R.id.calender_view);
        TimePicker timePicker = view.findViewById(R.id.time_picker);

        int data = AddEditExamsArgs.fromBundle(getArguments()).getIndex();

        if (data != -1) {
            Exam a = ExamList.Exams.get(data);
            System.out.println(data);
            location.setText(a.getLocation());
            submit.setText("Edit");
        } else {
            submit.setText("Add");
        }

        EditText field1 = location;

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, month);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        });

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener((view12, hourOfDay, minute) -> {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
        });

        submit.setOnClickListener(l -> {
            AddEditExamsDirections.ActionAddEditExams2ToExamList2 action =
                    AddEditExamsDirections.actionAddEditExams2ToExamList2()
                            .setData(new Exam(dateTime.getTime(), field1.getText().toString()))
                            .setIndex(data);

            NavHostFragment.findNavController(AddEditExams.this).navigate(action);
        });

        view.findViewById(R.id.cancel).setOnClickListener(l -> {
            NavHostFragment.findNavController(AddEditExams.this).navigate(
                    AddEditExamsDirections.actionAddEditExams2ToExamList2());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
