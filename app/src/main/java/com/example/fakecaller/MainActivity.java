package com.example.fakecaller;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL_PERMISSION = 1;

    EditText edit_text;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text = findViewById(R.id.edit_text);


    }

    public void makeCall(View view) {
        String phoneNumber = edit_text.getText().toString();
        if (!phoneNumber.isEmpty()) {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                initiateCall(phoneNumber);
            }
        } else {
           // showNoInternetDialog();
            edit_text.setError("Please enter phone number");
        }
    }

    // Showing the dialog for no internet connection

  /* private void showNoInternetDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.no_internet_dialog);
        dialog.setCancelable(true);
        dialog.show();
    }*/

    private void initiateCall(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }
}
