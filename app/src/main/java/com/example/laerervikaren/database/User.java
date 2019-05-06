package com.example.laerervikaren.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public User(int uid, String description, String title, String url) {
        this.uid = uid;
        Description = description;
        Title = title;
        Url = url;
    }
    public User(){

    }

    @PrimaryKey

    public int uid;
    public String Description;
    public String Title;
    public String Url;


}