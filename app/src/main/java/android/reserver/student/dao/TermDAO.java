package android.reserver.student.dao;

import android.reserver.student.entities.Term;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TermDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertTerm(Term term);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Term> terms);

    @Delete
    void deleteTerm(Term term);

    @Query("SELECT * FROM terms WHERE term_id = :termID")
    Term getTermByID(int termID);

    @Query("SELECT * FROM terms ORDER BY term_start ASC")
    LiveData<List<Term>> getAllTerms();

    @Query("DELETE FROM terms")
    int deleteAllTerms();

    @Query("SELECT COUNT(*) FROM terms")
    int getTermCount();
}
