package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    Button btnOpenCalculator;
    Button btnOpenKcalCalculator;
    Button btnOpenQuizActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnOpenCalculator = (Button)findViewById(R.id.btnOpenCalculator);
        btnOpenKcalCalculator = (Button)findViewById(R.id.btnOpenKcalCalculator);
        btnOpenQuizActivity = (Button)findViewById(R.id.btnOpenQuizActivity);

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

        //Quiz
        btnOpenQuizActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOpenQuizActivityOnButtonClick();
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

    private void btnOpenQuizActivityOnButtonClick() {
        Intent quizActivity = new Intent(this, QuizActivity.class);
        startActivity(quizActivity);
    }
}