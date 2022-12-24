package com.sksingh.homeloanemicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    public void Calculate(View view){
        EditText principleamount= (EditText) findViewById(R.id.PrincipleAmount);
        EditText number_of_months= (EditText) findViewById(R.id.NumberOfMonths);
        EditText interest_rate = (EditText) findViewById(R.id.Interest);
        double p, r , n, EMI, Total_Interest,Total_Payment;
        try {
                p = Double.parseDouble(principleamount.getText().toString());
                r = Double.parseDouble(interest_rate.getText().toString());
                n = Double.parseDouble(number_of_months.getText().toString());
                r = (r/100)/12;
                EMI = p * r * Math.pow((1+r),n)/(Math.pow((1+r),n)-1);
                Total_Interest = (EMI * n) - p;
                Total_Payment = EMI * n;
                TextView EMI_Value= (TextView) findViewById(R.id.EMI);
                EMI_Value.setText(Double.toString((int)EMI)+" RS /Month");
                TextView TotalInterest = (TextView) findViewById(R.id.TotalInterest);
                TotalInterest.setText(Double.toString((int)Total_Interest)+"  RS");
                TextView TotalPayment= (TextView) findViewById(R.id.CumalativePay);
                TotalPayment.setText(Double.toString((int)Total_Payment)+" RS");
                ConstraintLayout outoutwindow=(ConstraintLayout) findViewById(R.id.outputlayout);
                outoutwindow.setVisibility(View.VISIBLE);
        }
        catch (Exception e) {
            System.out.println("Error Encountered : "+e.getMessage());
            Toast.makeText(this,"Please Fill All the Values",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}