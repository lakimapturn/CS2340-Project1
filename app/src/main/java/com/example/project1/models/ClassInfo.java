package com.example.project1.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class ClassInfo implements Parcelable {
    private String courseName;
    private Date time;
    private String instructor;

    public ClassInfo(String courseName, Date time, String instructor) {
        this.courseName = courseName;
        this.time = time;
        this.instructor = instructor;
    }
    public ClassInfo() {
        this(null, null, null);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.courseName,
                this.time.toString(),
                this.courseName});
    }
}
