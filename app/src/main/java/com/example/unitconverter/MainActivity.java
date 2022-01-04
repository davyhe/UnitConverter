package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Widgets
    EditText editTextNumber;
    TextView textView, textView2, unit_textView, Final_Result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        unit_textView = findViewById(R.id.unit_textView);
        Final_Result = findViewById(R.id.Final_Result);

        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);

        // Adding a click event for the button (Execute convert method when clicked)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling ConvertFromKiloToPounds Method

                ConvertFromKiloToPounds();
                editTextNumber.getText().clear(); // clean the text after user input
            }
        });

    }

    private void ConvertFromKiloToPounds() {
        // This method will convert the values entered in edit text
        // From Kg to Pounds

        String valueEnterKilo = editTextNumber.getText().toString();

        if (valueEnterKilo.isEmpty()) {
            valueEnterKilo = "0";

        }

        // Convert string to number
        double kilo = Double.parseDouble(valueEnterKilo);

        // convert kilo to pounds
        double pounds = kilo * 2.205;
        pounds = Double.parseDouble(String.format("%.3f", pounds)); // leave the result with 3 decimals place

        //Display the value resulted in Final_Result
        Final_Result.setText("" + pounds);
    }
}