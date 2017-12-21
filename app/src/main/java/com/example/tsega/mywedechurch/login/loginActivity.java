package com.example.tsega.mywedechurch.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tsega.mywedechurch.MainActivity;
import com.example.tsega.mywedechurch.R;

/**
 * Created by tsega on 21-Nov-17.
 */

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btlogin;
    TextView  link_skip,txregsterlink;
    EditText edus,edps;

   // VivzHelper vivzHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btlogin=(Button)findViewById(R.id.btlogin);
        link_skip=(TextView) findViewById(R.id.link_skip);
        txregsterlink=(TextView) findViewById(R.id.txregsterlink);
        edus=(EditText)findViewById(R.id.edus);
        edps=(EditText)findViewById(R.id.edps);




        btlogin.setOnClickListener(this);
        txregsterlink.setOnClickListener(this);
        link_skip.setOnClickListener(this);


     //   vivzHelper=new VivzHelper(this);
    }






    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btlogin:
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.txregsterlink:
                startActivity(new Intent(this, signupActivity.class ));
                break;
            case R.id.link_skip:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}
