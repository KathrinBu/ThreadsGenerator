package com.example.threads;

import javafx.beans.property.SimpleStringProperty;

public class ObservableMessage {
    SimpleStringProperty sender;
    SimpleStringProperty message;
    SimpleStringProperty time;

    public String getSender() {
        return sender.get();
    }

    public SimpleStringProperty senderProperty() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender.set(sender);
    }

    public String getMessage() {
        return message.get();
    }

    public SimpleStringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public ObservableMessage(SimpleStringProperty sender, SimpleStringProperty message, SimpleStringProperty time) {
        this.sender = sender;
        this.message = message;
        this.time = time;
    }
}
