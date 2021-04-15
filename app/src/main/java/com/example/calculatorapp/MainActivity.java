package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Float param1,param2;
    String sOperator,sOutputScreen="";
    EditText etGiaTri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGiaTri= findViewById(R.id.ediText);
        int[] idButton = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btnDel,
                R.id.btn9,R.id.btnDot,R.id.btnDiv,R.id.btnAdd,R.id.btnMul,R.id.btnSub,R.id.btnEqual};
        for(int id:idButton){
            View v = findViewById(id);
            v.setOnClickListener(this);
        }
    }
    private void OperatorHandle(){
        param1 = Float.parseFloat(etGiaTri.getText().toString()) ;
        sOutputScreen="0";
        etGiaTri.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDel:
                OperatorHandle();
                break;
            case R.id.btnSub:
                sOperator = "-";
                OperatorHandle();
                break;
            case R.id.btnAdd:
                sOperator = "+";
                OperatorHandle();
                break;
            case R.id.btnDiv:
                sOperator = "/";
                OperatorHandle();
                break;
            case R.id.btnMul:
                sOperator = "*";
                OperatorHandle();
                break;
            case R.id.btnEqual:
                Float result = null;
                param2=Float.parseFloat(etGiaTri.getText().toString());
                if(sOperator=="+"){
                    result = param1 + param2;
                }
                if(sOperator=="-"){
                    result = param1 - param2;
                }
                if(sOperator=="*"){
                    result = param1 * param2;
                }
                if(sOperator=="/"){
                    result = param1 / param2;
                }
                etGiaTri.setText(String.valueOf(result));
                param1 = 0.0f;
                param2 = 0.0f;
                sOutputScreen = "0";
                break;

            default:
                if(sOutputScreen.equals("0")){
                    sOutputScreen="";
                }
                sOutputScreen += ((Button)v).getText().toString();
                etGiaTri.setText(sOutputScreen);
        }
    }
}