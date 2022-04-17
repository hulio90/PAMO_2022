/**
 * BMI Calculator
 * Simple Body mass index calculator in Java
 *
 * @author  Sebastian Lewandowski
 * @version 1.0
 */

package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

public class BMICalculatorActivity extends AppCompatActivity {

    // weight formatter
    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();

    private double weightValue = 0.0; // weight value entered by the user
    private double heightValue = 1.75; // initial height value
    private double BMIValue =0.0;
    private TextView weightTextView; // shows formatted weight
    private TextView heightTextView; // shows height value set up by user
    private TextView BMITextView; // shows calculated BMI value
    private TextView SummaryTextView;
    private Button btnOpenChartActivity;

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_bmi_calc); // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        BMITextView = (TextView) findViewById(R.id.BMITextView);
        SummaryTextView = (TextView) findViewById(R.id.SummaryTextView);
        btnOpenChartActivity = (Button) findViewById(R.id.btnOpenChartActivity);

        BMITextView.setText(numberFormat.format(0));

        // set weightEditText's TextWatcher
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        // set heightSeekBar's OnSeekBarChangeListener
        SeekBar heightSeekBar =
                (SeekBar) findViewById(R.id.heightSeekBar);
        heightSeekBar.setOnSeekBarChangeListener(seekBarListener);

        btnOpenChartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BMICalculatorActivity.this, ChartActivity.class);
                OpenChartActivityOnButtonClick();
                if (BMIValue != 0.0) {
                    String bmiValueToString = Double.toString(BMIValue);
                    i.putExtra("bmiValueToString", bmiValueToString);
                    startActivity(i);
                }
            }
        });
    }

    // calculate and display BMI value
    private void calculate() {
        // format percent and display in percentTextView
        heightTextView.setText(numberFormat.format(heightValue));

        // calculate the BMI value
        double denominator_pow = Math.pow(heightValue,2);
        BMIValue = weightValue / denominator_pow;

        // display formatted BMI value
        BMITextView.setText(numberFormat.format(BMIValue));

        // print summary for calculated BMI value
        if(BMIValue < 16.0){
            SummaryTextView.setText("wygłodzenie");
            SummaryTextView.setTextColor(Color.rgb(153, 0, 0));
        }
        else if(BMIValue >= 16.0 && BMIValue < 17.0){
            SummaryTextView.setText("wychudzenie");
            SummaryTextView.setTextColor(Color.rgb(255, 0, 0));
        }
        else if(BMIValue >= 17.0 && BMIValue < 18.5){
            SummaryTextView.setText("niedowaga");
            SummaryTextView.setTextColor(Color.rgb(230, 230, 0));
        }
        else if(BMIValue >= 18.5 && BMIValue < 25.0){
            SummaryTextView.setText("waga prawidłowa");
            SummaryTextView.setTextColor(Color.rgb(0, 255, 0));
        }
        else if(BMIValue >= 25.0 && BMIValue < 30.0){
            SummaryTextView.setText("nadwaga");
            SummaryTextView.setTextColor(Color.rgb(255, 128, 0));
        }
        else if(BMIValue >= 30.0 && BMIValue < 35.0){
            SummaryTextView.setText("otyłość I stopnia");
            SummaryTextView.setTextColor(Color.rgb(255, 0, 0));
        }
        else if(BMIValue >= 35.0 && BMIValue < 40.0){
            SummaryTextView.setText("otyłość II stopnia");
            SummaryTextView.setTextColor(Color.rgb(102, 0, 0));
        }
        else if(BMIValue >= 40.0){
            SummaryTextView.setText("otyłość III stopnia");
            SummaryTextView.setTextColor(Color.rgb(51, 0, 0));
        }
        else
            SummaryTextView.setText("");
    }

    // listener object for the SeekBar's progress changed events
    private final OnSeekBarChangeListener seekBarListener =
            new OnSeekBarChangeListener() {
                // update height, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    heightValue = progress / 100.0 ; // set height based on progress
                    calculate(); // calculate and display BMI
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) { }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) { }
            };

    // listener object for the EditText's text-changed events
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get weight and display formatted value
                weightValue = Double.parseDouble(s.toString()) / 10.0;
                weightTextView.setText(numberFormat.format(weightValue));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                weightValue = 0.0;
            }

            calculate(); // update the BMI TextView
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private void OpenChartActivityOnButtonClick() {
        Intent openChartActivity = new Intent(this, ChartActivity.class);
        if(BMIValue != 0.0)
            startActivity(openChartActivity);
    }
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
