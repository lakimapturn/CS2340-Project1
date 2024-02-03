package com.example.project1.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Exam implements Parcelable {
    private Date dateTime;
    private String location;

    public Exam() {
        this(null, null);
    }

    public Exam(Date dateTime, String location) {
        this.dateTime = dateTime;
        this.location = location;
    }

    protected Exam(Parcel in) {
        location = in.readString();
    }

    public static final Creator<Exam> CREATOR = new Creator<Exam>() {
        @Override
        public Exam createFromParcel(Parcel in) {
            return new Exam(in);
        }

        @Override
        public Exam[] newArray(int size) {
            return new Exam[size];
        }
    };

    public Date getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(this.dateTime != null ? this.dateTime.getTime() : -1);
        dest.writeString(this.location);
    }
}
