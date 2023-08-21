package com.example.threads;

public class MyMessage {
    private String sender;
    private String message;
    private long time;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public MyMessage(String threadName, String message, long time) {
        this.sender = threadName;
        this.message = message;
        this.time = time;
    }
}
