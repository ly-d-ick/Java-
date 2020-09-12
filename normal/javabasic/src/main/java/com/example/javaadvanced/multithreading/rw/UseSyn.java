package com.example.javaadvanced.multithreading.rw;

import com.example.javaadvanced.multithreading.tools.SleepTools;

public class UseSyn implements GoodsService {

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getNum() {
        SleepTools.millisecond(5);
        return this.goodsInfo;
    }

    @Override
    public void setNum(int number) {
        SleepTools.millisecond(5);
        goodsInfo.changeNumber(number);
    }
}
