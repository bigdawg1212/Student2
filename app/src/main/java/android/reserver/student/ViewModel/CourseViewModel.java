package android.reserver.student.ViewModel;

import android.app.Application;
import android.reserver.student.Database.Repository;
import android.reserver.student.entities.Course;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CourseViewModel extends AndroidViewModel {
    private Repository repo;

    public CourseViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);
    }

    public void insertCourse(Course course) {repo.insertCourse(course); }
    public void updateCourse(Course course) {repo.updateCourse(course); }
    public void deleteCourse(Course course) {repo.deleteCourse(course); }

    public LiveData<List<Course>> getLiveCoursesByTerm(int term_id) {
        return repo.getLiveCoursesByTerm(term_id);
    }

    public List<Course> getCoursesByTerm(int term_id) throws ExecutionException, InterruptedException {
        return repo.getCoursesByTerm(term_id);
    }
}
