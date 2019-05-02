package com.jcooper.collegetodolist;

import java.io.Serializable;

public class Assignment implements Serializable {

    String title = "";
    Boolean done = true;
    private String key;

    public Assignment() {
    }

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


