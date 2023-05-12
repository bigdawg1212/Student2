package android.reserver.student.dao;

import android.reserver.student.entities.Course;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourse(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Course> courses);

    @Update
    void updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM courses WHERE course_id = :course_id")
    Course getCourseByID(int course_id);

    @Query("SELECT * FROM courses WHERE term_id = :term_id")
    LiveData<List<Course>> getLiveCoursesByTerm(int term_id);

    @Query("SELECT * FROM courses WHERE term_id = :term_id")
    List<Course> getCoursesByTerm(int term_id);

    @Query("SELECT * FROM courses ORDER BY course_start DESC")
    LiveData<List<Course>> getAllCourses();

    @Query("DELETE FROM courses")
    int deleteAllCourses();

    @Query("SELECT COUNT(*) FROM courses")
    int getCourseCount();



}
