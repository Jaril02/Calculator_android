package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import java.math.*;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView display;
    String input="";
    String operator="";
    double firstNum=0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        display = findViewById(R.id.txt);
        int[] btnid = {
                R.id.rem, R.id.expo, R.id.bckspc, R.id.clr, R.id.btn1, R.id.btn2, R.id.btn3
                , R.id.plus, R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.minus, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.mul, R.id.deci, R.id.btn0, R.id.div, R.id.eql
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String value = b.getText().toString();


                switch (value) {
                    case "CE":
                        input = "";
                        operator = "";
                        firstNum = 0;
                        display.setText("0");
                        break;

                    case "⌫":
                        if (!input.isEmpty()) {
                            input = input.substring(0, input.length() - 1);
                            display.setText(input.isEmpty() ? "0" : input);
                        }
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "%":
                    case "^":
                        if (!input.equals("")) {
                            operator = value;
                            firstNum = Double.parseDouble(input);
                            input = "";
                        }
                        break;
                    case "/":
                        operator = value;
                        firstNum = Double.parseDouble(input);

                        input = "";
                        break;


                    case "=":
                        if (!input.equals("") || !operator.equals("")) {
                            if (input.isEmpty()) {
                                display.setText("Enter a number");
                                return;
                            }
                            double secondNum = Double.parseDouble(input);
                            double result = 0;

                            switch (operator) {
                                case "+":
                                    result = firstNum + secondNum;

                                    break;
                                case "-":
                                    result = firstNum - secondNum;
                                    break;
                                case "*":
                                    result = firstNum * secondNum;
                                    break;
                                case "%":
                                    result = firstNum % secondNum;
                                    break;
                                case "^":
                                    result = Math.pow(firstNum,secondNum);
                                    break;
                                case "/":
                                    if (secondNum==0) {
                                        display.setText("Error");
                                        return;
                                    } else {
                                        result = firstNum / secondNum;
                                    }
                                    break;
                            }
                            display.setText(String.valueOf(firstNum+" "+operator+" "+secondNum+"\n"+result));
                            input = String.valueOf(result);

                            operator = "";
                        }
                        break;

                    default:
                        if (value.matches("[0-9\\.]")) {
                            input += value;
                            display.setText(input);
                        }
                        break;
                }
            }
        };
        for (int id : btnid) {
            Button b = findViewById(id);
            b.setOnClickListener(listener);

        }
        ;
    }}
