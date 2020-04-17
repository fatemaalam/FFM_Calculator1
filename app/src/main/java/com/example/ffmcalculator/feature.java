package com.example.ffmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class feature extends AppCompatActivity implements AdapterView.OnItemSelectedListener{



   // private Spinner spinner;
    private Button button;

    private EditText name, etAge, etWeight, etHeight, etImpedance;
    private String nam, ag, wei, hei, imp;

 //   private static final String[] paths = {"Male", "Female"};
   // String text ="";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

     //   spinner = (Spinner)findViewById(R.id.spinner);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        button =(Button)findViewById(R.id.button);
        name =(EditText)findViewById(R.id.etNam);
        etAge =(EditText)findViewById(R.id.etAge);
        etWeight =(EditText)findViewById(R.id.etWeight);
        etHeight =(EditText)findViewById(R.id.etHeight);
        etImpedance =(EditText)findViewById(R.id.etImpedance);


       // EditText txtUserName = (EditText) findViewById(R.id.txtUsername);
      //  strUserName = usernameEditText.getText().toString();

        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String str = name.getText().toString();
                String str1 = etAge.getText().toString();
                String str2 = etWeight.getText().toString();
                String str3 = etHeight.getText().toString();
                String str4 = etImpedance.getText().toString();
                //String str2 = spinner.getText().toString();

                if(TextUtils.isEmpty(str)) {
                    name.setError("Please Enter Your Name");
                    return;
                } else  if(TextUtils.isEmpty(str1)) {
                    etAge.setError("Please Enter Your Age");
                    return;
                }

                else  if(TextUtils.isEmpty(str2)) {
                    etWeight.setError("Please Enter Your Weight");
                    return;
                }
                else  if(TextUtils.isEmpty(str3)) {
                    etHeight.setError("Please Enter Your Height");
                    return;
                }
                else  if(TextUtils.isEmpty(str4)) {
                    etImpedance.setError("Please Enter Your Impedance");
                    return;
                }
                Intent intent = new Intent(feature.this, Result.class);
                intent.putExtra("rec_name", str);
                intent.putExtra("rec_age", str1);
                intent.putExtra("rec_weight", str2);
                intent.putExtra("rec_height", str3);
                intent.putExtra("rec_imp", str4);
                intent.putExtra("data",String.valueOf(spinner.getSelectedItem()));
                //intent.putExtra("dataa",valueOf(spinner.getSelectedItem()));

              //  i.putExtra("getData",this.text);
                //intent.putExtra("getSpinner",USN.toString());

                startActivity(intent);
            }


        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Gender: " + item, Toast.LENGTH_LONG).show();

        //  switch (position) {
        //   case 0:
        // Whatever you want to happen when the first item gets selected
        //   break;
        //  case 1:
        // Whatever you want to happen when the second item gets selected
        //      break;

    //}

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    /*public boolean validate() {
        boolean valid = true;
        if (nam.isEmpty() || nam.length() > 10) {
            name.setError("please enter valid name");
            valid = false;
        }
        if (ag.isEmpty()) {
            etAge.setError("please enter etWeight age");
            valid = false;
        }
        if (wei.isEmpty()) {
            etWeight.setError("please enter your Weight");
            valid = false;
        }
        if (hei.isEmpty()) {
            etHeight.setError("please enter your Height");
            valid = false;
        }
        if (imp.isEmpty()) {
            etImpedance.setError("please enter your Impedance");
            valid = false;
        }

        return valid;

    }

    public void initialize() {
        nam = name.getText().toString().trim();
        ag = etAge.getText().toString().trim();
        wei = etWeight.getText().toString().trim();
        hei = etHeight.getText().toString().trim();
        imp = etImpedance.getText().toString().trim();

    } */

}
