package com.example.project1.models;

import java.time.LocalDateTime;

public class Assignment {
    private String title;
    private LocalDateTime dueDate;
    private String courseName;

    public Assignment(String title, LocalDateTime dueDate, String courseName) {
        this.title = title;
        this.dueDate = dueDate;
        this.courseName = courseName;
    }

    public Assignment() {
        this(null, null, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getClassName() {
        return courseName;
    }

    public void setClassName(String courseName) {
        this.courseName = courseName;
    }
}
