package android.reserver.student.dao;

import android.reserver.student.entities.Term;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TermDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTerm(Term term);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Term> terms);

    @Update
    void updateTerm(Term term);

    @Delete
    void deleteTerm(Term term);

    @Query("SELECT * FROM terms WHERE term_id = :term_ID")
    Term getTermByID(int term_ID);

    @Query("SELECT * FROM terms ORDER BY term_start ASC")
    LiveData<List<Term>> getAllTerms();

    @Query("DELETE FROM terms")
    int deleteAllTerms();

    @Query("SELECT COUNT(*) FROM terms")
    int getTermCount();
}
