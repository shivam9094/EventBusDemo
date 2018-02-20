package com.example.andrei.eventbusdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;

import de.greenrobot.event.EventBus;

/**
 * Created by andrei on 29.05.2015.
 */
public class ChargingReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        ChargingEvent event = null;
        Time now = new Time();
        now.setToNow();
        String timeOfEvent = now.format("%H:%M:%S");
        String eventData = "@" + timeOfEvent + "this device started";

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            event = new ChargingEvent(eventData + " charging.");
        } else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            event = new ChargingEvent(eventData + " discharging.");
        }
        EventBus.getDefault().post(event);
    }
}
