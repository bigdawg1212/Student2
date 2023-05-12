package android.reserver.student.ViewModel;

import android.app.Application;
import android.reserver.student.Database.Repository;
import android.reserver.student.entities.Term;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TermViewModel extends AndroidViewModel {
    private Repository repo;
    private LiveData<List<Term>> allTerms;

    public TermViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);
        allTerms = repo.getAllTerms();
    }

    public void insertTerm(Term term) { repo.insertTerm(term); }
    public void updateTerm(Term term) { repo.updateTerm(term); }
    public void deleteTerm(Term term) { repo.deleteTerm(term); }

    public LiveData<List<Term>> getAllTerms() { return allTerms; }
}
