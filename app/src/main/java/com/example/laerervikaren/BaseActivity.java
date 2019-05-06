package com.example.laerervikaren;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.laerervikaren.database.AppDatabase;
import com.example.laerervikaren.database.User;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected  AppDatabase db;
        protected User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        db = AppDatabase.getAppDatabase(this);

        if(db.userDao().countUsers() == 0){

            user = new User();
            user.setUid(1);
            user.setDescription("beskrivelse af matematikFessor");
            user.setTitle("Matematikfessor");
            user.setUrl("https://www.matematikfessor.dk/");
            db.userDao().insert(user);
            Log.d("base","iflokke");


            List<User> users=db.userDao().getUser();
        }
        else{
            //user = db.userDao().getUser();
            List<User> users=db.userDao().getUser();
        }
        //List<User> users=db.userDao().getUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}