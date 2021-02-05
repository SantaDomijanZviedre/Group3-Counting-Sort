package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rd = new Random();
        int[] myArray = new int[20000];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rd.nextInt();
            System.out.println(myArray[i]);
        }
    }
}
