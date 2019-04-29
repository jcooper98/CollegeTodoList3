package com.jcooper.collegetodolist;

import android.widget.CheckBox;

import java.io.Serializable;

public class Assignment implements Serializable {

    String title = "";
    Boolean done = true;
    CheckBox checkBox;

    public Assignment(String title, Boolean done) {
        this.title = title;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}


