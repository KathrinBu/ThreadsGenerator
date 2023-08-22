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

    @Override
    public void run() {
        work(name, message);
    }

    public static void work(String sender, ObservableList<MyMessage>messages) {
        Random random=new Random();
        try{
            for (int i = 0; i < 10; i++) {
                String message="Message "+i+" from "+sender;
                long time= System.currentTimeMillis();
                MyMessage observableMessage=new MyMessage(sender,message,time);
                messages.add(observableMessage);
                int interval=random.nextInt(400)+100;
                Thread.sleep(interval);
            }
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    }



