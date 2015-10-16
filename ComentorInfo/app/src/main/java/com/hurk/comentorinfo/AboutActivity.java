package com.hurk.comentorinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_detail);

        AboutFragment fragment = new AboutFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.website_detail_container, fragment)
                .commit();


    }

}
