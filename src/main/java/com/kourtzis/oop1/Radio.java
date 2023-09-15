package com.kourtzis.oop1;

public class Radio {
    private boolean isOn;
    private double frequency;
    private int volume;

    public Radio(boolean isOn, double frequency, int volume) {
        this.isOn = isOn;
        this.frequency = frequency;
        this.volume = volume;
    }

    public Radio()  {
        this(false, 85.0, 0);
    }

    public void increaseVolume() {
        if(isOn) {
            ++volume;

            if(volume >= 10) {
                volume = 10;
            }
        }
    }

    public void decreaseVolume() {
        if(isOn) {
            --volume;

            if(volume <= 0) {
                volume = 0;
            }
        }
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }

    public void setRadioStation(double frequency) {
        if(frequency < 85.0 || frequency > 110.0) {
            this.frequency = 99.9;
        }
        else {
            this.frequency = frequency;
        }
    }

    @Override
    public String toString() {
        return String.format("Radio: %b, Freq: %f, Laut: %d", isOn, frequency, volume);
    }
}
