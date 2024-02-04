package com.example.project1.screen1;

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
import com.example.project1.models.ClassInfo;
import com.example.project1.screen2.AssignmentListArgs;
import com.example.project1.screen2.AssignmentListDirections;

import java.util.ArrayList;
import java.util.Date;

public class ClassList extends Fragment {

    public static ArrayList<ClassInfo> classList = new ArrayList<>();
    private com.example.project1.components.ListAdapter<ClassInfo> listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View ClassListLayout = inflater.inflate(R.layout.list_view, container, false);

        TextView textView = ClassListLayout.findViewById(R.id.textView);
        textView.setText("Class Information");

        Button addButton = ClassListLayout.findViewById(R.id.add);
        addButton.setText("Add Class");

        return ClassListLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ClassInfo c = ClassListArgs.fromBundle(getArguments()).getData();
        int index = ClassListArgs.fromBundle(getArguments()).getIndex();

        if (index != -1) {
            classList.set(index, c);
        } else if (c != null) {
            classList.add(c);
        }

        ListView listView = view.findViewById(R.id.list);
        listAdapter = new ListAdapter<>(view.getContext(), classList);
        listView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListenerInterface() {
            @Override
            public void onItemClick(int position) {
                System.out.println(position);

                ClassListDirections.ActionClassList3ToAddEditClasses3 action =
                        ClassListDirections.actionClassList3ToAddEditClasses3(position);
                NavHostFragment.findNavController(ClassList.this).navigate(action);
            }
        });

        view.findViewById(R.id.add).setOnClickListener((View v) -> {
            ClassListDirections.ActionClassList3ToAddEditClasses3 action =
                    ClassListDirections.actionClassList3ToAddEditClasses3(-1);
            NavHostFragment.findNavController(ClassList.this).navigate(action);
        });

    }
}
