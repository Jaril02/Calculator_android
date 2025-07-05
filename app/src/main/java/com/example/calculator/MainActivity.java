package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView display;
    String input="";
    String operator="";
    int firstNum=0;


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
        display=findViewById(R.id.txt);
        int[] btnid={
          R.id.rem,R.id.expo,R.id.bckspc,R.id.clr,R.id.btn1,R.id.btn2,R.id.btn3
                ,R.id.plus,R.id.btn4,R.id.btn5,R.id.btn6,
                R.id.minus,R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.mul,R.id.deci,R.id.btn0,R.id.div,R.id.eql
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b=(Button) view;
                String value= b.getText().toString();

//                comment added in the MainActivity;
//                Switch(value){
//                    case
//                }
            }
        };
    }

}