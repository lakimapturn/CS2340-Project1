package com.example.project1.screen2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import java.util.Date;

public class AssignmentList extends Fragment {

    public static ArrayList<Assignment> assignments = new ArrayList<>();
    private com.example.project1.components.ListAdapter<Assignment> listAdapter;

    public AssignmentList() {
//        assignments.add(new Assignment("Example1", new Date(), "12345"));
//        assignments.add(new Assignment("Example2", new Date(), "12345"));
//        assignments.add(new Assignment("Example3", new Date(), "12345"));
//        assignments.add(new Assignment("Example4", new Date(), "12345"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View AssignmentListLayout = inflater.inflate(R.layout.list_view, container, false);

        TextView textView = AssignmentListLayout.findViewById(R.id.textView);
        textView.setText("Assignments");

        Button addButton = AssignmentListLayout.findViewById(R.id.add);
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

        ListView listView = view.findViewById(R.id.list);
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

        view.findViewById(R.id.add).setOnClickListener((View v) -> {
            AssignmentListDirections.ActionAssignmentList2ToAddEditAssignments2 action =
                    AssignmentListDirections.actionAssignmentList2ToAddEditAssignments2(-1);
            NavHostFragment.findNavController(AssignmentList.this).navigate(action);
        });

    }
}
