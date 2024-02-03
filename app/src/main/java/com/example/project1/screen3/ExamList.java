package com.example.project1.screen3;

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
import com.example.project1.models.Exam;

import java.util.ArrayList;
import java.util.Date;

public class ExamList extends Fragment {

    public static ArrayList<Exam> Exams = new ArrayList<>();
    private com.example.project1.components.ListAdapter<Exam> listAdapter;

    public ExamList() {
//        Exams.add(new Exam("Example1", new Date(), "12345"));
//        Exams.add(new Exam("Example2", new Date(), "12345"));
//        Exams.add(new Exam("Example3", new Date(), "12345"));
//        Exams.add(new Exam("Example4", new Date(), "12345"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View ExamListLayout = inflater.inflate(R.layout.list_view, container, false);

        TextView textView = ExamListLayout.findViewById(R.id.textView);
        textView.setText("Exams");

        Button addButton = ExamListLayout.findViewById(R.id.add);
        addButton.setText("Add Exam");

        return ExamListLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Exam a = ExamListArgs.fromBundle(getArguments()).getData();
        int index = ExamListArgs.fromBundle(getArguments()).getIndex();

        if(index != -1) {
            Exams.set(index, a);
        } else if (a != null) {
            Exams.add(a);
        }

        ListView listView = view.findViewById(R.id.list);
        listAdapter = new ListAdapter<>(view.getContext(), Exams);
        listView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListenerInterface() {
            @Override
            public void onItemClick(int position) {
                System.out.println(position);

                ExamListDirections.ActionExamList2ToAddEditExams2 action =
                        ExamListDirections.actionExamList2ToAddEditExams2(position);
                NavHostFragment.findNavController(ExamList.this).navigate(action);
            }
        });

        view.findViewById(R.id.add).setOnClickListener((View v) -> {
            ExamListDirections.ActionExamList2ToAddEditExams2 action =
                    ExamListDirections.actionExamList2ToAddEditExams2(-1);
            NavHostFragment.findNavController(ExamList.this).navigate(action);
        });

    }
}
