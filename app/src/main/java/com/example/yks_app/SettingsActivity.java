package com.example.yks_app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    Intent intent;

    TextView languageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.sToolbar);
        toolbar.setTitle(R.string.settings);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton turkeyButton = findViewById(R.id.turkeyButton);
        ImageButton engButton = findViewById(R.id.engButton);

        intent = new Intent(this, HomepageActivity.class);

        turkeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("tr");
            }
        });

        engButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
            }
        });
    }

    /*
    @SuppressWarnings("deprecation")
    private void setLocale(Locale locale){
        SharedPrefUtils.saveLocale(locale); // optional - Helper method to save the selected language to SharedPreferences in case you might need to attach to activity context (you will need to code this)
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            configuration.setLocale(locale);
        } else{
            configuration.locale=locale;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            getApplicationContext().createConfigurationContext(configuration);
        } else {
            resources.updateConfiguration(configuration,displayMetrics);
        }
    } */

    public void setLocale(final String language) {
        Locale myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        languageTextView = findViewById(R.id.languageTextView);
        if(languageTextView.getText().equals("Language")) {
            languageTextView.setText("Dil");
        } else {
            languageTextView.setText("Language");
        }
        Snackbar snackbar = Snackbar.make(findViewById(R.id.settingsCL), getString(R.string.LanguageText), Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("tr")) {
                    setLocale("en");
                } else {
                    setLocale("tr");
                }
                Toast.makeText(getApplicationContext(), getString(R.string.UNDO_TEXT), Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();

        intent.putExtra(HomepageActivity.LANGUAGE, language);

    }

    //backbutton on toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //finish(); // close this activity and return to preview activity (if there is any)
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

