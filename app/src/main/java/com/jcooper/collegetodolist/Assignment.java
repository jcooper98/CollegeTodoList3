package com.jcooper.collegetodolist;

import android.widget.CheckBox;

import java.io.Serializable;

public class Assignment implements Serializable {

    String title = "";
    Boolean done = true;
    CheckBox checkBox;
    private String key;

    public Assignment(String key, String title, Boolean done) {
        this.title = title;
        this.done = done;
        this.key = key;
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

    public String getKey() {
        return key;
    }
}


