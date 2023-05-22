package android.reserver.student.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.reserver.student.R;

public class CourseDetails extends AppCompatActivity {

    public static final String add_course_term_id = "android.reserver.student.UI.term_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
    }
}