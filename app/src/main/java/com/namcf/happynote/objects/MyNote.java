package com.namcf.happynote.objects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by linuxlord on 4/26/17.
 */

public class MyNote extends RealmObject{

    public static String KEY_ID = "id";

    @PrimaryKey
    private int id;

    private String title = "";
    private String note = "";
    private String date = "";

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
