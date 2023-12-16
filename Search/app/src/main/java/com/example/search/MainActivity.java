package com.example.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNum;
    private EditText editSearchNum;
    private Button btnSearch;
    private Button btnRandom;
    private TextView tvResult;

    private CheckBox cbBinary;
    private CheckBox cbLinear;

    private ArrayList<Integer> numberList;
    private BinarySearch binarySearch;
    private LinearSearch linearSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum = findViewById(R.id.edit_number);
        editSearchNum = findViewById(R.id.edit_search_number);
        btnSearch = findViewById(R.id.btn_search);
        btnRandom = findViewById(R.id.btn_random_array);
        tvResult = findViewById(R.id.tv_result);
        cbBinary = findViewById(R.id.cb_binary_search);
        cbLinear = findViewById(R.id.cb_linear_search);

        btnSearch.setOnClickListener(this);
        btnRandom.setOnClickListener(this);

        numberList = new ArrayList<>();
    }

    public void generateRandomNumbers() {
        int min = 1;
        int max = 100;
        int count = 10;

        StringBuilder randomNumbers = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            randomNumbers.append(randomNumber);

            if (i < count - 1) {
                randomNumbers.append(", ");
            }
        }

        editNum.setText(randomNumbers.toString());
    }

    @Override
    public void onClick(View v) {
        if (v == btnSearch) {
            try {
                String input = editNum.getText().toString();
                String[] numberStrings = input.split(",");
                numberList.clear();
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString.trim());
                    numberList.add(number);
                }

                int target = Integer.parseInt(editSearchNum.getText().toString());

                if (cbBinary.isChecked() && cbLinear.isChecked()) {
                    tvResult.setText("Chọn một cái thôi! Làm ơn!!!");
                    return;
                }

                if (cbBinary.isChecked()) {
                    binarySearch = new BinarySearch();
                    binarySearch.search(numberList, target);
                    CharSequence result = binarySearch.getResult();
                    tvResult.setText(result);
                    printSortedArray(numberList);
                } else if (cbLinear.isChecked()) {
                    linearSearch = new LinearSearch();
                    linearSearch.search(numberList, target);
                    CharSequence result = linearSearch.getResult();
                    tvResult.setText(result);
                    printSortedArray(numberList);
                } else if (!cbBinary.isChecked() || !cbLinear.isChecked()) {
                    tvResult.setText("Vui lòng chọn loại tìm kiếm!");
                }

            } catch (NumberFormatException e) {
                tvResult.setText("Không được để trống, vui lòng nhập số!");
            }
        }else if (v == btnRandom){
            generateRandomNumbers();
        }
    }

    private void printSortedArray(ArrayList<Integer> array) {
        StringBuilder sortedArrayString = new StringBuilder("Array: ");
        for (Integer num : array) {
            sortedArrayString.append(num).append(" ");
        }
        tvResult.append("\n" + sortedArrayString.toString());
    }
}