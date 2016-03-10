package com.vlabs.medicinetracker.utils;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vlad on 3/10/16.
 */
public class DataUtils {

    public static final String DATE_PATTERN = "dd/MM/yyyy";

    public static Date currentDate() {
        return new Date();
    }

    public static String formattedDate(final Date date) {
        final SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
        return df.format(date);
    }

    public static void selectDate(final Context context, final OnDateSetListener listener) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(context, listener, year, month, day).show();
    }

}