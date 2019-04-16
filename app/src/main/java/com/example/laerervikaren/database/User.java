package com.example.laerervikaren.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey

    public int uid;
    public String Description;
    public String Title;
    public String Url;


}