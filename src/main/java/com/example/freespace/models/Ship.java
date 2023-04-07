package com.example.freespace.models;

import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Ship extends Thread{

    private TranslateTransition traslate;
    private ImageView naveIMG;
    private int contStepsUp;
    private int contStepsDown;
    private int limitUp;
    private int limitDown;
    private final double millis = 1;

    private int X;
    private int Y;

    public Ship(ImageView naveIMG){
        this.naveIMG = naveIMG;
        this.initializeDataShip();
    }
    public Ship(){
        this.initializeDataShip();
    }

    public void initializeDataShip(){
        this.traslate = new TranslateTransition();
        this.traslate.setNode(this.naveIMG);
        this.traslate.setDuration(Duration.millis(millis));
        this.contStepsUp = 0;
        this.contStepsDown = 0;
        this.limitUp = 9;
        this.limitDown = 9;
        this.X = 130;
        this.Y = 0;
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }
    public void moveShip(int orientation , int steps){

        if(orientation == 0){
            if(this.contStepsUp != this.limitUp){
                steps = steps * -1;
                this.traslate.setByY(steps);
                this.contStepsUp++;
                this.contStepsDown--;
                this.traslate.play();
                this.Y++;
            }
        }

        if(orientation == 3){
            if(contStepsDown != this.limitDown ){
                this.traslate.setByY(steps);
                this.contStepsDown++;
                this.contStepsUp--;
                this.traslate.play();
                this.Y--;
            }
        }



        //System.out.println("contStepsUp: "+ contStepsUp+", contStepsDown: " + contStepsDown +", limitUp: " +limitUp + ", limitDown:" + limitDown);
    }

    @Override
    public void run(){
        //ImageView
        while(true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
