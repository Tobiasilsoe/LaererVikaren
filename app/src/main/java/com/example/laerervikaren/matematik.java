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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getAppDatabase(this);

        if(db.userDao().getUser().size() ==0){

            user = new User(1,"beskrivelse af webmatematik","webmatematik (30 min)","https://www.webmatematik.dk/","VIS MERE");
            db.userDao().insert(user);
            user = new User(2,"Den største forskel ved at bruge en digital portal som MatematikFessor er, at jeg som lærer får meget mere tid. Den kan jeg bruge til at lave rigtig god undervisning, der udfylder faglige huller, og på at have større opmærksomhed på det enkelte barn. MatematikFessor giver desuden et hurtigt overblik over elevernes styrker og svagheder og gør det let som lærer at sætte sig ind i, hvor der er behov.","matematikfessor (60-90 min)","https://www.matematikfessor.dk/","VIS MERE");
            db.userDao().insert(user);
            user = new User(3,"Her kan køres forskellige undervisningsforløb lavet af gyldendal","Gyldendal matematik (60 min)","https://matematik.gyldendal.dk/en/Indgange/Forloeb.aspx","VIS MERE");
            db.userDao().insert(user);
            user = new User(4,"Til eleven der er blevet hurtig færdig og skal underholdes de sidste 10 min. God til tabeltræning","Emat (10 min)","https://emat.dk/tabel.aspx","VIS MERE");
            db.userDao().insert(user);
            user = new User(5,"Det er en leg, hvor klassen bliver delt op i 2 hold. En elev fra det ene hold går op til tavlen og tager en ting i sin hånd. En anden elev skal gætte i hvilken hånd tingen er. Giver minus point hvis holdet larmer imens. ","Skorstens leg (10 min)","ingen hjemmeside","VIS MERE");
            db.userDao().insert(user);
            user = new User(6,"Her er en masse små matematikspil børnene kan spille","Matematik Spil (5-15 min)","http://matematikonline.dk/","VIS MERE");
            db.userDao().insert(user);
            user = new User(7,"Her er en masse små matematikspil børnene kan spille, så som suduko, 2048 osv.","Matematik Spil (5-15 min)","https://poki.dk/matematik","VIS MERE");
            db.userDao().insert(user);
            users=db.userDao().getUser();
        }
        else{

            users=db.userDao().getUser();
        }
        setContentView(R.layout.activity_matematik);





        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MatAdapter(this,users );
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}