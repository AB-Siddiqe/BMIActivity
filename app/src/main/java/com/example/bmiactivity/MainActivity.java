package com.example.bmiactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText weight, height;
    Button calculate;
    TextView category, result;
    LinearLayout bacground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        category = findViewById(R.id.category);
        bacground = findViewById(R.id.bacground);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double w = Double.parseDouble(weight.getText().toString());
                double h = Double.parseDouble(height.getText().toString());
                double bmi = w / (h * h);

                if (bmi < 18.4 && bmi > 17) {
                    category.setText(" Thinness");
                    bacground.setBackgroundColor(getColor(R.color.yellow));

                } else if (bmi < 25 && bmi > 18.4) {
                    category.setText(" normal");
                    bacground.setBackgroundColor(getColor(R.color.green));
                } else if (bmi < 29.4 && bmi > 25) {
                    category.setText("Overweight");
                    bacground.setBackgroundColor(getColor(R.color.Beer));
                } else {
                    category.setText("Worning");
                    bacground.setBackgroundColor(getColor(R.color.red));
                }
                result.setText(String.format("%.2f", bmi));
            }
        });

    }
}