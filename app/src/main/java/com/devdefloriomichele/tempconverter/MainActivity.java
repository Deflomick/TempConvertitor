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







                if (viewModel.t == 0) {

                    viewModel.result = viewModel.celsiusToFarenheit(num1);
                    viewModel.t++;
                    viewModel.Intresult=(int)Math.round(viewModel.result);

                    num2.setText(String.valueOf(viewModel.Intresult));

                } else if (viewModel.t == 1) {
                    viewModel.result = viewModel.farenheitToCelsius(num2);
                    viewModel.t--;
                    viewModel.result =(int)Math.round(viewModel.result);
                    viewModel.Intresult=(int)Math.round(viewModel.result);

                    num1.setText(String.valueOf(viewModel.Intresult));


                }

            }







        });


    }



}