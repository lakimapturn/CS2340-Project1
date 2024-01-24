package com.example.project1.models;

import java.time.LocalDateTime;

public class Exam {
    private String courseName;
    private LocalDateTime dateTime;
    private String location;

    public Exam() {
        this(null, null, null);
    }

    public Exam(String courseName, LocalDateTime dateTime, String location) {
        this.courseName = courseName;
        this.dateTime = dateTime;
        this.location = location;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDateTime getData() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setData(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
