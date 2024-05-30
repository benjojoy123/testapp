package com.example.testapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ICalculatorService calculatorService;
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            calculatorService=ICalculatorService.Stub.asInterface(iBinder);
            try {
                int sum=calculatorService.add(10,20);
                TextView textView=findViewById(R.id.textView);
                textView.setText(String.valueOf(sum));
            }
            catch (RemoteException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            calculatorService=null;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,CalculatorService.class);
        intent.setPackage("com.example.testapp");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

}

/*
MainActivity connects to a remote CalculatorService.
It sets up a ServiceConnection to handle connecting to and disconnecting from the service.
When the service is connected, it calls a method on the service to add two numbers and displays the result.
The activity binds to the service when it is created and unbinds when it is destroyed.
*/
