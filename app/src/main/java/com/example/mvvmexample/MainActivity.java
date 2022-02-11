package com.example.mvvmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    AppCompatButton bgSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgSwitch = findViewById(R.id.bgSwitch);
        layout = findViewById(R.id.layout);

        ViewModels model = new ViewModelProvider(this).get(ViewModels.class);

        model.currentState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    layout.setBackgroundColor(getColor(R.color.green));
                    bgSwitch.setText("off");
                } else {
                    layout.setBackgroundColor(getColor(R.color.RED));
                    bgSwitch.setText("On");
                }
            }
        });

        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.currentState.getValue() == null) {
                    model.currentState.setValue(true);
                }
                model.currentState.setValue(!model.currentState.getValue());
            }
        });
    }
}