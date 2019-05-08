package com.example.laerervikaren;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.service.autofill.UserData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laerervikaren.database.AppDatabase;
import com.example.laerervikaren.database.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class matematik extends AppCompatActivity implements MatAdapter.ItemClickListener {

    MatAdapter adapter;
    protected  AppDatabase db;
    protected User user;
    List<User> users = new ArrayList<>();

    /*AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "production")
            .allowMainThreadQueries()
            .build();*/

    //List<User> users = db.userDao().getUser();


    //private List<User> mData;
    //protected User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getAppDatabase(this);

        if(db.userDao().getUser().size() ==1){

            /*user = new User();
            user.setUid(1);
            user.setDescription("beskrivelse af matematikFessor");
            user.setTitle("Matematikfessor");
            user.setUrl("https://www.matematikfessor.dk/");
            db.userDao().insert(user);
            Log.d("base","iflokke");*/
            /*user = new User(2,"beskrivelse af webmatematik","Webmatematik","https://www.webmatematik.dk/");

            db.userDao().insert(user); */
            users=db.userDao().getUser();
        }
        else{
            //user = db.userDao().getUser();
            users=db.userDao().getUser();
        }
        setContentView(R.layout.activity_matematik);
        //currentUser = db.userDao().getUser();

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        //ArrayList<User> users = new ArrayList<>();


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MatAdapter(this,users );
        //adapter = new MatAdapter(users );
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}