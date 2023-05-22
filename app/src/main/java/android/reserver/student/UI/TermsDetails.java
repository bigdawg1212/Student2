package android.reserver.student.UI;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.AddEdit.TermEdit;
import android.reserver.student.R;
import android.reserver.student.ViewModel.CourseViewModel;
import android.reserver.student.ViewModel.TermViewModel;
import android.reserver.student.entities.Term;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TermsDetails extends AppCompatActivity {

    public static final String add_term_id = "android.reserver.student.UI.term_id";
    public static final String add_term_title = "android.reserver.student.UI.term_title";
    public static final String add_term_start = "android.reserver.student.UI.term_start";
    public static final String add_term_end = "android.reserver.student.UI.term_end";

    public static final int edit_term_request = 2;

    private TermViewModel termViewModel;

    private int term_id;
    private TextView textViewID;
    private TextView textViewTitle;
    private TextView textViewStart;
    private TextView textViewEnd;
    private Button courseListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_details);
        termViewModel = new ViewModelProvider(this).get(TermViewModel.class);

        textViewID = findViewById(R.id.details_term_id);
        textViewTitle = findViewById(R.id.details_term_title);
        textViewStart = findViewById(R.id.details_term_start);
        textViewEnd = findViewById(R.id.details_term_end);
        courseListButton = findViewById(R.id.btn_add_term);

        Intent intent = getIntent();
        term_id = intent.getIntExtra(add_term_id, -1);
        textViewID.setText(intent.getStringExtra(add_term_id));
        textViewTitle.setText(intent.getStringExtra(add_term_title));
        textViewStart.setText(intent.getStringExtra(add_term_start));
        textViewEnd.setText(intent.getStringExtra(add_term_end));

        setTitle(intent.getStringExtra(add_term_title));

        courseListButton.setOnClickListener(v -> {
            Intent loadCourseListIntent = new Intent(TermsDetails.this, CoursesMain.class);
            loadCourseListIntent.putExtra(CoursesMain.add_course_term_id, term_id);
            loadCourseListIntent.putExtra(CoursesMain.add_course_term_title, intent.getStringExtra(add_term_id));
            startActivity(loadCourseListIntent);
        });

        FloatingActionButton buttonEditTerm = findViewById(R.id.btn_add_term);
        buttonEditTerm.setOnClickListener(v -> {
            Intent editTermIntent = new Intent(TermsDetails.this, TermEdit.class);
            editTermIntent.putExtra(TermEdit.add_term_id, intent.getIntExtra(add_term_id, -1));
            editTermIntent.putExtra(TermEdit.add_term_title, intent.getStringExtra(add_term_title));
            editTermIntent.putExtra(TermEdit.add_term_start, intent.getStringExtra(add_term_start));
            editTermIntent.putExtra(TermEdit.add_term_end, intent.getStringExtra(add_term_end));

            // startActivityForResult(editTermIntent, edit_term_request);
            activityResultLaunch
            Intent editTermIntent =
        });
    }

    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String id = data.getStringExtra(TermEdit.add_term_id);
                        String title = data.getStringExtra(TermEdit.add_term_title);
                        String startDate = data.getStringExtra(TermEdit.add_term_start);
                        String endDate = data.getStringExtra(TermEdit.add_term_end);
                        int id = data.getIntExtra(TermEdit.add_term_id, -1);
                        if(id == -1) {
                            Toast.makeText(this, "Error, term not saved", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        textViewID.setText(id);
                        textViewTitle.setText(title);
                        textViewStart.setText(startDate);
                        textViewEnd.setText(endDate);

                        Term term = new Term(id, title, startDate, endDate);
                        term.setTerm_id(id);
                        termViewModel.updateTerm(term);

                        Toast.makeText(this, "Term updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Term not saved", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    )
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == edit_term_request && resultCode == RESULT_OK) {
            String id = data.getStringExtra(TermEdit.add_term_id);
            String title = data.getStringExtra(TermEdit.add_term_title);
            String startDate = data.getStringExtra(TermEdit.add_term_start);
            String endDate = data.getStringExtra(TermEdit.add_term_end);
            int id = data.getIntExtra(TermEdit.add_term_id, -1);
            if(id == -1) {
                Toast.makeText(this, "Error, term not saved", Toast.LENGTH_SHORT).show();
                return;
            }

            textViewID.setText(id);
            textViewTitle.setText(title);
            textViewStart.setText(startDate);
            textViewEnd.setText(endDate);

            Term term = new Term(id, title, startDate, endDate);
            term.setTerm_id(id);
            termViewModel.updateTerm(term);

            Toast.makeText(this, "Term updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Term not saved", Toast.LENGTH_SHORT).show();
        }
    }
}