package com.example.android.datetimepickerdialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private SimpleDateFormat mSimpleDateFormat;
    private Calendar mCalendar;
    private Activity mActivity;
    private TextView mDate;

    private SimpleDateFormat mSimpleDateFormat2;
    private Calendar mCalendar2;
    private Activity mActivity2;
    private TextView mDate2;

    private SimpleDateFormat mSimpleDateFormat3;
    private Calendar mCalendar3;
    private Activity mActivity3;
    private TextView mDate3;

    private TextView dateDiff;
    private Button calDiff;
    private TextView Clear;



    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;
        mSimpleDateFormat = new SimpleDateFormat("MMM/dd/yyyy  HH:mm a", Locale.getDefault());
        mDate = findViewById(R.id.contentMain);
        mDate.setOnClickListener(textListener);

        mActivity2 = this;
        mSimpleDateFormat2 = new SimpleDateFormat("MMM/dd/yyyy  HH:mm a", Locale.getDefault());
        mDate2 = findViewById(R.id.tV2);
        mDate2.setOnClickListener(textListener2);

        mActivity3 = this;
        mSimpleDateFormat3 = new SimpleDateFormat("MMM/dd/yyyy  HH:mm a", Locale.getDefault());
        mDate3 = findViewById(R.id.tvIncidentDate);
        mDate3.setOnClickListener(textListener3);

        dateDiff = findViewById(R.id.dateDiff);
        calDiff = findViewById(R.id.calDiff);
        Button reset2 = findViewById(R.id.clr_tdy_btn);
        Button reset3 = findViewById(R.id.clr_Crime_Date);
        Clear = findViewById(R.id.tV2);




        //*****  calculation to get date difference of date 1 and date 2   *****//
        calDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateDiff.setText("Clicked");
            }

        });

        Button reset = (Button) findViewById(R.id.clr_tdy_btn);

       reset.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("SetTextI18n")
           @Override
           public void onClick(View v) {
               Clear.setText("set_today's_date");

           }
       });



    }

    //* Defining the onClickListener, and start the DatePickerDialog with users current time*//
    private final View.OnClickListener textListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mCalendar = Calendar.getInstance();
            new DatePickerDialog(mActivity, mDateDataSet, mCalendar.get(Calendar.YEAR),
                    mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    };


    //* After user decided on a date, store those in our calender variable and the start the TimePickerDialog immediately   *//
    private final DatePickerDialog.OnDateSetListener mDateDataSet = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            new TimePickerDialog(mActivity, mTimeDataSet, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), true).show();
        }
    };


    //* After user decided on a time, save the into our calendar instance, and now parse what our calendar has into the TextView   *//
    private final TimePickerDialog.OnTimeSetListener mTimeDataSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendar.set(Calendar.MINUTE, minute);
            mDate.setText(mSimpleDateFormat.format(mCalendar.getTimeInMillis()));
        }
    };

//*********************  Start Second DateTime picker  *************************//
// //
// //
// //

    //* Defining the onClickListener, and start the DatePickerDialog with users current time*//
    private final View.OnClickListener textListener2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mCalendar2 = Calendar.getInstance();
            new DatePickerDialog(mActivity2, mDateDataSet2, mCalendar2.get(Calendar.YEAR),
                    mCalendar2.get(Calendar.MONTH), mCalendar2.get(Calendar.DAY_OF_MONTH)).show();
        }
    };


    //* After user decided on a date, store those in our calender variable and the start the TimePickerDialog immediately   *//
    private final DatePickerDialog.OnDateSetListener mDateDataSet2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar2.set(Calendar.YEAR, year);
            mCalendar2.set(Calendar.MONTH, month);
            mCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            new TimePickerDialog(mActivity2, mTimeDataSet2, mCalendar2.get(Calendar.HOUR_OF_DAY), mCalendar2.get(Calendar.MINUTE), true).show();
        }
    };


    //* After user decided on a time, save the into our calendar instance, and now parse what our calendar has into the TextView   *//
    private final TimePickerDialog.OnTimeSetListener mTimeDataSet2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendar2.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendar2.set(Calendar.MINUTE, minute);
            mDate2.setText(mSimpleDateFormat2.format(mCalendar2.getTimeInMillis()));
        }
    };

//***********************End Second DateTime picker ***************************//
//
//
//

//********************* Start Third DateTime picker ***************************//

    //* Defining the onClickListener, and start the DatePickerDialog with users current time*//
    private final View.OnClickListener textListener3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mCalendar3 = Calendar.getInstance();
            new DatePickerDialog(mActivity3, mDateDataSet3, mCalendar3.get(Calendar.YEAR),
                    mCalendar3.get(Calendar.MONTH), mCalendar3.get(Calendar.DAY_OF_MONTH)).show();
        }
    };


    //* After user decided on a date, store those in our calender variable and the start the TimePickerDialog immediately   *//
    private final DatePickerDialog.OnDateSetListener mDateDataSet3 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar3.set(Calendar.YEAR, year);
            mCalendar3.set(Calendar.MONTH, month);
            mCalendar3.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            new TimePickerDialog(mActivity3, mTimeDataSet3, mCalendar3.get(Calendar.HOUR_OF_DAY), mCalendar3.get(Calendar.MINUTE), true).show();
        }
    };


    //* After user decided on a time, save the into our calendar instance, and now parse what our calendar has into the TextView   *//
    private final TimePickerDialog.OnTimeSetListener mTimeDataSet3 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendar3.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendar3.set(Calendar.MINUTE, minute);
            mDate3.setText(mSimpleDateFormat3.format(mCalendar3.getTimeInMillis()));
        }
    };

//************************End Third DateTime picker  **************************//


}
