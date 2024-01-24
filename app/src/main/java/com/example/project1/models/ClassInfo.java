package com.example.project1.models;

import java.sql.Time;

public class ClassInfo {
    private String courseName;
    private Time time;
    private String instructor;

    public ClassInfo(String courseName, Time time, String instructor) {
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
