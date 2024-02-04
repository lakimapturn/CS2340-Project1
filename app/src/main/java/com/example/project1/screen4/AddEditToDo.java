package com.example.project1.screen4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.databinding.AddEditTodoBinding;
import com.example.project1.models.Assignment;
import com.example.project1.models.ToDoItem;
import com.example.project1.screen2.AddEditAssignments;
import com.example.project1.screen2.AddEditAssignmentsArgs;

public class AddEditToDo extends Fragment {
    private AddEditTodoBinding binding;

    private EditText task;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddEditTodoBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView title = view.findViewById(R.id.title_input);

        Button submit = view.findViewById(R.id.submit);

        int data = AddEditAssignmentsArgs.fromBundle(getArguments()).getIndex();

        if (data != -1) {
            ToDoItem t = ToDoList.todoList.get(data);
            System.out.println(data);
            title.setText(t.getTask());
            submit.setText("Edit");
        } else {
            submit.setText("Add");
        }

        EditText field1 = view.findViewById(R.id.title_input);
        CalendarView field3 = view.findViewById(R.id.calendar_view);

        submit.setOnClickListener(l -> {
            AddEditToDoDirections.ActionAddEditToDoToToDoList action =
                    AddEditToDoDirections.actionAddEditToDoToToDoList()
                            .setData(new ToDoItem(field1.getText().toString()))
                            .setIndex(data);

            NavHostFragment.findNavController(AddEditToDo.this).navigate(action);
        });

        view.findViewById(R.id.cancel).setOnClickListener(l -> {
            NavHostFragment.findNavController(AddEditToDo.this).navigate(
                    ToDoListDirections.actionToDoListToAddEditToDo(data));
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
