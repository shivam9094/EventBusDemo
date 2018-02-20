package com.example.shivam.eventbusdemo;

/**
 * Created by Shivam on 20-02-2018.
 */

public class ChargingEvent {

    private String data;

    public ChargingEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
