package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChartActivity extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    String stringBMIValue;
    double doubleBMIValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        String bmiValueToString = getIntent().getStringExtra("bmiValueToString");
        doubleBMIValue = Double.parseDouble(bmiValueToString);

        bmiFormatter();
        getTodayDate();
    }

    private void bmiFormatter() {
        stringBMIValue = df.format(doubleBMIValue);
        System.out.println(stringBMIValue);
    }

    private void getTodayDate() {
        String currentDate = sdf.format(new Date());
        System.out.println(currentDate);
    }
}