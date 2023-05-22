package android.reserver.student.AddEdit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.reserver.student.R;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TermEdit extends AppCompatActivity {

    public static final String add_term_id = "android.reserver.student.AddEdit.term_id";
    public static final String add_term_title = "android.reserver.student.AddEdit.term_title";
    public static final String add_term_start = "android.reserver.student.AddEdit.term_start";
    public static final String add_term_end = "android.reserver.student.AddEdit.term_end";
    public static final String date_format = "mm/dd/yyyy";

    private EditText editTextTitle;
    private EditText editTextStart;
    private EditText editTextEnd;

    private Calendar calendarStart;
    private Calendar calendarEnd;

    private void updateText(EditText editText, Calendar calendar) {
        String myFormat = date_format; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText.setText(sdf.format(calendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_edit);

        editTextTitle = findViewById(R.id.edit_text_term_title);
        editTextStart = findViewById(R.id.edit_text_term_start);
        editTextEnd = findViewById(R.id.edit_text_term_end);

        this.calendarStart = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateStart = (view, year, month, dayOfMonth) -> {
            calendarStart.set(Calendar.YEAR, year);
            calendarStart.set(Calendar.MONTH, month);
            calendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateText(editTextStart, calendarStart);
        };
        editTextStart.setOnClickListener(v -> new DatePickerDialog(TermEdit.this,
                dateStart,
                calendarStart.get(Calendar.YEAR),
                calendarStart.get(Calendar.MONTH),
                calendarStart.get(Calendar.DAY_OF_MONTH)).show());

        this.calendarEnd = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetEnd = (view, year, month, dayOfMonth) -> {
            calendarEnd.set(Calendar.YEAR, year);
            calendarEnd.set(Calendar.MONTH, month);
            calendarEnd.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateText(editTextEnd, calendarEnd);
        };
        editTextEnd.setOnClickListener(v -> new DatePickerDialog(TermEdit.this,
                dateSetEnd,
                calendarEnd.get(Calendar.YEAR),
                calendarEnd.get(Calendar.MONTH),
                calendarEnd.get(Calendar.DAY_OF_MONTH)).show());
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_close_24);
        Intent intent = getIntent();
        if(intent.hasExtra(add_term_id)) {
            setTitle("Edit Term");
            editTextTitle.setText(intent.getStringExtra(add_term_id));
            editTextStart.setText(intent.getStringExtra(add_term_start));
            editTextEnd.setText(intent.getStringExtra(add_term_end));
        }
        else {
            setTitle("Add Term");
        }
    }

    private void saveTerm() {
        String termTitle = editTextTitle.getText().toString();
        String startDate = editTextStart.getText().toString();
        String endDate = editTextEnd.getText().toString();

        if (termTitle.trim().isEmpty()
                || startDate.trim().isEmpty()
                || endDate.trim().isEmpty()) {
            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(add_term_title, termTitle);
        data.putExtra(add_term_start, startDate);
        data.putExtra(add_term_end, endDate);

        int id = getIntent().getIntExtra(add_term_id, -1);
        if(id != -1) {
            data.putExtra(add_term_id, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_edit_save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_edit_save) {
            saveTerm();
            return true;
        }
        return super.onOptionsItemSelected(item);
        }

    @Override
    public boolean onSupportNavigateUp() {
//        Go back to the correct previous activity page
        finish();
        return true;
    }

}














