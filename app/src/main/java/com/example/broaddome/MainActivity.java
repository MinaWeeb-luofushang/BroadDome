package com.example.broaddome;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    private BroadTwo broadTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        testOnclick();
        broadTwo = new BroadTwo();
        IntentFilter filter = new IntentFilter();
        filter.addAction("heying.two");
        registerReceiver(broadTwo,filter);
    }
    private void init (){
        btn= findViewById(R.id.btn_test);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadTwo);
        super.onDestroy();
    }

    /**
     * 静态的在配置文件里面注册
     * */
    private void testOnclick(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("heying.two");
                sendBroadcast(intent);
            }
        });
    }
}
