package com.example.project1.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project1.R;
import com.example.project1.models.Assignment;
import com.example.project1.models.ClassInfo;
import com.example.project1.models.Exam;
import com.example.project1.models.ToDoItem;

public class ToDoAdapter extends ArrayAdapter<ToDoItem> {

    ArrayList<ToDoItem> list;
    Context context;

    private OnItemClickListenerInterface onItemClickListener;

    public ToDoAdapter(@NonNull Context context, ArrayList<ToDoItem> list) {
        super(context, R.layout.list_item, list);
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListenerInterface listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ToDoItem item = getItem(position);

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.todo_item, parent, false);
        }

        TextView field1 = view.findViewById(R.id.title);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
        Button delete = view.findViewById(R.id.complete_button);
        delete.setOnClickListener(l -> {
            list.remove(position);
            notifyDataSetChanged();
            System.out.println(list);
        });
        field1.setText(item.getTask());

        return view;
    }

    public interface OnItemClickListenerInterface {
        void onItemClick(int position);
    }
}
