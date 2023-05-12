package android.reserver.student.ViewModel;

import android.app.Application;
import android.reserver.student.Database.Repository;
import android.reserver.student.entities.Assessment;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AssessmentViewModel extends AndroidViewModel {
    private Repository repo;

    public AssessmentViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);

    }

    public void insertAssessment(Assessment assessment) {repo.insertAssessment(assessment); }
    public void updateAssessment(Assessment assessment) {repo.updateAssessment(assessment); }
    public void deleteAssessment(Assessment assessment) {repo.deleteAssessment(assessment); }

   public LiveData<List<Assessment>> getAllAssessments() {
        return repo.getAllAssessments();
   }

    public LiveData<List<Assessment>> getAssessmentsByCourse(final int course_id) {
        return repo.getAssessmentsByCourse(course_id);
    }
}
