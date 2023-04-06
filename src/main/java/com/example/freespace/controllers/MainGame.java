package com.example.freespace.controllers;
import com.example.freespace.models.Meteor;
import com.example.freespace.models.Ship;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainGame extends Thread implements Initializable {
        @FXML
        private ImageView asteroideIMG;
        @FXML
        private Button btnGo;
        @FXML
        private ImageView naveIMG;
        Ship ship;
        Meteor meteor;

        @FXML
        void onMouseClickMoveShip(MouseEvent event) {

        }

        @FXML
        void onKeyPressedMoveShip(KeyEvent event) {

                int orientation = 0;
                int steps = 0;
                String codeKey = event.getCode().toString();

                if(codeKey.equals("W") || codeKey.equals("UP")){
                        orientation = 0;
                        steps = 20;
                }

                if(codeKey.equals("S") || codeKey.equals("DOWN")){
                        orientation = 3;
                        steps = 20;
                }

                this.ship.moveShip(orientation,steps);
        }

        @FXML
        public void initialize(URL url, ResourceBundle resourceBundle) {
                this.ship = new Ship(naveIMG);
                //this.ship.start();
                meteor =  new Meteor(asteroideIMG);
                meteor.start();
                this.start();
        }

        @Override
        public void run(){
                while (true){
                        try {
                                sleep(100);
                        } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                        System.out.println();
                        if(meteor.getX() > ship.getX()){
                                int diferencia = ship.getY() - meteor.getY();
                                if(diferencia < 0){
                                        diferencia = diferencia * -1;
                                }
                                System.out.println(diferencia);
                                if( ((diferencia >= 0) && (diferencia < 4 )) ){
                                        //ImageView
                                        naveIMG.setImage(new Image("C:\\Users\\doney\\IdeaProjects\\FreeSpace\\src\\main\\resources\\img\\explocionNave.jpg"));

                                        ship.stop();
                                        meteor.stop();
                                        //meteor.resetData();
                                        this.stop();
                                }
                        }
                }
        }
}