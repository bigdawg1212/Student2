package android.reserver.student.ViewModel;

import android.app.Application;
import android.reserver.student.Database.Repository;
import android.reserver.student.entities.Mentor;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MentorViewModel extends AndroidViewModel {

    private Repository repo;

    public MentorViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);
    }

    public void insertMentor(Mentor mentor) { repo.insertMentor(mentor); }
    public void updateMentor(Mentor mentor) { repo.updateMentor(mentor); }
    public void deleteMentor(Mentor mentor) { repo.deleteMentor(mentor); }

    public LiveData<List<Mentor>> getAllMentors() {
        return repo.getAllMentors();
    }

    public LiveData<List<Mentor>> getMentorsByCourse(final int course_id) {
        return repo.getMentorsByCourse(course_id);
    }

 }
