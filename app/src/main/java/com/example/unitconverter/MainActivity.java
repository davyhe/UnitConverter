package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


//public class MainActivity extends AppCompatActivity
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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


        String [] items = {"Kg To Pounds", "Meter To Foot", "Centimeter To Inch", "Liter To Gallon",
                            "Milliliter To Ounce", "Kilometer To Miles", "Celsius To Fahrenheit"};
        // implement Select_Unit to allow user to choose unit to convert
        Spinner spinner = (Spinner) findViewById(R.id.Select_Unit);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, items);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);


        // Adding a click event for the button (Execute convert method when clicked)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling ConvertFromKiloToPounds Method
                String unit = spinner.getSelectedItem().toString(); // set the
                unit_textView.setText(editTextNumber.getText().toString()+" "+spinner.getSelectedItem().toString());
                ConvertFromA_To_B(unit);
                editTextNumber.getText().clear(); // clean the text after user input
            }
        });

    }

    // Responding to User Selections
    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        String unit = parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(),unit, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



    private void ConvertFromA_To_B(String unit) {
        // This method will convert the values entered in edit text
        // From Kg to Pounds

        String valueEnter = editTextNumber.getText().toString();

        if (valueEnter.isEmpty()) { // if the input is empty, set the default input as 0
            valueEnter = "0";

        }
        double result;

        if(unit == "Kg To Pounds"){
            // Convert string to number
            double kilo = Double.parseDouble(valueEnter);

            // convert kilo to pounds
            result = kilo * 2.20462;
        }
        else if(unit == "Meter To Foot"){
            // Convert string to number
            double meter = Double.parseDouble(valueEnter);

            // convert meter to foot
            result = meter * 3.28084;
        }
        else if(unit == "Centimeter To Inch"){
            // Convert string to number
            double centimeter = Double.parseDouble(valueEnter);

            // convert centimeter to inch
            result = centimeter * 0.393701;
        }
        else if(unit == "Liter To Gallon"){
            // Convert string to number
            double liter = Double.parseDouble(valueEnter);

            // convert liter to gallon
            result = liter * 0.264172;
        }
        else if(unit == "Milliliter To Ounce"){
            // Convert string to number
            double milliliter = Double.parseDouble(valueEnter);

            // convert milliliter to ounce
            result = milliliter * 0.033814;
        }
        else if(unit == "Kilometer To Miles"){
            // Convert string to number
            double kilometer = Double.parseDouble(valueEnter);

            // convert kilometer to miles
            result = kilometer * 0.621371;
        }
        else {
            // Convert string to number
            double celsius = Double.parseDouble(valueEnter);

            // convert celsius to fahrenheit
            result = (celsius * 1.8) + 32;
        }


        DecimalFormat df = new DecimalFormat("#.##");
        result = Double.parseDouble(df.format(result)); // leave the result with 3 decimals place

        //Display the value resulted in Final_Result
        Final_Result.setText("" + result);
    }
}

