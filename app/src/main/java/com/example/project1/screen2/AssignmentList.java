package com.example.project1.screen2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project1.R;
import com.example.project1.components.ListAdapter;
import com.example.project1.models.Assignment;

import java.util.ArrayList;

public class AssignmentList extends AppCompatActivity {

    ArrayList<Assignment> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
