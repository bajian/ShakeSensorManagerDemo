package com.example.bajian.sensormanagerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends Activity {


    private ShakeListener mShakeListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShakeListener = new ShakeListener(this);
        mShakeListener.setOnShakeListener(new ShakeListener.OnShakeListener() {
            @Override
            public void onShake() {
                mShakeListener.stop();
                //do sth
                Toast.makeText(MainActivity.this,"正在摇一摇...",Toast.LENGTH_LONG).show();
                Log.d("shake","11");
                // finish and 继续监听
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mShakeListener.start();

                    }
                }, 2000);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(mShakeListener!=null)
        mShakeListener.stop();
        super.onDestroy();
    }

}