package com.test.buttoneditdatepickerdemo;

/**
 * http://www.tuicool.com/articles/aIBjAn
 * */

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends Activity {

    private static final int DATE_DIALOG_ID = 0;

    private int mYear;
    private int mMonth;
    private int mDay;
    private OnDateSetListener mDateSetListener;
    private Button mDateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                mDateButton.setText(getString(R.string.picked_date_format,
                        monthOfYear + 1, dayOfMonth, year));
            }
        };

        mDateButton = (Button) findViewById(R.id.details_date);
        mDateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear,
                        mMonth - 1, mDay);
        }
        return super.onCreateDialog(id);
    }

}
