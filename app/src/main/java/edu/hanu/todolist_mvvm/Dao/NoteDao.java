package edu.hanu.todolist_mvvm.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.hanu.todolist_mvvm.Entity.Note;
import io.reactivex.Observable;

@Dao
public interface NoteDao {
    @Insert
    Long insert(Note note);

    @Delete
    int delete(Note note);

    @Update
    int update(Note note);

    @Query("DELETE FROM note_table")
    int deleteAll();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    Observable<List<Note>> getAllNotes();

}
