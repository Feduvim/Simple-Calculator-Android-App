package com.example.lab01_p02_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText num1;
private EditText num2;
private EditText res;
private double valor1;
private double valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.editNum1);
        num2 = (EditText) findViewById(R.id.editNum2);
        res = (EditText) findViewById(R.id.editRes);
        res.setFocusable(false);
        Button buttonSoma = (Button) findViewById(R.id.buttonSoma);
        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.this.updateValores()) {
                    res.setText(String.valueOf(valor1+valor2));
                }
            }
        });
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.this.updateValores()) {
                    res.setText(String.valueOf(valor1-valor2));
                }
            }
        });
        Button buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.this.updateValores()) {
                    res.setText(String.valueOf(valor1*valor2));
                }
            }
        });
        Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.this.updateValores()) {
                    if(valor2 ==0.0) {
                        res.setText("Erro! Divisão por zero!");
                    } else {
                        res.setText(String.valueOf(valor1/valor2));
                    }
                }
            }
        });
    }

    private boolean updateValores() {
        try {
            valor1 = Double.parseDouble(num1.getText().toString());
            valor2 = Double.parseDouble(num1.getText().toString());
            return true;
        } catch (Exception ex) {
            res.setText(ex.getMessage());
            return false;
        }
    }
}