package com.example.project1.screen4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.R;
import com.example.project1.components.ListAdapter;
import com.example.project1.components.ToDoAdapter;
import com.example.project1.models.Assignment;
import com.example.project1.models.ToDoItem;
import com.example.project1.screen2.AssignmentList;
import com.example.project1.screen2.AssignmentListArgs;
import com.example.project1.screen2.AssignmentListDirections;

import java.util.ArrayList;

public class ToDoList extends Fragment {

    public static ArrayList<ToDoItem> todoList = new ArrayList<>();
    private ToDoAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View ToDoListLayout = inflater.inflate(R.layout.list_view, container, false);

        TextView textView = ToDoListLayout.findViewById(R.id.textView);
        textView.setText("Tasks");

        Button addButton = ToDoListLayout.findViewById(R.id.add);
        addButton.setText("Add Task");

        return ToDoListLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ToDoItem t = ToDoListArgs.fromBundle(getArguments()).getData();
        int index = ToDoListArgs.fromBundle(getArguments()).getIndex();

        if(index != -1) {
            todoList.set(index, t);
        } else if (t != null) {
            todoList.add(t);
        }

        ListView listView = view.findViewById(R.id.list);
        listAdapter = new ToDoAdapter(view.getContext(), todoList);
        listView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new ToDoAdapter.OnItemClickListenerInterface() {
            @Override
            public void onItemClick(int position) {
                System.out.println(position);

                ToDoListDirections.ActionToDoListToAddEditToDo action =
                        ToDoListDirections.actionToDoListToAddEditToDo(position);
                NavHostFragment.findNavController(ToDoList.this).navigate(action);
            }
        });

        view.findViewById(R.id.add).setOnClickListener((View v) -> {
            ToDoListDirections.ActionToDoListToAddEditToDo action =
                    ToDoListDirections.actionToDoListToAddEditToDo(-1);
            NavHostFragment.findNavController(ToDoList.this).navigate(action);
        });

    }

}
