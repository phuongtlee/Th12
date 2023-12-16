package com.example.th12;

import java.io.Serializable;

public class Number implements Serializable {
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Number(int num) {
        this.num = num;
    }
}
