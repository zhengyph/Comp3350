package comp3350.pbbs.presentation.addObject;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.pbbs.R;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;


import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;
import java.util.Objects;

public class addTransaction extends AppCompatActivity
{
    DatePickerDialog datePickerDialog;
    EditText dateText;
    TimePickerDialog timePickerDialog;
    EditText timeText;
    final Calendar c = Calendar.getInstance();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add Transaction");

        dateText = findViewById(R.id.dateInput);
        dateText.setOnClickListener(v -> dateText.setOnClickListener(v1 ->
        {
             datePickerDialog = new DatePickerDialog(addTransaction.this,
                                                     (view, year1, monthOfYear, dayOfMonth) ->
                                                     {
                                                         // TODO: here is the date, deal with it.
                                                         dateText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1);
                                                     }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
             datePickerDialog.show();
        }));

        timeText = findViewById(R.id.timeInput);
        timeText.setOnClickListener(v -> timeText.setOnClickListener(v1 ->
        {
             timePickerDialog = new TimePickerDialog(addTransaction.this,
                                                     (timePicker, hourOfDay, minute) ->
                                                     {
                                                         // TODO: here is the time, deal with it
                                                         timeText.setText(hourOfDay + " : " + minute);
                                                     }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
             timePickerDialog.show();
        }));

        findViewById(R.id.addTranssubmit).setOnClickListener(view ->
        {
            if (false)   // validate fields, use methods from business class
            {
             // thatEditText.setError()
            }
            else
            {
             // transaction.addTransaction(string, string, string);
                Snackbar.make(view, "Transaction Added!", Snackbar.LENGTH_SHORT)
                        .addCallback(new Snackbar.Callback()
                        {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event)
                            {
                                super.onDismissed(transientBottomBar, event);
                                finish();
                            }
                        }).show();
            }
        });
    }

    // TODO: field validation
}