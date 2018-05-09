package com.mansion.yang.mixtureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by: Dry
 * Created on: 2018/5/10
 * Function:
 */

public class MainActivity extends AppCompatActivity {

    TextView shop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        shop = findViewById(R.id.tv_shopping);
        shop.setOnClickListener(view -> startActivity(new Intent(this, ShoppingActivity.class)));
    }
}
