package com.example.project1.screen3;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project1.R;
import com.example.project1.components.ListAdapter;
import com.example.project1.models.Exam;

import java.util.ArrayList;

public class ExamList extends AppCompatActivity {

    ArrayList<Exam> list = new ArrayList<>();
    ListAdapter<Exam> listAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Exam Information");

        ListView listView = findViewById(R.id.list);
        listAdapter = new ListAdapter<>(ExamList.this, list);
        ListAdapter<Exam> customBaseAdapter = new ListAdapter<>(getApplicationContext(), list);
        listView.setAdapter(customBaseAdapter);
    }
}