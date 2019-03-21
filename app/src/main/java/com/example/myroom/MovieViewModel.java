package com.example.myroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository repository;

    private LiveData<List<Note>> allNotes;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        repository = new MovieRepository(application);
        allNotes = repository.getAllNotes();

    }
public void  insert (Note note){
        repository.Insert(note);
}
    public void  update(Note note){
        repository.Update(note);
    }
    public void delete (Note note){
        repository.Delete(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
