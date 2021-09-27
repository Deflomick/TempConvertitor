package com.devdefloriomichele.tempconverter;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public int t = 0, Intresult = 0;



    private final MutableLiveData<String> _currentWord = new MutableLiveData<>();

    public LiveData<String> getCurrentWord() {
        return _currentWord;
    }

    /*public mainViewModel(){


    }*/

    public void farenheitToCelsius(EditText s1) {

        double mynum = 0;
        mynum = Double.parseDouble((s1.getText().toString()));
        mynum = (mynum - 32) * 0.556;
        Intresult=(int)Math.round(mynum);
        _currentWord.setValue(String.valueOf(Intresult));

    }

    public void celsiusToFarenheit(EditText s2) {

        double mynum = 0;
        mynum = Double.parseDouble((s2.getText().toString()));
        mynum = (mynum * 1.8) + 32;
        Intresult=(int)Math.round(mynum);
        _currentWord.setValue(String.valueOf(Intresult));


    }
}
