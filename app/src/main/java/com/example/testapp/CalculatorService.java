package com.example.testapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CalculatorService extends Service {
    public CalculatorService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final ICalculatorService.Stub mBinder = new ICalculatorService.Stub() {

        @Override
        public int add(int num1, int num2){
            return num1 + num2;

        }

    };


}

   /* @Override
    public int add(int num1, int num2) throws RemoteException {
        return 0;
    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}*/