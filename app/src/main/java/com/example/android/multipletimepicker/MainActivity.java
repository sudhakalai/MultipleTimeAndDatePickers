package com.example.android.multipletimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Declaring global variables
    private Button timePickerOne;
    private Button timePickerTwo;
    private Button timePickerThree;
    private static TextView time1;
    private static TextView time2;
    private static TextView time3;
    private Button datePickerOne;
    private Button datePickerTwo;
    private Button datePickerThree;
    private static TextView date1;
    private static TextView date2;
    private static TextView date3;
    private TimePickerFragment mTimePickerFragment;
    private DatePickerFragment mDatePickerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intializing the buttons
        timePickerOne = findViewById(R.id.time_picker_1);
        timePickerTwo = findViewById(R.id.time_picker_2);
        timePickerThree = findViewById(R.id.time_picker_3);
        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        datePickerOne = findViewById(R.id.date_picker_1);
        datePickerTwo = findViewById(R.id.date_picker_2);
        datePickerThree = findViewById(R.id.date_picker_3);
        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        date3 = findViewById(R.id.date3);
        mTimePickerFragment = new TimePickerFragment();
        mDatePickerFragment = new DatePickerFragment();

        //setting onClickListeners on the buttons
        timePickerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimePickerFragment.setPickerValue(TimePickerFragment.FIRST_PICKER);
                mTimePickerFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        timePickerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimePickerFragment.setPickerValue(TimePickerFragment.SECOND_PICKER);
                mTimePickerFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        timePickerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimePickerFragment.setPickerValue(TimePickerFragment.THIRD_PICKER);
                mTimePickerFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        datePickerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatePickerFragment.setPickerValue(DatePickerFragment.FIRST_PICKER);
                mDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        datePickerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatePickerFragment.setPickerValue(DatePickerFragment.SECOND_PICKER);
                mDatePickerFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });

        datePickerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatePickerFragment.setPickerValue(DatePickerFragment.THIRD_PICKER);
                mDatePickerFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });



    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        public static final int FIRST_PICKER = 1;
        public static final int SECOND_PICKER = 2;
        public static final int THIRD_PICKER = 3;

        int pickerValue = 1;

        public void setPickerValue(int value){
            pickerValue = value;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }


        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendar.set(Calendar.MINUTE, minute);
            SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
            String timeSelected = format.format(calendar.getTime());

            if(pickerValue == 1){
                time1.setText(timeSelected);
            }else if(pickerValue == 2){
                time2.setText(timeSelected);
            }else if(pickerValue == 3){
                time3.setText(timeSelected);
            }
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        public static final int FIRST_PICKER = 1;
        public static final int SECOND_PICKER = 2;
        public static final int THIRD_PICKER = 3;

        int pickerValue = 1;

        public void setPickerValue(int value){
            pickerValue = value;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String dateSelected = format.format(calendar.getTime());

            if(pickerValue == 1){
                date1.setText(dateSelected);
            }else if(pickerValue == 2){
                date2.setText(dateSelected);
            }else if(pickerValue == 3){
                date3.setText(dateSelected);
            }
        }
    }
}
