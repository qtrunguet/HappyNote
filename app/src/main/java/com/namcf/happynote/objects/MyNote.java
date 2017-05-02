package com.namcf.happynote.objects;

/**
 * Created by linuxlord on 4/26/17.
 */

public class MyNote {

    private String title;
    private String note;
    private String date;

    public MyNote(String title, String note, String date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    public MyNote() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
