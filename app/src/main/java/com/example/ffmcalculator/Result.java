package com.example.ffmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.valueOf;

public class Result<CalculationsActivity> extends AppCompatActivity {

    EditText rec_name, rec_age, rec_weight, rec_height, rec_imp;
    EditText ffm1, ffmi1;
    private Spinner spinner;
  //  private static float h, hm, w, i, b, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

      //  spinner = (Spinner)findViewById(R.id.spinner);
        rec_name = (EditText)findViewById(R.id.etNam);
        rec_age = (EditText)findViewById(R.id.etAge);
        rec_weight = (EditText)findViewById(R.id.etWeight);
        rec_height = (EditText)findViewById(R.id.etHeight);
        rec_imp = (EditText)findViewById(R.id.etImpedance);
        ffm1 = (EditText)findViewById(R.id.ffm);
        ffmi1 = (EditText)findViewById(R.id.ffmi);
        
      // rec_age = (TextView)findViewById(R.id.etAge);


        Intent intent = getIntent();


        String str = intent.getStringExtra("rec_name");
        String str1 = intent.getStringExtra("rec_age");
        String str2 = intent.getStringExtra("rec_weight");
        String str3 = intent.getStringExtra("rec_height");
        String str4 = intent.getStringExtra("rec_imp");
        //String str1 = intent.getStringExtra("rec_age");
        //String value = intent.getStringExtra("getSpinner");

        TextView textView=(EditText) findViewById(R.id.spinner);
        Bundle bundle=getIntent().getExtras();
        String data1=bundle.get("data").toString();
        textView.setText(data1);


    //    int position = Integer.parseInt(String.valueOf(bundle));
        //String s= textView.setText(data1);

        // display the string into textView
        rec_name.setText(str);
        rec_age.setText(str1);
      //  rec_weight.setText(str2);
      //  rec_height.setText(str3);
      //  rec_imp.setText(str4);


     
          //  String heightStr = height.getText().toString(); str2 
           // String weightStr = weight.getText().toString(); str3

         
                float heightValuem = Float.parseFloat(str3) / 100; // meter
                float weightValue = Float.parseFloat(str2); //kg
                float heightValue = Float.parseFloat(str3);  //cm
                float impedance = Float.parseFloat(str4);  //ohm   Z
                float a = Float.parseFloat(str1);  //year
                float sq=heightValuem * heightValuem;

                float b = weightValue / (heightValuem * heightValuem);
       // b.setText(String.valueOf(ffmr));
                
                float i = (heightValue * heightValue) / impedance;


     //   String textFromSpinner = spinner.getSelectedItem().toString();
        if(data1.equals("Male")){

            float ffmr = (float) (-12.05 + (0.017 * a) + (0.63 * b) + (0.002 * impedance) + (0.85 * i));
            float ffmir = ffmr / (heightValuem * heightValuem);


            ffm1.setText(String.valueOf(ffmr));
            ffmi1.setText(String.valueOf(ffmir));
        }


        else if(data1.equals("Female")){

            float ffmrf = (float) (-9.69 - (0.004 * a) + (0.47 * b) + (0.003 * impedance) + (0.82 * i));
            float ffmirf = ffmrf / (heightValuem * heightValuem);


            ffm1.setText(String.valueOf(ffmrf));
            ffmi1.setText(String.valueOf(ffmirf));
//start another
        }

/*
        if (position == 0) {
            float ffmr = (float) (-12.05 + (0.017 * a) + (0.63 * b) + (0.002 * impedance) + (0.85 * i));
            float ffmir = ffmr / (heightValuem * heightValuem);


            ffm1.setText(String.valueOf(ffmr));
            ffmi1.setText(String.valueOf(ffmir));// Whatever you want to happen when the first item gets selected
        } else if (position == 1) {
            float ffmrf = (float) (-9.69 - (0.004 * a) + (0.47 * b) + (0.003 * impedance) + (0.82 * i));
            float ffmirf = ffmrf / (heightValuem * heightValuem);


            ffm1.setText(String.valueOf(ffmrf));
            ffmi1.setText(String.valueOf(ffmirf));// Whatever you want to happen when the second item gets selected
        }
 */
              /*  if(data1 == "Female") {

            float ffmrf = (float) (-9.69 - (0.004 * a) + (0.47 * b) + (0.003 * impedance) + (0.82 * i));
            float ffmirf = ffmrf / (heightValuem * heightValuem);


            ffm1.setText(String.valueOf(ffmrf));
            ffmi1.setText(String.valueOf(ffmirf));
        }
               else {

            float ffmr = (float) (-12.05 + (0.017 * a) + (0.63 * b) + (0.002 * impedance) + (0.85 * i));
            float ffmir = ffmr / (heightValuem * heightValuem);


            ffm1.setText(String.valueOf(ffmr));
            ffmi1.setText(String.valueOf(ffmir));
        } */
      //  bmiLabel = getString(R.string.obese_class_iii);
           //    ffm1.setText((int) ffmr);
             //  ffmi1.setText((int) ffmir);

   

      /*  public int computeBMI(){

            SharedPreferences customSharedPreference = getSharedPreferences(
                    "myCustomSharedPrefs", Activity.MODE_PRIVATE);

            String Height = customSharedPreference.getString("rec_height", "");
            String Weight = customSharedPreference.getString("rec_weight", "");

            int weight = Integer.parseInt(Weight);
            int height = Integer.parseInt(Height);
         //   Toast.makeText(Result.this, Height+" "+ Weight , Toast.LENGTH_LONG).show();

            float bmi = (float)weight/(float)(height*height);

            return bmi;

        } */

        //hm=
       // rec_weight.setText(str2);
       // rec_height.setText(str3);
       // rec_imp.setText(str4);
      //  rec_age.setText(str1);// spinner.setText(value);



    }
}
