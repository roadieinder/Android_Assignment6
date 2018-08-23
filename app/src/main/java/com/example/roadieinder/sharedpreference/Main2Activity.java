package com.example.roadieinder.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String string=sharedPreferences.getString("Name",null);
        String string1=sharedPreferences.getString("Mobile",null);
        String string2=sharedPreferences.getString("Email",null);

        TextView name=findViewById(R.id.nameT);
        name.setText(string);

        TextView mobile=findViewById(R.id.mobileT);
        mobile.setText(string1);

        TextView email=findViewById(R.id.emailT);
        email.setText(string2);
    }

}
