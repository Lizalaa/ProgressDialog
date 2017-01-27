package com.example.sujal.progressdialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Exit");
        dialogBuilder.setMessage("Are you sure to exit?");
        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialogBuilder.setNegativeButton("No", null);
        dialogBuilder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });
    }

    public void showProgressDialog() {
        final ProgressDialog progress;
        progress = ProgressDialog.show(this, "Please Wait..", "Loading", true); //back garda najane
        progress.show();
        new CountDownTimer(4000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                progress.setMessage("Loading..." + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {
                progress.dismiss();
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Setting is pressed", Toast.LENGTH_LONG).show();
        } else if (id == android.R.id.home) {
            onBackPressed();
            //finish();
        } else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search is pressed", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}