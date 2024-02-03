package com.example.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project1.components.ListAdapter;
import com.example.project1.models.Assignment;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<Assignment> list = new ArrayList<>();
    ListAdapter<Assignment> listAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Assignments");

        list.add(new Assignment("Example1", new Date(), "12345"));
        list.add(new Assignment("Example2", new Date(), "12345"));
        list.add(new Assignment("Example3", new Date(), "12345"));
        list.add(new Assignment("Example4", new Date(), "12345"));

        ListView listView = findViewById(R.id.list);
        listAdapter = new ListAdapter<>(MainActivity.this, list);
        ListAdapter<Assignment> customBaseAdapter = new ListAdapter<>(getApplicationContext(), list);
        listView.setAdapter(customBaseAdapter);
    }
}
