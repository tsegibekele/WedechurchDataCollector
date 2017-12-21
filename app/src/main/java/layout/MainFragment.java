package layout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.tsega.mywedechurch.MainActivity;
import com.example.tsega.mywedechurch.Message;
import com.example.tsega.mywedechurch.R;
import com.example.tsega.mywedechurch.VivzDataBaseAdapter;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {




    EditText input_church_name, input_church_email, input_church_phone, input_church_website,input_church_start_time,input_church_end_date, input_church_location,input_church_program;
    AppCompatButton btn_pic, btn_gps, btn_submit;
    VivzDataBaseAdapter vivzHelper;
    ListView ScheduleList;




    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        input_church_name = (EditText) view.findViewById(R.id.input_church_name);
        input_church_email = (EditText) view.findViewById(R.id.input_church_email);
        input_church_phone = (EditText) view.findViewById(R.id.input_church_phone);
        input_church_website = (EditText) view.findViewById(R.id.input_church_website);
        input_church_location = (EditText) view.findViewById(R.id.input_church_location);
        input_church_program = (EditText) view.findViewById(R.id.input_church_program);
        input_church_start_time = (EditText) view.findViewById(R.id.input_church_start_time);
        input_church_end_date = (EditText) view.findViewById(R.id.input_church_end_date);

        vivzHelper=new VivzDataBaseAdapter(getContext());






        btn_pic = (AppCompatButton) view.findViewById(R.id.btn_pic);
        btn_gps = (AppCompatButton) view.findViewById(R.id.btn_gps);
        btn_submit = (AppCompatButton) view.findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener((View.OnClickListener) this);


        btn_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addChurch(view);
                Intent i = new Intent(this, church_schedule.class);
                startActivity(i);
                break;


            }
        });

        return view;
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            Toast.makeText(getActivity(),"Invalid information provided!!!",Toast.LENGTH_LONG).show();
            return;
        }else {
            sendRegisterRequest();
        }




    }

    private void sendRegisterRequest() {
    }


    public boolean validate() {
        boolean valid = true;
        String churchname = input_church_name.getText().toString();
        String email = input_church_email.getText().toString();
        String website = input_church_website.getText().toString();
        String mobile = input_church_phone.getText().toString();
        String location = input_church_location.getText().toString();
        String program = input_church_program.getText().toString();
        String time = input_church_start_time.getText().toString();
        String date = input_church_end_date.getText().toString();




        if (churchname.isEmpty() ) {
          input_church_name.setError("insert church name");
            valid = false;
        } else {
            input_church_name.setError(null);
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            valid = false;
        } else {
            input_church_email.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=9) {
            input_church_phone.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            input_church_phone.setError(null);
        }

        if (program.isEmpty() ) {
            input_church_program.setError("insert program name to the fild");
            valid = false;
        } else {
            input_church_program.setError(null);}

        if (time.isEmpty() ) {
            input_church_start_time.setError("insert program time to the fild");
            valid = false;
        } else {
            input_church_start_time.setError(null);}

        if (date.isEmpty() ) {
            input_church_end_date.setError("insert program date to the fild");
            valid = false;
        } else {
            input_church_end_date.setError(null);
        }

        if (location.isEmpty() ) {
            input_church_location.setError("insert program location to the fild");
            valid = false;
        } else {
            input_church_location.setError(null);
        }



        return valid;
    }
    public void addChurch(View view)
    {

        String Church_NAME=input_church_name.getText().toString();
        String Church_Location=input_church_location.getText().toString();
        //String Church_Image=input_church_image.getText().toString();
        String Email=input_church_email.getText().toString();
        String Phone_no=input_church_phone.getText().toString();
        String Website=input_church_website.getText().toString();

        long id=vivzHelper.insertData(Church_NAME,Church_Location,Email,Phone_no,Website);

        if(id<0)
        {
            Message.message(getContext(), "Unsuccessful");
        }
        else{
            Message.message(getContext(), "Successfully Inserted A Row" );
        }



    }

}
    


