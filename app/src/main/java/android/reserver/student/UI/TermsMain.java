package android.reserver.student.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.Adapters.TermAdapter;
import android.reserver.student.AddEdit.TermEdit;
import android.reserver.student.Database.Repository;
import android.reserver.student.R;
import android.reserver.student.ViewModel.CourseViewModel;
import android.reserver.student.ViewModel.TermViewModel;
import android.reserver.student.entities.Term;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TermsMain extends AppCompatActivity {

    public static final int ADD_TERM_REQUEST = 1;
    private TermViewModel termViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_main);


       RecyclerView recyclerView=findViewById(R.id.termsListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final TermAdapter adapter = new TermAdapter();
        recyclerView.setAdapter(adapter);


        FloatingActionButton fabAddTerm=findViewById(R.id.floatingActionButton);
        fabAddTerm.setOnClickListener(v ->  {
                Intent intent=new Intent(TermsMain.this,TermEdit.class  );
                startActivityForResult(intent, add_term);
            });


        termViewModel = new ViewModelProvider(this).get(TermViewModel.class);
        termViewModel.getAllTerms().observe(this, termEntities -> adapter.setTerms(termEntities));
        CourseViewModel courseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Term deletedTerm = adapter.getTermAt(viewHolder.getAdapterPosition());

                int relatedCourses = 0;
                try {
                    relatedCourses = courseViewModel.getCoursesByTerm(deletedTerm.getTerm_id()).size();
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }

                if(relatedCourses > 0) {
                    Toast.makeText(TermsMain.this, "Courses still attached. Term not deleted!", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                } else {
                    termViewModel.deleteTerm(deletedTerm);
                    Toast.makeText(TermsMain.this, "Term deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(term -> {
            Intent intent = new Intent(TermsMain.this, TermsDetails.class);
            intent.putExtra(TermsDetails.add_term_id, term.getTerm_id());
            intent.putExtra(TermsDetails.add_term_title, term.getTerm_title());
            intent.putExtra(TermsDetails.add_term_start, term.getTerm_start());
            intent.putExtra(TermsDetails.add_term_end, term.getTerm_end());
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_TERM_REQUEST && resultCode == RESULT_OK) {
//            TODO
//              Likely convert these to UTC datetime
            Integer term_id = data.getIntExtra(TermEdit.add_term_id, 1);
            String title = data.getStringExtra(TermEdit.add_term_title);
            String startDate = data.getStringExtra(TermEdit.add_term_start);
            String endDate = data.getStringExtra(TermEdit.add_term_end);

            Term term = new Term(term_id, title, startDate, endDate);
            termViewModel.insertTerm(term);

            Toast.makeText(this, "Term added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Term not added", Toast.LENGTH_SHORT).show();
        }
    }
}