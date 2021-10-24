package com.example.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText fromValue;
    Spinner fromUnit;
    Spinner toUnit;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromValue = findViewById(R.id.from);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        answer = findViewById(R.id.answer);
    }

    double toMeters(double val, String unit){

        if(unit.equals("mm")) return val/1000;
        if(unit.equals("cm")) return val/100;
        if(unit.equals("m")) return val;
        if(unit.equals("km")) return val*1000;
        if(unit.equals("ft")) return val/3.2808;
        if(unit.equals("in")) return val/39.370;

        return -1;
    }

    double toUnit(double val, String unit){

        if(unit.equals("mm")) return val*1000;
        if(unit.equals("cm")) return val*100;
        if(unit.equals("m")) return val;
        if(unit.equals("km")) return val/1000;
        if(unit.equals("ft")) return val*3.2808;
        if(unit.equals("in")) return val*39.370;

        return -1;
    }

    public void calculateAnswer(View view) {

        DecimalFormat df = new DecimalFormat("0.00000");

        double input = Double.parseDouble(fromValue.getText().toString());
        String fUnit = fromUnit.getSelectedItem().toString();
        String tUnit = toUnit.getSelectedItem().toString();

        double ans = toUnit( toMeters(input, fUnit), tUnit );
        answer.setText(df.format(ans));
    }
}