package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ChartActivity extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    String stringBMIValue;
    double doubleBMIValue;
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        String bmiValueToString = getIntent().getStringExtra("bmiValueToString");
        doubleBMIValue = Double.parseDouble(bmiValueToString);

        chart = (BarChart) findViewById(R.id.chart);

        bmiFormatter();
        getTodayDate();

        exampleChart();
    }

    private void bmiFormatter() {
        stringBMIValue = df.format(doubleBMIValue);
        System.out.println(stringBMIValue);
    }

    private void getTodayDate() {
        String currentDate = sdf.format(new Date());
        System.out.println(currentDate);
    }

    public void exampleChart() {
        ArrayList<BarEntry> bmi = new ArrayList<BarEntry>();

        float getBMI = Float.parseFloat(stringBMIValue);

        bmi.add(new BarEntry(1,35.43f));
        bmi.add(new BarEntry(2,35.73f));
        bmi.add(new BarEntry(3,35.55f));
        bmi.add(new BarEntry(4,35.21f));
        bmi.add(new BarEntry(5,35.28f));
        bmi.add(new BarEntry(6,35.24f));
        bmi.add(new BarEntry(7,getBMI));

        BarDataSet barDataSet = new BarDataSet(bmi, "bmi");
        barDataSet.setValueTextSize(16f);
        BarData barData = new BarData(barDataSet);
        chart.setData(barData);
    }

}