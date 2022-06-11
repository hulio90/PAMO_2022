package com.example.bmiapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.pow


class BMICalculatorActivity : AppCompatActivity() {

    private var weightValue = 0.0
    private var heightValue = 1.75
    private var bMIValue = 0.0
    private val numberFormat = NumberFormat.getNumberInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calc)

        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val heightV = findViewById<TextView>(R.id.bmi_height_value)
        val heightSeekBar = findViewById<SeekBar>(R.id.heightSeekBar)
        val btnChartActivity = findViewById<Button>(R.id.btnOpenChartActivity)

        weightEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!p0.isNullOrEmpty()) {
                    weightValue = p0.toString().toDouble()
                    calculate()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        heightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                heightValue = p1.toDouble().div(100)
                heightV.text = heightValue.toString()
                calculate()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        btnChartActivity.setOnClickListener{
            val chartActivity = Intent(this, ChartActivity::class.java)
            if (bMIValue > 0.0)
                startActivity(chartActivity)
        }

    }

    private fun calculate() {
        val bmiValueDisplay = findViewById<TextView>(R.id.bmi_value)
        val bmiSummary = findViewById<TextView>(R.id.bmi_summary)
        if (weightValue > 0.0) {
            val denominatorPow = heightValue.pow(2)
            bMIValue = weightValue / denominatorPow
            bmiValueDisplay.text = numberFormat.format(bMIValue).toString()
                if(bMIValue < 16.0){
                    bmiSummary.text ="wygłodzenie"
                    bmiSummary.setTextColor(Color.rgb(153, 0, 0));
                }
                else if(bMIValue >= 16.0 && bMIValue < 17.0){
                    bmiSummary.text = "wychudzenie"
                    bmiSummary.setTextColor(Color.rgb(255, 0, 0));
                }
                else if(bMIValue >= 17.0 && bMIValue < 18.5){
                    bmiSummary.text ="niedowaga"
                    bmiSummary.setTextColor(Color.rgb(230, 230, 0));
                }
                else if(bMIValue >= 18.5 && bMIValue < 25.0){
                    bmiSummary.text ="waga prawidłowa"
                    bmiSummary.setTextColor(Color.rgb(0, 255, 0));
                }
                else if(bMIValue >= 25.0 && bMIValue < 30.0){
                    bmiSummary.text ="nadwaga"
                    bmiSummary.setTextColor(Color.rgb(255, 128, 0));
                }
                else if(bMIValue >= 30.0 && bMIValue < 35.0){
                    bmiSummary.text ="otyłość I stopnia"
                    bmiSummary.setTextColor(Color.rgb(255, 0, 0));
                }
                else if(bMIValue >= 35.0 && bMIValue < 40.0){
                    bmiSummary.text ="otyłość II stopnia"
                    bmiSummary.setTextColor(Color.rgb(102, 0, 0));
                }
                else if(bMIValue >= 40.0){
                    bmiSummary.text ="otyłość III stopnia"
                    bmiSummary.setTextColor(Color.rgb(51, 0, 0));
                }
                else
                    bmiSummary.text =""
        }
    }
}



