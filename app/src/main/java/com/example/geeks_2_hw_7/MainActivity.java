package com.example.geeks_2_hw_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, result;
    private Boolean isOperationClicked;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
            if (view.getId() == R.id.btn_one){
                setNumber("1");
            } else if (view.getId() == R.id.btn_two) {
                setNumber("2");
            } else if (view.getId() == R.id.btn_clear) {
                textView.setText("0");
                first = 0;
                second = 0;
            } else if (view.getId() == R.id.btn_three) {
                setNumber("3");
            } else if (view.getId() == R.id.btn_four) {
                setNumber("4");
            } else if (view.getId() == R.id.btn_five) {
                setNumber("5");
            } else if (view.getId() == R.id.btn_six) {
                setNumber("6");
            } else if (view.getId() == R.id.btn_seven) {
                setNumber("7");
            } else if (view.getId() == R.id.btn_eight) {
                setNumber("8");
            } else if (view.getId() == R.id.btn_nine) {
                setNumber("9");
            } else if (view.getId() == R.id.btn_zero) {
                setNumber("0");
            }
            isOperationClicked = false;
        }

    public void onOperationClick(View view) {
        if(view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_multiplication) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "*";
        } else if (view.getId() == R.id.btn_division) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "/";
        } else if(view.getId() == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    result = first / second;
                    break;
            }
            textView.setText(result.toString());
        }
        isOperationClicked = true;
    }

    public void setNumber(String number) {
        if (textView.getText().toString().equals("0") || isOperationClicked) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
    }
}