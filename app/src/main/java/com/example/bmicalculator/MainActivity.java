package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edweg,edhei;
        TextView txtRes,txtenter;
        Button btnres,btnreset;

        edweg=(EditText)findViewById(R.id.edweg);
        edhei=(EditText)findViewById(R.id.edhei);
        txtenter=(TextView)findViewById(R.id.txtenter);
        txtRes=(TextView)findViewById(R.id.txtres);
        btnres=(Button)findViewById(R.id.btnres);
        btnreset=(Button)findViewById(R.id.btnreset);


        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strweg=edweg.getText().toString();
                String strhei=edhei.getText().toString();
                if(strweg.equals("")){
                    edweg.setError("Enter your Weight");
                    edweg.requestFocus();
                    return;
                }
                if(strhei.equals("")){
                   edhei.setError("Enter your height");
                   edhei.requestFocus();
                   return;
                }
                float weight=Float.parseFloat(strweg);
                float height=Float.parseFloat(strhei)/100;
                float bmivalue=BMICalculator(weight,height);
                txtenter.setText(interpreteBmi(bmivalue));
                txtRes.setText("BMI="+bmivalue);
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edhei.setText("");
                edweg.setText("");
                txtenter.setText("");
                txtRes.setText("");
            }
        });
    }
    public  float BMICalculator(float weight,float height){
        return weight/(height * height);

    }
    public  String interpreteBmi(float bmivalue){
        if(bmivalue<16){
            return "Servely Underweight";
        }
        else if(bmivalue<18.5){

            return "Underweight";
        }
        else if(bmivalue<25){
            return "Normal";
        }
        else if(bmivalue<30){
            return "Overweight";
        }else
            {
            return "Obese";
        }
    }

    public void more(View view) {
        Intent i =new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(i);
    }
}