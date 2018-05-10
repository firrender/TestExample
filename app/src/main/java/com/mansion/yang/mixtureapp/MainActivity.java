package com.mansion.yang.mixtureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mansion.yang.mixtureapp.widget.datapicker.AddressPickTask;
import com.mansion.yang.mixtureapp.widget.datapicker.City;
import com.mansion.yang.mixtureapp.widget.datapicker.ConvertUtils;
import com.mansion.yang.mixtureapp.widget.datapicker.County;
import com.mansion.yang.mixtureapp.widget.datapicker.DatePicker;
import com.mansion.yang.mixtureapp.widget.datapicker.Province;

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

    public void onYearMonthDayPicker(View view) {
        //final DatePicker picker = new DatePicker(this);
        final DatePicker picker = new DatePicker(this, DatePicker.YEAR_MONTH);
        picker.setCanceledOnTouchOutside(true);
        picker.setUseWeight(true);
        picker.setTopPadding(ConvertUtils.toPx(this, 10));
        picker.setRangeEnd(2111, 1, 11);
        picker.setRangeStart(2016, 8, 29);
        //picker.setSelectedItem(2050, 10, 14);
        picker.setSelectedItem(2017, 9);
        picker.setResetWhileWheel(false);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
            @Override
            public void onDatePicked(String year, String month) {
                Toast.makeText(getApplicationContext(), year + "-" + month, Toast.LENGTH_SHORT).show();
            }
        });
        picker.show();
        /*picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                Toast.makeText(getApplicationContext(), year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();*/
    }

    public void onAddress3Picker(View view) {
        AddressPickTask task = new AddressPickTask(this);
        task.setHideCounty(true);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
                Toast.makeText(getApplicationContext(), "数据初始化失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                Toast.makeText(getApplicationContext(), province.getAreaName() + " " + city.getAreaName(), Toast.LENGTH_SHORT).show();
            }
        });
        task.execute("四川", "阿坝");
    }
}
