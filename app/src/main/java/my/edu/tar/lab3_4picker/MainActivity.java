package my.edu.tar.lab3_4picker;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

        TextView buttonDate, textViewAge, textViewEligibleAmount, uInputAmount;
        int savings = 0;
        Integer Age = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDate = findViewById(R.id.buttonDate);
        textViewAge = findViewById(R.id.textViewAge);
        textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        uInputAmount = findViewById(R.id.editTextAccountBalance);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
        buttonDate.setText(dateMessage);
        Age = Calendar.getInstance().get(Calendar.YEAR) - year;

    }

    public void onCalculate(View view)
    {
        textViewAge.setText("Age: " + Age.toString());
        int finalVal = Integer.parseInt(uInputAmount.getText().toString());

        if(Age >=16 && Age <= 20)
        {
            savings = finalVal - 5000;
        }
        else if(Age >=21 && Age <= 25)
        {
            savings = finalVal - 14000;
        }
        else if(Age >=26 && Age <= 30)
        {
            savings = finalVal -  29000;
        }
        else if(Age >=31 && Age <= 35)
        {
            savings = finalVal -  50000;
        }
        else if(Age >=36 && Age <= 40)
        {
            savings = finalVal -  78000;
        }
        else if(Age >=41 && Age <= 45)
        {
            savings = finalVal -  116000;
        }
        else if(Age >=46 && Age <= 50)
        {
            savings = finalVal -  165000;
        }
        else if(Age >=51 && Age <= 55)
        {
            savings = finalVal -  228000;
        }
        else
        {
            savings = 0;
        }

        savings *= 0.3;
        if(savings >= 0)
        {
            textViewEligibleAmount.setText( "Eligible Amount: " + savings);
        }
    }
    public void reset(View view)
    {
        buttonDate.setText("Select date of birth");
        textViewAge.setText("Age: ");
        textViewEligibleAmount.setText("Eligible Amount: ");
        savings = 0;
        uInputAmount.setText("");
    }
}
