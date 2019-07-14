package com.biomanuel97.alc4phase1challenge;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyProfile extends AppCompatActivity {

    private LinearLayout mOtherDetails;
    private LinearLayout mEditDetails;
    private int OptionMenu;
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        if (!(savedInstanceState == null)){
            ((TextView) findViewById(R.id.track_field)).setText(savedInstanceState.getString("track_field"));
            ((TextView) findViewById(R.id.country_field)).setText(savedInstanceState.getString("country_field"));
            ((TextView) findViewById(R.id.email_field)).setText(savedInstanceState.getString("email_field"));
            ((TextView) findViewById(R.id.phone_number_field)).setText(savedInstanceState.getString("phone_number_field"));
            ((TextView) findViewById(R.id.username_field)).setText(savedInstanceState.getString("username_field"));
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("My Profile");

        OptionMenu = R.menu.option_menu;

        mOtherDetails = (LinearLayout) findViewById(R.id.other_details);
        mEditDetails = (LinearLayout) findViewById(R.id.edit_details);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(OptionMenu, menu);
        mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("track_field",String.valueOf(((TextView) findViewById(R.id.track_field)).getText()));
        outState.putString("country_field",String.valueOf(((TextView) findViewById(R.id.country_field)).getText()));
        outState.putString("email_field",String.valueOf(((TextView) findViewById(R.id.email_field)).getText()));
        outState.putString("phone_number_field",String.valueOf(((TextView) findViewById(R.id.phone_number_field)).getText()));
        outState.putString("username_field",String.valueOf(((TextView) findViewById(R.id.username_field)).getText()));
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit){
            mEditDetails.setVisibility(View.VISIBLE);
            mOtherDetails.setVisibility(View.INVISIBLE);
            item.setVisible(false);
        }else if(item.getItemId() == R.id.save){
            changeDetails();
            mEditDetails.setVisibility(View.INVISIBLE);
            mOtherDetails.setVisibility(View.VISIBLE);
            item.setVisible(false);
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeDetails() {
        ((TextView) findViewById(R.id.track_field)).setText(getTextInE(R.id.edit_track_field));
        ((TextView) findViewById(R.id.country_field)).setText(getTextInE(R.id.edit_country_field));
        ((TextView) findViewById(R.id.email_field)).setText(getTextInE(R.id.edit_email_field));
        ((TextView) findViewById(R.id.phone_number_field)).setText(getTextInE(R.id.edit_phone_number_field));
        ((TextView) findViewById(R.id.username_field)).setText(getTextInE(R.id.edit_username_field));
    }
    private String getTextInE(int Id){
        return String.valueOf(((EditText) findViewById(Id)).getText());
    }
    private String getTextInT(int Id){
        return String.valueOf(((TextView) findViewById(Id)).getText());
    }
}
