// ICalculatorService.aidl
package com.example.testapp;

// Declare any non-default types here with import statements

interface ICalculatorService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     int add(int num1,int num2);
    /*void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/
}