package com.example.letsving.model;

public class Meeting {

    String meetingName,time,scan;

    public Meeting(String meetingName, String time, String scan) {
        this.meetingName = meetingName;
        this.time = time;
        this.scan = scan;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }
}
