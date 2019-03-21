package com.example.myroom;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.security.PublicKey;
import java.util.List;

public class MovieRepository {
    private  MovieDao movieDao;
    private LiveData<List<Note>> allNotes;

    public MovieRepository(Application application){
        MovieDatabase database = MovieDatabase.getInstance(application);
        movieDao = database.movieDao();
        allNotes = movieDao.getAllNotes();

    }

    public void Insert(Note note){
    new InsertNoteAsyncTask(movieDao).execute(note);
    }

    public void Update(Note note){
    new UpdateNoteAsyncTask(movieDao).execute(note);
    }

    public void Delete(Note note){
    new DeleteNoteAsyncTask(movieDao).execute(note);
    }

    public void deleteAllNotes(){
    new DeleteAllNoteAsyncTask(movieDao).execute();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }




    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
    private MovieDao movieDao;


        private InsertNoteAsyncTask(MovieDao movieDao){
        this.movieDao =movieDao;
    }

        @Override
        protected Void doInBackground(Note... notes) {
        movieDao.insert(notes[0]);

        return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private MovieDao movieDao;


        private UpdateNoteAsyncTask(MovieDao movieDao){
            this.movieDao =movieDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            movieDao.update(notes[0]);

            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private MovieDao movieDao;


        private DeleteNoteAsyncTask(MovieDao movieDao){
            this.movieDao =movieDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            movieDao.delete(notes[0]);

            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void,Void,Void>{
        private MovieDao movieDao;


        private DeleteAllNoteAsyncTask(MovieDao movieDao){
            this.movieDao =movieDao;
        }

        @Override
        protected Void doInBackground(Void... Void) {
            movieDao.deleteAllNotes();

            return null;
        }
    }

}
