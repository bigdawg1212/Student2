package android.reserver.student.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.Database.Repository;
import android.reserver.student.R;
import android.reserver.student.entities.Course;
import android.reserver.student.entities.Term;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Term(int term_id, String term_title, String term_start, String term_end)
        Term term=new Term(1, "Spring", "12-12", "12-13");
        Repository repository=new Repository(getApplication());
        repository.insertTerm(term);



        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, TermsMain.class);
                startActivity(intent);
            }
        });

        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CoursesMain.class);
                startActivity(intent);
            }
        });

        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AssessmentsMain.class);
                startActivity(intent);
            }
        });

        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MentorMain.class);
                startActivity(intent);
            }
        });



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addSampleData) {

                Term term=new Term(1, "Spring", "12-12", "12-13");
                Repository repository=new Repository(getApplication());
                repository.insertTerm(term);

                //Course(int course_id, String course_title, String course_start, String course_end, String course_status, int term_id)
                Course course=new Course(0, "C196", "12-12", "12-13", "Pending", 1);
                repository.insertCourse(course);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}