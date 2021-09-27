package com.devdefloriomichele.tempconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= new ViewModelProvider(this).get(MainViewModel.class);
        buttonconv = findViewById(R.id.buttonConverter);
        num1 = (EditText) findViewById(R.id.editNum1);
        num2 = (EditText) findViewById(R.id.editText2);


        viewModel.getCurrentWord().observe(this, currentWord -> {
            if (viewModel.t == 0) {
            num2.setText(currentWord);
            num2.setBackgroundColor(Color.GREEN);
                num1.setBackgroundColor(Color.CYAN);

            }
            else if(viewModel.t == 1) {
                num1.setText(currentWord);
                num1.setBackgroundColor(Color.GREEN);
                num2.setBackgroundColor(Color.CYAN);

            }


        });

        buttonconv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (viewModel.t == 0) {

                    viewModel.celsiusToFarenheit(num1);
                    viewModel.t++;


                } else if (viewModel.t == 1) {
                    viewModel.farenheitToCelsius(num2);
                    viewModel.t--;



                }

            }







        });


    }



}