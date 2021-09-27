package com.devdefloriomichele.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonconv;
    private EditText num1;
    private TextView num2;
    private int t = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonconv = findViewById(R.id.buttonConverter);
        num1 = (EditText) findViewById(R.id.editNum1);
        num2 = findViewById(R.id.textView2);


        buttonconv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                double result = 0;
                String S;

                if (t == 0) {

                    result = celsiusToFarenheit(num1);
                    t++;
                    int Intresult=(int)Math.round(result);

                    num2.setText(String.valueOf(Intresult));

                } else if (t == 1) {
                    result = farenheitToCelsius(num2);
                    t--;
                    result =(int)Math.round(result);
                    int Intresult=(int)Math.round(result);

                    num1.setText(String.valueOf(Intresult));
                }
            }


            private double farenheitToCelsius(EditText s1) {

                double mynum = 0;
                mynum = Double.parseDouble((s1.getText().toString()));
                mynum = (mynum - 32) * 0.556;


                return mynum;


            }

            private double celsiusToFarenheit(EditText s2) {

                double mynum = 0;
                mynum = Double.parseDouble((s2.getText().toString()));
                mynum = (mynum * 1.8) + 32;


                return mynum;


            }


        });
    }
}