package com.example.freespace.models;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Meteor extends Thread{
    private TranslateTransition traslate;
    ImageView asteroideIMG;
    private int steps;
    private long millis;
    private int X;
    private int Y;


    public Meteor(ImageView asteroideIMG){
        this.asteroideIMG = asteroideIMG;
        this.initializeDataMeteor();
    }

    public Meteor(){
        this.initializeDataMeteor();
    }

    public void resetData(int position){
        this.initializeDataMeteor();
        this.traslate.setByX(position);
        this.traslate.play();
    }
    private void initializeDataMeteor(){
        this.steps = 0;
        this.millis = 50;
        this.traslate = new TranslateTransition();
        this.traslate.setNode(this.asteroideIMG);
        this.traslate.setDuration(Duration.millis(50));
        this.asteroideIMG.setX(0);
        this.X = 70;
        this.Y = 0;
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }

    @Override
    public void run(){
        while(true){

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        while(this.steps != 97){

            this.steps++;
            try {
                sleep(this.millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //System.out.println(this.steps);
            this.traslate.setByX(-20);
            this.traslate.play();
            this.X++;
        }
            this.steps = 0;
            this.resetData(1000);
            this.initializeDataMeteor();
        }
    }
}
