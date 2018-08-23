package com.example.roadieinder.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner s1,s2;
EditText name,mobile,email;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.nameET);
        mobile=(EditText) findViewById(R.id.mobileET);
        email=(EditText) findViewById(R.id.emailET);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
         final SharedPreferences.Editor editor=sharedPreferences.edit();

         s1=(Spinner)findViewById(R.id.countrysp);
         s2=(Spinner)findViewById(R.id.statesp);


         List<String> list = new ArrayList<>();
        list.add("Select Country");
         list.add("India");
        list.add("USA");
        list.add("Canda");
        list.add("Pakistan");
        list.add("Australia");

        ArrayAdapter<String> countryspinner = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,list);
           countryspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           s1.setAdapter(countryspinner);
           s1.setOnItemSelectedListener(this);


        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=name.getText().toString();
                editor.putString("Name",string);
                String string1=mobile.getText().toString();
                editor.putString("Mobile",string1);
                String string2=email.getText().toString();
                editor.putString("Email",string2);
                editor.apply();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String st = String.valueOf(s1.getSelectedItem());
        if (st.contentEquals("India")){

            List<String> list = new ArrayList<>();
            list.add("Haryana");
            list.add("Punjab");
            list.add("UP");
            list.add("Bihar");
            list.add("New Delhi");

            ArrayAdapter<String> statespinner = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item,list);
            statespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s2.setAdapter(statespinner);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
