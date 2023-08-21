package com.example.threads;

import javafx.collections.ObservableList;

import java.util.Random;

public class Generator extends Thread{

    String name;
    ObservableList<MyMessage> message;

    long k;

    public Generator(String name, ObservableList<MyMessage> message, int time) {
        this.name = name;
        this.message = message;
        this.k = time;
    }

    public Generator(String name, int time) {
        this.name = name;
        this.k = time;
    }
    public static void work(String sender, ObservableList<ObservableMessage>messages) throws InterruptedException {
        Random random=new Random();
        try{
        for (int i = 0; i < 15; i++) {
        String message="Message "+i;
        long time= System.currentTimeMillis();
        ObservableMessage observableMessage=new ObservableMessage(sender,message,time);
        messages.add(observableMessage);
        int interval=random.nextInt(400)+100;
        Thread.sleep(interval);}

        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    }



