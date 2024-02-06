package com.example.project1.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Assignment implements Comparable<Assignment>, Parcelable {
    private String title;
    private Date dueDate;
    private String courseName;

    public Assignment(String title, Date dueDate, String courseName) {
        this.title = title;
        this.dueDate = dueDate;
        this.courseName = courseName;
    }

    public Assignment() {
        this(null, null, null);
    }

    protected Assignment(Parcel in) {
        title = in.readString();
        courseName = in.readString();
    }

    public static final Creator<Assignment> CREATOR = new Creator<Assignment>() {
        @Override
        public Assignment createFromParcel(Parcel in) {
            return new Assignment(in);
        }

        @Override
        public Assignment[] newArray(int size) {
            return new Assignment[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getClassName() {
        return courseName;
    }

    public void setClassName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Assignment o) {
        return dueDate.compareTo(o.dueDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.title,
                this.dueDate.toString(),
                this.courseName});
    }
}
