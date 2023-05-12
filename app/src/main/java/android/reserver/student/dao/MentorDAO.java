package android.reserver.student.dao;

import android.reserver.student.entities.Mentor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MentorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMentor(Mentor mentor);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Mentor> mentors);

    @Update
    void updateMentor(Mentor mentor);

    @Delete
    void deleteMentor(Mentor mentor);

    @Query("SELECT * FROM mentors WHERE mentor_id = :mentor_id")
    Mentor getMentorById(int mentor_id);

    @Query("SELECT * FROM mentors ORDER BY mentor_name DESC")
    LiveData<List<Mentor>> getAllMentors();

    @Query("Select * FROM mentors WHERE course_id = :course_id")
    LiveData<List<Mentor>> getMentorsByCourse(final int course_id);

    @Query("DELETE FROM mentors")
    int deleteAllMentors();

    @Query("SELECT COUNT(*) FROM mentors")
    int getMentorCount();


}
