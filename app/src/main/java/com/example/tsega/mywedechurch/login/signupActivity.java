package com.example.tsega.mywedechurch.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tsega.mywedechurch.R;

/**
 * Created by tsega on 21-Nov-17.
 */

public class signupActivity extends AppCompatActivity implements View.OnClickListener{



    Button btreg;
    EditText edus, edname, edlname,edrps, edps, edage, edmail, edphon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btreg=(Button)findViewById(R.id.btreg);
       edus=(EditText)findViewById(R.id.edus);
        edps=(EditText)findViewById(R.id.edps);
        edname=(EditText)findViewById(R.id.edname);
        edlname=(EditText)findViewById(R.id.edlname);
        edrps=(EditText)findViewById(R.id.edrpsss);
        edphon=(EditText)findViewById(R.id.edphon);
        edps=(EditText)findViewById(R.id.edps);
        edage=(EditText)findViewById(R.id.edage);
        edmail=(EditText)findViewById(R.id.edmail);



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btreg:

                break;


        }
    }







}


