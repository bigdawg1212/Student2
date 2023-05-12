package android.reserver.student.dao;

import android.reserver.student.entities.Assessment;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AssessmentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAssessment(Assessment assessment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Assessment> assessments);

    @Update
    void updateAssessment(Assessment assessment);

    @Delete
    void deleteAssessment(Assessment assessment);

    @Query("SELECT * FROM assessments WHERE assessment_id = :assessment_id")
    Assessment getAssessmentById(int assessment_id);

    @Query("SELECT * FROM assessments ORDER BY assessment_date DESC")
    LiveData<List<Assessment>> getAllAssessments();

    @Query("SELECT * FROM assessments WHERE course_id = :course_id")
    LiveData<List<Assessment>> getAssessmentsByCourse(final int course_id);

    @Query("DELETE FROM assessments")
    int deleteAllAssessments();

    @Query("SELECT COUNT(*) FROM assessments")
    int getAssessmentCount();


}
