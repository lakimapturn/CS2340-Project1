package com.example.project1.models;

import java.util.Date;

public class Assignment {
    private String title;
    private Date dueDate;
    private String className;

    public Assignment(String title, Date dueDate, String className) {
        this.title = title;
        this.dueDate = dueDate;
        this.className = className;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
