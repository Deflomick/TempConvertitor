package com.devdefloriomichele.tempconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonconv;
    private EditText num1;
    private EditText num2;
    private MainViewModel viewModel;
    private static final String SAVE_VALUE = MainActivity.class.getSimpleName()+"save_index";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= new ViewModelProvider(this).get(MainViewModel.class);
        buttonconv = findViewById(R.id.buttonConverter);
        num1 = (EditText) findViewById(R.id.editNum1);
        num2 = (EditText) findViewById(R.id.editText2);





        buttonconv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                double result = 0;
                String S;

                if (viewModel.t == 0) {

                    result = celsiusToFarenheit(num1);
                    viewModel.t++;
                    viewModel.Intresult=(int)Math.round(result);

                    num2.setText(String.valueOf(viewModel.Intresult));

                } else if (viewModel.t == 1) {
                    result = farenheitToCelsius(num2);
                    viewModel.t--;
                    result =(int)Math.round(result);
                    viewModel.Intresult=(int)Math.round(result);

                    num1.setText(String.valueOf(viewModel.Intresult));


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