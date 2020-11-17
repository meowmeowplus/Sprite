package com.example.sprite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MySprite myCat;
    private LinearLayout lnlo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCat = findViewById(R.id.myframe);
        lnlo = findViewById(R.id.sprite);

        lnlo.setOnClickListener(this);
    }

    public void lnlo_onclick(View view) {

    }

    @Override
    public void onClick(View v) {

    }
}
