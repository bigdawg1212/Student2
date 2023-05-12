package android.reserver.student.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.Database.Repository;
import android.reserver.student.R;
import android.reserver.student.entities.Term;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TermsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_main);


       /* RecyclerView recyclerView=findViewById(R.id.recyclerview);
        Repository repo=new Repository(getApplication());
        List<Term> terms= repo.getAllTerms();
        TermAdapter adapter=new TermAdapter(getApplicationContext());
        adapter.setTerms(terms);*/


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