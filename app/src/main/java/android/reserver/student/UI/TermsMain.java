package android.reserver.student.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.R;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TermsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_main);

        FloatingActionButton fab1=findViewById(R.id.floatingActionButton);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TermsMain.this,TermsDetails.class  );
                startActivity(intent);
            }
        });
    }
}