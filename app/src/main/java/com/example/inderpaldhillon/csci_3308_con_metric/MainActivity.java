package com.example.inderpaldhillon.csci_3308_con_metric;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Spinner metricConverstionSpinnerSelect;
    private ArrayList<String> metricConverstionList;
    ArrayAdapter metricConverstionSpinnerListAdapter;
    EditText displayMetrics;
    public  int positionSelected= 0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spnner to show conversion metrics in select list
        metricConverstionSpinnerSelect = (Spinner) findViewById(R.id.metric_list);
        displayMetrics = (EditText) findViewById(R.id.hint_input);
        submit=(Button) findViewById(R.id.submit);

        metricConverstionList = new ArrayList<>();
        //add metric conversion list in arraylist
        metricConverstionList.add(getResources().getString(R.string.metric1));
        metricConverstionList.add(getResources().getString(R.string.metric2));
        metricConverstionList.add(getResources().getString(R.string.metric3));

        //adapter to fill the select list with metricConverstionList array values
        metricConverstionSpinnerListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,metricConverstionList);
        metricConverstionSpinnerSelect.setAdapter(metricConverstionSpinnerListAdapter);

        //select list spinner listener
        metricConverstionSpinnerSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                positionSelected =i;

                //set hint based on position selected
                switch (positionSelected) {
                    case 0:
                        displayMetrics.setHint(getResources().getString(R.string.hint1));
                        break;
                    case 1:
                        displayMetrics.setHint(getResources().getString(R.string.hint2));
                        break;
                    case 2:
                        displayMetrics.setHint(getResources().getString(R.string.hint3));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!displayMetrics.getText().toString().equalsIgnoreCase(""))
                {
                    switch (positionSelected) {
                        //convert celsius to fahrenhite
                        case 0:
                            Double fahrenhite = (Double.parseDouble(displayMetrics.getText().toString()) * 9.0 / 5) + 32;
                            displayMetrics.setText(Double.toString(fahrenhite));
                            break;
                        //convert kg to pounds
                        case 1:
                            Double pounds = Double.parseDouble(displayMetrics.getText().toString()) * 2.2046;
                            displayMetrics.setText(Double.toString(pounds));
                            break;
                        //convert miles to km
                        case 2:
                            Double miles = Double.parseDouble(displayMetrics.getText().toString()) * 0.62137;
                            displayMetrics.setText(Double.toString(miles));
                            break;
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter value to convert",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}





