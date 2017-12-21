package com.example.tsega.mywedechurch;

import android.content.Context;
import android.widget.Toast;

import com.example.tsega.mywedechurch.login.signupActivity;

import layout.MainFragment;

/**
 * Created by tsega on 29-Nov-17.
 */

public class Message {
    public static void message(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
