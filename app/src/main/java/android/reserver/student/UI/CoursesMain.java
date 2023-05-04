package android.reserver.student.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.R;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CoursesMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_main);

        FloatingActionButton fab2=findViewById(R.id.floatingActionButton2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CoursesMain.this,CourseDetails.class  );
                startActivity(intent);
            }
        });
    }
}