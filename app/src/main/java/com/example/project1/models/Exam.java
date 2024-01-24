package com.example.project1.models;

import java.time.LocalDateTime;

public class Exam {
    private String className;
    private LocalDateTime dateTime;
    private String location;

    public Exam() {
        this(null, null, null);
    }

    public Exam(String className, LocalDateTime dateTime, String location) {
        this.className = className;
        this.dateTime = dateTime;
        this.location = location;
    }

    public String getClassName() {
        return className;
    }

    public LocalDateTime getData() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setData(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
