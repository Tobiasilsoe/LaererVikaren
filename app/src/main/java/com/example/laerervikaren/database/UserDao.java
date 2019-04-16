package com.example.laerervikaren.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user where uid = 1")
    User getUser();

    @Update
    int update(User user);


    @Insert
    void insert(User user, List<User> currentUser);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

}