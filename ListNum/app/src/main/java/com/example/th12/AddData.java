package com.example.th12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AddData extends AppCompatActivity {

    EditText edt;
    Button btn_binhPhuong, btn_original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        edt = findViewById(R.id.edt_num_list);
        btn_original = findViewById(R.id.btn_original);
        btn_binhPhuong = findViewById(R.id.btn_binh_phuong);

        btn_original.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(edt.getText().toString());
                Number number = new Number(num);
                Intent intent =new Intent();
                intent.putExtra("key_number", number);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btn_binhPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(edt.getText().toString()) * Integer.parseInt(edt.getText().toString());
                Number number = new Number(num);
                Intent intent =new Intent();
                intent.putExtra("key_number", number);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}