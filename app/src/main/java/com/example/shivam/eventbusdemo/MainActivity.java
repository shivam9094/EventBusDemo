package com.example.shivam.eventbusdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {


    private EventBus bus = EventBus.getDefault();
    private TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(new ChargingReceiver(), new IntentFilter(Intent.ACTION_POWER_CONNECTED));

        registerReceiver(new ChargingReceiver(), new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        view = new TextView(this);
        view.setTextSize(20f);
        view.setPadding(20, 20, 20, 20);
        view.setText("Waiting for events...");

        setContentView(view);

        bus.register(this);

    }

    @Override
    protected void onDestroy() {    bus.unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(ChargingEvent event) {
        view.setText(view.getText() + "\n" + event.getData());
    }
}
