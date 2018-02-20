package com.example.andrei.eventbusdemo;

/**
 * Created by andrei on 29.05.2015.
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
