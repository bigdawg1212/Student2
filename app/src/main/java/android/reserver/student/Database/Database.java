package android.reserver.student.Database;


import android.content.Context;
import android.reserver.student.dao.AssessmentDAO;
import android.reserver.student.dao.CourseDAO;
import android.reserver.student.dao.MentorDAO;
import android.reserver.student.dao.TermDAO;
import android.reserver.student.entities.Assessment;
import android.reserver.student.entities.Course;
import android.reserver.student.entities.Mentor;
import android.reserver.student.entities.Term;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Term.class, Course.class, Assessment.class, Mentor.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract TermDAO termDAO();

    public abstract CourseDAO courseDAO();

    public abstract AssessmentDAO assessmentDAO();

    public abstract MentorDAO mentorDAO();

    private static volatile Database instance;
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "AppDatabase.db";

    static Database getDatabase(final Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}
