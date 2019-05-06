package com.example.laerervikaren;

import android.os.AsyncTask;

import com.example.laerervikaren.database.AppDatabase;
import com.example.laerervikaren.database.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {
    public static void populateAsync(final AppDatabase database) {
        new PopulateDbAsync(database).execute();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase database;

        PopulateDbAsync(AppDatabase database) {
            this.database = database;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // If the Database is empty, add the initial data.
            if (database.userDao().countUsers() == 0) {
                List<User> currentuser = new ArrayList<>();
                //currentuser.add(new User("mangler noget"));
                currentuser.add(new User());
                currentuser.add(new User());

                database.userDao()
                        .insert(currentuser.toArray(new User[currentuser.size()]));

            }

            return null;
        }
    }
}
