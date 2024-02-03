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

public class ListAdapter<T> extends ArrayAdapter<T> {

    ArrayList<T> list;
    Context context;

    private OnItemClickListenerInterface onItemClickListener;

    public ListAdapter(@NonNull Context context, ArrayList<T> list) {
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
        T item = getItem(position);

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView field1 = view.findViewById(R.id.title);
        TextView field2 = view.findViewById(R.id.textfield2);
        TextView field3 = view.findViewById(R.id.textfield3);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
        Button delete = view.findViewById(R.id.delete_button);
        delete.setOnClickListener(l -> {
            list.remove(position);
            notifyDataSetChanged();
            System.out.println(list);
        });

        if (item instanceof Assignment) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");

            Assignment copy = (Assignment) item;
            field1.setText(copy.getTitle());
            field2.setText(copy.getClassName());
            field3.setText(sdf.format(copy.getDueDate()));
        } else if (item instanceof ClassInfo) {
            ClassInfo copy = (ClassInfo) item;
            field1.setText(copy.getCourseName());
            field2.setText(copy.getInstructor());
            field3.setText(copy.getTime().toString());
        } else if (item instanceof Exam) {
            Exam copy = (Exam) item;
            field1.setText(copy.getLocation());
            field2.setText(copy.getLocation());
//            field3.setText(copy.getData().toString());
            // TODO: implement date formatting
        }

        return view;
    }

    public interface OnItemClickListenerInterface {
        void onItemClick(int position);
    }
}
