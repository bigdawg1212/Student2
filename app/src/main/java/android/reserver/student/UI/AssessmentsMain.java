package android.reserver.student.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.R;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AssessmentsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessments_main);

        FloatingActionButton fab3=findViewById(R.id.floatingActionButton3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AssessmentsMain.this,AssessmentDetails.class  );
                startActivity(intent);
            }
        });
    }
}