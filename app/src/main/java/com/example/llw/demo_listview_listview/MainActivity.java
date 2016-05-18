package com.example.llw.demo_listview_listview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback {
    private static final String TAG = "MainActivity";
    private Button btnStart;
    private TextView textviewShow;
    StringBuilder gnirts = null;
    public android.os.Handler handler;


    private void assignViews() {
        btnStart = (Button) findViewById(R.id.btn_start);
        textviewShow = (TextView) findViewById(R.id.textview_show);
        btnStart.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    textviewShow.setText(msg.toString());
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                Fun();
                break;
        }
    }

    public void Fun() {
        Model model = new Model(this);
        model.execute("https://www.baidu.com/");
    }


    //注意该方法是在子线程中执行的
    @Override
    public void back(String string) {
        Message message = new Message();
        message.what = 1;
        message.obj = string;
        handler.sendMessage(message);
    }
}
