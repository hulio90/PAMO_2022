package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    Button btnOpenCalculator;
    Button btnOpenKcalCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnOpenCalculator = (Button)findViewById(R.id.btnOpenCalculator);
        btnOpenKcalCalculator = (Button)findViewById(R.id.btnOpenKcalCalculator);

        //BMI Calculator
        btnOpenCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalculatorActivityOnButtonClick();
            }
        });

        //Kcal Calculator
        btnOpenKcalCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openKcalCalculatorActivityOnButtonClick();
            }
        });
    }

    //BMI method
    private void openCalculatorActivityOnButtonClick() {
        Intent calculatorActivity = new Intent(this, BMICalculatorActivity.class);
        startActivity(calculatorActivity);
    }

    //kcal method
    private void openKcalCalculatorActivityOnButtonClick() {
        Intent kcalCalculatorActivity = new Intent(this, KCalsCalculatorActivity.class);
        startActivity(kcalCalculatorActivity);
    }

}