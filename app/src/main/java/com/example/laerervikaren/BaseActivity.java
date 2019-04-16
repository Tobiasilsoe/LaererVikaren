package com.example.laerervikaren;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.laerervikaren.database.AppDatabase;
import com.example.laerervikaren.database.User;

public class BaseActivity extends AppCompatActivity {

    protected  AppDatabase db;
    protected User currentUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getAppDatabase(this);
        if(db.userDao().countUsers() == 0){
            currentUser = new User();
            currentUser.uid = 1;
            currentUser.Description = "";
            currentUser.Title = "";
            currentUser.Url = "";
            db.userDao().insert(currentUser);
        }
        else{
            currentUser = db.userDao().getUser();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}