package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class KCalsCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();

    private TextView KcalTextView;
    private Spinner spinner;
    private String str;
    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private int age = 0;
    private double weight = 0.0;
    private int height = 0;
    private double KcalValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcals_calculator);

        KcalTextView = (TextView ) findViewById(R.id.KcalTextView);
        spinner = (Spinner) findViewById(R.id.sex_spinner);

        KcalTextView.setText(numberFormat.format(0));

        Spinner spinner = (Spinner) findViewById(R.id.sex_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sex_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ageEditText = (EditText) findViewById(R.id.input_your_age);
        weightEditText = (EditText) findViewById(R.id.input_your_weight);
        heightEditText = (EditText) findViewById(R.id.input_your_height);
        heightEditText.addTextChangedListener(heightEditTextWatcher);
    }

    private void calculate() {
        age = Integer.parseInt(ageEditText.getText().toString());
        weight = Double.parseDouble(weightEditText.getText().toString());
        height = Integer.parseInt(heightEditText.getText().toString());

        //male
        KcalValue = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);

        //female
        //KcalValue = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);

        KcalTextView.setText(numberFormat.format(KcalValue));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        str = spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence charSequence, int start,
                                  int before, int count) {
            calculate();
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int start,
                                      int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

}