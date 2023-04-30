package com.example.geeks_2_hw_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, result;
    private Boolean isOperationClicked;
    private String operation;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        btn_send = findViewById(R.id.btn_send);

        findViewById(R.id.btn_send).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
            String result_number = textView.getText().toString();
            intent.putExtra("result_number", result_number);
            startActivity(intent);
        });
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
            btn_send.setVisibility(View.GONE);
        }


    public void onOperationClick(View view) {
        if(view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textView.getText().toString());
            btn_send.setVisibility(View.INVISIBLE);
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
        }
        isOperationClicked = true;
        btn_send.setVisibility(View.GONE);
    }

    public void onEqualClick(View view){
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
        btn_send.setVisibility(View.VISIBLE);
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