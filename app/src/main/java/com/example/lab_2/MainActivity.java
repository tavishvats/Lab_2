package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText firstNum, secondNum;
    private Button add, subtract, multiply, divide;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton:
                goToResult(String.valueOf(Integer.parseInt(firstNum.getText().toString()) +
                        Integer.parseInt(secondNum.getText().toString())));
                break;
            case R.id.subtractButton:
                goToResult(String.valueOf(Integer.parseInt(firstNum.getText().toString()) -
                        Integer.parseInt(secondNum.getText().toString())));
                break;
            case R.id.multiplyButton:
                goToResult(String.valueOf(Integer.parseInt(firstNum.getText().toString()) *
                        Integer.parseInt(secondNum.getText().toString())));
                break;
            case R.id.divideButton:
                goToResult(String.valueOf(Integer.parseInt(firstNum.getText().toString()) /
                        Integer.parseInt(secondNum.getText().toString())));
                break;
        }
    }

    public void goToResult(String result) {
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNum = findViewById(R.id.firstNumber);
        secondNum = findViewById(R.id.secondNumber);
        add = findViewById(R.id.addButton);
        subtract = findViewById(R.id.subtractButton);
        multiply = findViewById(R.id.multiplyButton);
        divide = findViewById(R.id.divideButton);
        firstNum.addTextChangedListener(input);
        secondNum.addTextChangedListener(input);
    }

    private TextWatcher input = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String firstInput = firstNum.getText().toString().trim();
            String secondInput = secondNum.getText().toString().trim();
            add.setEnabled(!firstInput.isEmpty() && !secondInput.isEmpty());
            subtract.setEnabled(!firstInput.isEmpty() && !secondInput.isEmpty());
            multiply.setEnabled(!firstInput.isEmpty() && !secondInput.isEmpty());
            divide.setEnabled(!firstInput.isEmpty() && !secondInput.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}