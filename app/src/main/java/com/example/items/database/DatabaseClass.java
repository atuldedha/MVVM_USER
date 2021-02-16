package com.example.items.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.items.dao.DaoClass;
import com.example.items.model.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class DatabaseClass extends RoomDatabase {

    public abstract DaoClass getDao();
    private static DatabaseClass instance;

    public static DatabaseClass getDatabase(final Context context){

        if(instance == null){

            synchronized (DatabaseClass.class){

                instance = Room.databaseBuilder(context, DatabaseClass.class, "DATABASE")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();

            }
        }

        return instance;

    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateInitialDb(instance).execute();

        }
    };

    private static class PopulateInitialDb extends AsyncTask<Void, Void, Void>{

        private DaoClass daoClass;

        private PopulateInitialDb(DatabaseClass db){

            daoClass = db.getDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            daoClass.addData(new UserModel("person1", "Delhi", "20", "Male"));
            daoClass.addData(new UserModel("person2", "Mumbai", "20", "Male"));
            daoClass.addData(new UserModel("person3", "delhi", "20", "Male"));
            daoClass.addData(new UserModel("person4", "Rajasthan", "20", "Female"));

            return null;
        }
    }

}
