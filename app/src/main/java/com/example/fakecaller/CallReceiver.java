package com.example.fakecaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            // Get the original number dialed by the user
            String originalNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            // Get the fake number (replace it with your desired fake number)
            String fakeNumber = "1234567890";

            // Modify the outgoing call number
            setResultData(fakeNumber);

            // Optionally, you can show a toast indicating the original and fake numbers
            Toast.makeText(context, "Original Number: " + originalNumber + "\nFake Number: " + fakeNumber, Toast.LENGTH_LONG).show();
        }
    }
}


