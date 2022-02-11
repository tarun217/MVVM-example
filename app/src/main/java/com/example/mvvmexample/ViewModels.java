package com.example.mvvmexample;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModels extends ViewModel {
    MutableLiveData<Boolean> currentState = new MutableLiveData<>(false);

}