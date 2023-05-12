package android.reserver.student.Database;

import android.app.Application;
import android.os.AsyncTask;
import android.reserver.student.dao.AssessmentDAO;
import android.reserver.student.dao.CourseDAO;
import android.reserver.student.dao.MentorDAO;
import android.reserver.student.dao.TermDAO;
import android.reserver.student.entities.Assessment;
import android.reserver.student.entities.Course;
import android.reserver.student.entities.Mentor;
import android.reserver.student.entities.Product;
import android.reserver.student.entities.Term;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private TermDAO mTermDAO;
    private CourseDAO mCourseDAO;
    private AssessmentDAO mAssessmentDAO;
    private MentorDAO mMentorDAO;

    private LiveData<List<Term>> mAllTerms;
    private LiveData<List<Course>> mTermCourses;
    private LiveData<List<Assessment>> mCourseAssessments;
    private LiveData<List<Mentor>> mAllMentors;

    private static int number_of_threads = 4;

    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(number_of_threads);

    public Repository(Application application) {
        Database db = Database.getDatabase(application);
        mTermDAO = db.termDAO();
        mAllTerms = db.termDAO().getAllTerms();
        mCourseDAO = db.courseDAO();
        mAssessmentDAO = db.assessmentDAO();
        mMentorDAO = db.mentorDAO();
    }

    //Term DAO Queries

    public void insertTerm(Term term) {
        databaseExecutor.execute(() -> {
            mTermDAO.insertTerm(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTerm(Term term) {
        databaseExecutor.execute(() -> {
            mTermDAO.updateTerm(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTerm(Term term) {
        databaseExecutor.execute(() -> {
            mTermDAO.deleteTerm(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Term getTermByID(int term_ID) {
        databaseExecutor.execute(() -> {
            mTermDAO.getTermByID(term_ID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mTermDAO.getTermByID(term_ID);
    }

    public LiveData<List<Term>> getAllTerms() {
        databaseExecutor.execute(() -> {
            mAllTerms = mTermDAO.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mAllTerms;
    }

    public void deleteAllTerms() {
        databaseExecutor.execute(() -> {
            mTermDAO.deleteAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTermCount() {
        databaseExecutor.execute(() -> {
            mTermDAO.getTermCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mTermDAO.getTermCount();
    }

    // Course DAO Queries

    public void insertCourse(Course course) {
        databaseExecutor.execute(() -> {
            mCourseDAO.insertCourse(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCourse(Course course) {
        databaseExecutor.execute(() -> {
            mCourseDAO.updateCourse(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCourse(Course course) {
        databaseExecutor.execute(() -> {
            mCourseDAO.deleteCourse(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Course getCourseByID(int course_id) {
        databaseExecutor.execute(() -> {
            mCourseDAO.getCourseByID(course_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mCourseDAO.getCourseByID(course_id);
    }

    public LiveData<List<Course>> getLiveCoursesByTerm(int term_id) {
        databaseExecutor.execute(() -> {
            mCourseDAO.getLiveCoursesByTerm(term_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mCourseDAO.getLiveCoursesByTerm(term_id);
    }

    public List<Course> getCoursesByTerm(int term_id) {
        databaseExecutor.execute(() -> {
            mCourseDAO.getCoursesByTerm(term_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mCourseDAO.getCoursesByTerm(term_id);
    }

    public LiveData<List<Course>> getAllCourses() {
        databaseExecutor.execute(() -> {
            mCourseDAO.getAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mCourseDAO.getAllCourses();
    }

    public void deleteAllCourses() {
        databaseExecutor.execute(() -> {
            mCourseDAO.deleteAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCourseCount() {
        databaseExecutor.execute(() -> {
            mCourseDAO.getCourseCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mCourseDAO.getCourseCount();
    }

    //Assessment DAO Queries

    public void insertAssessment(Assessment assessment) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.insertAssessment(assessment);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAssessment(Assessment assessment) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.updateAssessment(assessment);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAssessment(Assessment assessment) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.deleteAssessment(assessment);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Assessment getAssessmentById(int assessment_id) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.getAssessmentById(assessment_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mAssessmentDAO.getAssessmentById(assessment_id);
    }

    public LiveData<List<Assessment>> getAllAssessments() {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mAssessmentDAO.getAllAssessments();
    }

    public LiveData<List<Assessment>> getAssessmentsByCourse(final int course_id) {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.getAssessmentsByCourse(course_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mAssessmentDAO.getAssessmentsByCourse(course_id);
    }

    public void deleteAllAssessments() {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.deleteAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAssessmentCount() {
        databaseExecutor.execute(() -> {
            mAssessmentDAO.getAssessmentCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mAssessmentDAO.getAssessmentCount();
    }

    // Mentor DAO Queries

    public void insertMentor(Mentor mentor) {
        databaseExecutor.execute(() -> {
            mMentorDAO.insertMentor(mentor);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMentor(Mentor mentor) {
        databaseExecutor.execute(() -> {
            mMentorDAO.updateMentor(mentor);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMentor(Mentor mentor) {
        databaseExecutor.execute(() -> {
            mMentorDAO.deleteMentor(mentor);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Mentor getMentorById(int mentor_id) {
        databaseExecutor.execute(() -> {
            mMentorDAO.getMentorById(mentor_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mMentorDAO.getMentorById(mentor_id);
    }

    public LiveData<List<Mentor>> getAllMentors() {
        databaseExecutor.execute(() -> {
            mMentorDAO.getAllMentors();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mMentorDAO.getAllMentors();
    }

    public LiveData<List<Mentor>> getMentorsByCourse(final int course_id) {
        databaseExecutor.execute(() -> {
            mMentorDAO.getMentorsByCourse(course_id);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mMentorDAO.getMentorsByCourse(course_id);
    }

    public void deleteAllMentors() {
        databaseExecutor.execute(() -> {
            mMentorDAO.deleteAllMentors();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMentorCount() {
        databaseExecutor.execute(() -> {
            mMentorDAO.getMentorCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mMentorDAO.getMentorCount();
    }

    // End of DAO Queries


}
