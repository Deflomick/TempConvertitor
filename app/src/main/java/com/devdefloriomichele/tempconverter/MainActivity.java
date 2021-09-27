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

import com.devdefloriomichele.tempconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    /*private Button buttonconv;
    private EditText num1;
    private EditText num2;*/
    private MainViewModel viewModel;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);

        setContentView(binding.getRoot());
        viewModel= new ViewModelProvider(this).get(MainViewModel.class);
        /*buttonconv = findViewById(R.id.buttonConverter);
        num1 = (EditText) findViewById(R.id.editNum1);
        num2 = (EditText) findViewById(R.id.editText2);*/


        viewModel.getCurrentWord().observe(this, currentWord -> {
            if (viewModel.t == 0) {
            binding.editNum2.setText(currentWord);
                binding.editNum2.setBackgroundColor(Color.GREEN);
                binding.editNum1.setBackgroundColor(Color.CYAN);

            }
            else if(viewModel.t == 1) {
                binding.editNum1.setText(currentWord);
                binding.editNum1.setBackgroundColor(Color.GREEN);
                binding.editNum1.setBackgroundColor(Color.CYAN);

            }


        });

        binding.buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (viewModel.t == 0) {

                    viewModel.celsiusToFarenheit(binding.editNum1);
                    viewModel.t++;


                } else if (viewModel.t == 1) {
                    viewModel.farenheitToCelsius(binding.editNum2);
                    viewModel.t--;



                }

            }







        });


    }



}