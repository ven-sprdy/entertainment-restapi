package com.prasaddy.entertainmentapp.io.entity;

import java.util.List;

public class TrackModal {

    private String trackName;
    private List<String> singersName;

    public TrackModal() {
    }

    public TrackModal(String trackName, List<String> singersName) {
        this.trackName = trackName;
        this.singersName = singersName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<String> getSingersName() {
        return singersName;
    }

    public void setSingersName(List<String> singersName) {
        this.singersName = singersName;
    }

}
