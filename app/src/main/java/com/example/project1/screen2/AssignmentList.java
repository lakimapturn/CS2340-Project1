package com.example.project1.screen2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.project1.MainActivity;
import com.example.project1.R;
import com.example.project1.components.ListAdapter;
import com.example.project1.models.Assignment;

import java.util.ArrayList;
import java.util.Date;

public class AssignmentList extends Fragment {

    public ArrayList<Assignment> list = new ArrayList<>();
    private ListAdapter<Assignment> listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View AssignmentListLayout = inflater.inflate(R.layout.list_view, container, false);

        TextView textView = AssignmentListLayout.findViewById(R.id.textView);
        textView.setText("Assignments");

        Button addButton = AssignmentListLayout.findViewById(R.id.add);
        textView.setText("Add Assignment");

        return AssignmentListLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list.add(new Assignment("Example1", new Date(), "12345"));
        list.add(new Assignment("Example2", new Date(), "12345"));
        list.add(new Assignment("Example3", new Date(), "12345"));
        list.add(new Assignment("Example4", new Date(), "12345"));

        ListView listView = view.findViewById(R.id.list);
        listAdapter = new ListAdapter<>(view.getContext(), list);
        listView.setAdapter(listAdapter);

        view.findViewById(R.id.edit).setOnClickListener((View v) -> {
            // TODO: how to check which list item was clicked
            AssignmentListDirections.ActionAssignmentList2ToAddEditAssignments2 action =
                    AssignmentListDirections.actionAssignmentList2ToAddEditAssignments2(null);
            NavHostFragment.findNavController(AssignmentList.this).navigate(action);
        });

        view.findViewById(R.id.add).setOnClickListener((View v) -> {
            AssignmentListDirections.ActionAssignmentList2ToAddEditAssignments2 action =
                    AssignmentListDirections.actionAssignmentList2ToAddEditAssignments2(null);
            NavHostFragment.findNavController(AssignmentList.this).navigate(action);
        });

    }
}
