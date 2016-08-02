package com.example.vtree.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnC,btnP,btnDel,btnDeg,btnAdd,btnSub,btnDev,btnMul;
    EditText editBot,editHig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        btn1 = (Button)findViewById(R.id.btnOne);
        btn2 = (Button)findViewById(R.id.btnTwo);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSubtract);
        btnMul = (Button)findViewById(R.id.btnMultiply);
        btnDev = (Button)findViewById(R.id.btnDivide);
        btnDeg = (Button)findViewById(R.id.btnDecimal);
    }
}
