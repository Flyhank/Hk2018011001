package com.n9s.flyjet.hk2018011001;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Handler handler;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        tv = findViewById(R.id.textView);   //TextView/layout元件內的Text要先改為"0",才能顯示數字
        //MyThread t = new MyThread();
        //t.start();
        handler.post(r);    //任務訊息post給Handler
    }

    Runnable r = new Runnable()     //宣告一個runnable介面
    {
        @Override
        public void run()
        {
            tv.setText(String.valueOf(Integer.valueOf(tv.getText().toString())+1)); //每秒逐步+1顯示
            handler.postDelayed(r, 1000);
        }
    };


    /*
    class MyThread extends Thread
    {
        @Override
        public void run()
        {
            super.run();

            while(true)
            {
                try
                {
                    Thread.sleep(1000); //每秒
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        tv.setText(String.valueOf(Integer.valueOf(tv.getText().toString())+1)); //每秒逐步+1顯示
                    }
                });

            }
        }
    }*/

}

