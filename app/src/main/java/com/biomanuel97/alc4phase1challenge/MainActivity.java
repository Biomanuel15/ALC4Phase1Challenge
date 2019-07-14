package com.biomanuel97.alc4phase1challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aboutALC(View view) {
        Intent aboutALC = new Intent(this, AboutALC.class);
        startActivity(aboutALC);
    }

    public void myProfile(View view) {
        Intent myProfile = new Intent(this, MyProfile.class);
        startActivity(myProfile);
    }
}
