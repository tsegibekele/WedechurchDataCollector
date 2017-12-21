package layout;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tsega.mywedechurch.MainActivity;
import com.example.tsega.mywedechurch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class church_schedule extends Fragment {

    EditText input_church_program, input_church_start_time, input_church_end_date;
    AppCompatButton btn_save;




    public church_schedule() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_church_schedule, container, false);


        input_church_program = (EditText) view.findViewById(R.id.input_church_program);
        input_church_start_time = (EditText) view.findViewById(R.id.input_church_start_time);
        input_church_end_date = (EditText) view.findViewById(R.id.input_church_end_date);


        btn_save = (AppCompatButton) view.findViewById(R.id.btn_save);

        btn_save.setOnClickListener((View.OnClickListener) this);




        return view;

    }

}
