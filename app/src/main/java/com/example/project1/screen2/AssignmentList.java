package com.example.project1.screen2;

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
import com.example.project1.models.Assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AssignmentList extends Fragment {

    public static ArrayList<Assignment> assignments = new ArrayList<>();
    private com.example.project1.components.ListAdapter<Assignment> listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View AssignmentListLayout = inflater.inflate(R.layout.assignments_view, container, false);

        TextView textView = AssignmentListLayout.findViewById(R.id.assignment_title);
        textView.setText("Assignments");

        Button addButton = AssignmentListLayout.findViewById(R.id.add_assignment);
        addButton.setText("Add Assignment");

        return AssignmentListLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Assignment a = AssignmentListArgs.fromBundle(getArguments()).getData();
        int index = AssignmentListArgs.fromBundle(getArguments()).getIndex();

        if(index != -1) {
            assignments.set(index, a);
        } else if (a != null) {
            assignments.add(a);
        }

        ListView listView = view.findViewById(R.id.assignments_list);
        listAdapter = new ListAdapter<>(view.getContext(), assignments);
        listView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListenerInterface() {
            @Override
            public void onItemClick(int position) {
                System.out.println(position);

                AssignmentListDirections.ActionAssignmentList2ToAddEditAssignments2 action =
                        AssignmentListDirections.actionAssignmentList2ToAddEditAssignments2(position);
                NavHostFragment.findNavController(AssignmentList.this).navigate(action);
            }
        });

        view.findViewById(R.id.add_assignment).setOnClickListener((View v) -> {
            AssignmentListDirections.ActionAssignmentList2ToAddEditAssignments2 action =
                    AssignmentListDirections.actionAssignmentList2ToAddEditAssignments2(-1);
            NavHostFragment.findNavController(AssignmentList.this).navigate(action);
        });

        view.findViewById(R.id.sort_date).setOnClickListener((View v) -> {
            Collections.sort(assignments);
            listAdapter = new ListAdapter<>(view.getContext(), assignments);
            listView.setAdapter(listAdapter);
        });

    }
}
