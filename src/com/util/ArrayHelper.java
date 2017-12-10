package com.util;

public class ArrayHelper {

    public static int[] getRandomArray(int length,int limitL,int limitR){

        int[] t =new int[length];

        for(int i = 0;i<length;i++){
            t[i] =(int)( Math.random()*(limitR-limitL)+limitL);

        }
        return t;
    }



}
