package com.example.project1.screen1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project1.R;
import com.example.project1.components.ListAdapter;
import com.example.project1.models.Assignment;
import com.example.project1.models.ClassInfo;

import java.util.ArrayList;
import java.util.Date;

public class ClassList extends AppCompatActivity {

    ArrayList<ClassInfo> list = new ArrayList<>();
    ListAdapter<ClassInfo> listAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Class List");

        ListView listView = findViewById(R.id.list);
        listAdapter = new ListAdapter<>(ClassList.this, list);
        ListAdapter<ClassInfo> customBaseAdapter = new ListAdapter<>(getApplicationContext(), list);
        listView.setAdapter(customBaseAdapter);
    }
}
