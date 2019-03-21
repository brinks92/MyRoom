package com.example.myroom;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities =  Note.class  , version = 1,exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase Instance;

    public abstract MovieDao movieDao();

    public static synchronized MovieDatabase getInstance(Context context) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(context.getApplicationContext(),
                    MovieDatabase.class, "Movie_Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomcallback)
                    .build();
        }
        return Instance;
    }

    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(Instance).execute();
            
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private  MovieDao movieDao;

        private  PopulateDbAsyncTask(MovieDatabase db){
            movieDao = db.movieDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            movieDao.insert(new Note("The Great Gatsby","2016","2 hours","Horror"));
            movieDao.insert(new Note("The Greatest Gatsby","2019","2 hours","Horror"));
            movieDao.insert(new Note("The Greater Gatsby","2017","2 hours","Horror"));
            return null;
        }
    }
}

