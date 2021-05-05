package com.example.vku.model;

import com.google.gson.annotations.SerializedName;

public class post {
    @SerializedName("api-key")
    private String apikey;
    private int speed;
    private String voice;

    public post(String apikey, int speed, String voice) {
        this.apikey = apikey;
        this.speed = speed;
        this.voice = voice;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return "post{" +
                "apikey='" + apikey + '\'' +
                ", speed=" + speed +
                ", voice='" + voice + '\'' +
                '}';
    }
}
