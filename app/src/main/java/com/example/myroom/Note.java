package com.example.myroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Movie")
public class Note {


    @PrimaryKey(autoGenerate = true)
    private int _id;

   private String title;

   private String year;

   private String run_time;

   private String Collection;


  // @ForeignKey(entity = Director.class,parentColumns = "director_id",childColumns = "id")
  private int director;

    Note(String title, String year, String run_time, String collection, int director)
    {
        this.title = title;
        this.year = year;
        this.run_time = run_time;
       this.Collection = "horror";
        this.director = director;
    }

    Note(){

    }

    public void set_id(int _id) {
        this._id = _id;
    }

    int get_id() {
        return _id;
    }

    String getTitle() {
        return title;
    }

    String getYear() {
        return year;
    }

    String getRun_time() {
        return run_time;
    }

    String getCollection() {
        return Collection;
    }

   public int getDirector() {
        return director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRun_time(String run_time) {
        this.run_time = run_time;
    }

    public void setCollection(String collection) {
        Collection = collection;
    }

   // public void setDirector_id(int director_id) {
  //      this.director_id = director_id;
   // }
}
