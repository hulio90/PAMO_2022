package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    Button btnOpenCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnOpenCalculator = (Button)findViewById(R.id.btnOpenCalculator);

        btnOpenCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalculatorActivityOnButtonClick();
            }
        });
    }
    private void openCalculatorActivityOnButtonClick() {
        Intent calculatorActivity = new Intent(this, BMICalculatorActivity.class);
        startActivity(calculatorActivity);
    }

}