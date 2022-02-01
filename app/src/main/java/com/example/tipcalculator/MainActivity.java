package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextAmount;
    EditText editTextNumber;
    Button btnCalculate;
    TextView tvTotalTipAmount;
    TextView tvTipPPersonAmount;
    CheckBox cBoxService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        editTextNumber = findViewById(R.id.editTextNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvTotalTipAmount = findViewById(R.id.tvTotalTipAmount);
        tvTipPPersonAmount = findViewById(R.id.tvTipPPersonAmount);
        cBoxService = findViewById(R.id.cBoxService);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Total Amount Code
                String strTotal = editTextAmount.getText().toString();
                Double dblTotal = Double.parseDouble(strTotal);
                if (cBoxService.isChecked()) {
                    dblTotal = dblTotal * .20;
                    tvTotalTipAmount.setText(NumberFormat.getCurrencyInstance().format(dblTotal));
                } else {
                    dblTotal = dblTotal * .15;
                    tvTotalTipAmount.setText(NumberFormat.getCurrencyInstance().format(dblTotal));
                }
                //Tip per Person Code
                String strParty = editTextNumber.getText().toString();
                Double dblParty = Double.parseDouble(strParty);
                dblTotal = dblTotal / dblParty;
                tvTipPPersonAmount.setText(NumberFormat.getCurrencyInstance().format(dblTotal));
            }
        });
    }
}