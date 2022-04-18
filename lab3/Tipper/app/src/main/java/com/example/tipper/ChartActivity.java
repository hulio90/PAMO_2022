package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ChartActivity extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");

    String stringBMIValue;
    double doubleBMIValue;
    BarChart chart;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        String bmiValueToString = getIntent().getStringExtra("bmiValueToString");
        doubleBMIValue = Double.parseDouble(bmiValueToString);

        chart = (BarChart) findViewById(R.id.chart);

        bmiFormatter();
        getTodayDate();

        //first version of chart
        //exampleChart();

        //second version of chart(printing date + month as x value)
        showBMIBars();
    }

    private void bmiFormatter() {
        stringBMIValue = df.format(doubleBMIValue);
        System.out.println(stringBMIValue);
    }

    private void getTodayDate() {
        currentDate = sdf.format(new Date());
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

    private void showBMIBars(){
        double getBMIDouble = Double.parseDouble(stringBMIValue);

        ArrayList<Double> bmiValueList = new ArrayList<Double>();
        bmiValueList.add((double)35.65);
        bmiValueList.add((double)35.52);
        bmiValueList.add((double)35.44);
        bmiValueList.add((double)getBMIDouble);

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < bmiValueList.size(); i++) {
            BarEntry barEntry = new BarEntry(i+1, bmiValueList.get(i).floatValue());
            entries.add(barEntry);
        }
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("22.02");
        xAxisLabel.add("02.03");
        xAxisLabel.add("12.03");
        xAxisLabel.add(currentDate);
        xAxisLabel.add("");

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(12);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setAxisLineColor(Color.BLACK);
        xAxis.setAxisMinimum(0 + 0.5f);
        xAxis.setAxisMaximum(entries.size() + 0.5f);
        xAxis.setLabelCount(xAxisLabel.size(), true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xAxisLabel.get((int) value);
            }
        });

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

        YAxis leftAxis = chart.getAxisLeft();
        rightAxis.setTextSize(12);
        rightAxis.setTextColor(Color.BLACK);
        rightAxis.setAxisLineColor(Color.BLACK);
        rightAxis.setLabelCount(4, true);

        BarDataSet barDataSet = new BarDataSet(entries, "BMI");
        barDataSet.setColor(Color.rgb(0, 0, 255));
        barDataSet.setFormSize(14f);
        barDataSet.setValueTextSize(12f);
        BarData data = new BarData(barDataSet);
        chart.setData(data);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);
    }

}