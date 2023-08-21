package com.example.threads;

import javafx.collections.ObservableList;

public class Generator extends Thread{
    String name;
    ObservableList<ObservableMessage> message;

    int k;

    public Generator(String name, ObservableList<ObservableMessage> message, int time) {
        this.name = name;
        this.message = message;
        this.k = time;
    }

    public Generator(String name, int time) {
        this.name = name;
        this.k = time;
    }
    public void work(){

    }


}
