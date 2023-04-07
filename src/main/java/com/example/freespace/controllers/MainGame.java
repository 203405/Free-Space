package com.example.freespace.controllers;
import com.example.freespace.models.Meteor;
import com.example.freespace.models.Ship;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainGame extends Thread implements Initializable {
        @FXML
        private ImageView asteroideIMG1, asteroideIMG2, asteroideIMG3;
        @FXML
        private Button btnGo;
        @FXML
        private ImageView naveIMG;
        Ship ship;
        Meteor meteoro_1,meteoro_2,meteoro_3;

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


        private int ramdonNumber(int a, int b){
                int numero = (int)(Math.random()*b+a);
                return numero;
        }

        @FXML
        public void initialize(URL url, ResourceBundle resourceBundle) {

                this.ship = new Ship(naveIMG);
                meteoro_1 =  new Meteor(asteroideIMG1);
                meteoro_2 =  new Meteor(asteroideIMG2);
                meteoro_3 =  new Meteor(asteroideIMG3);
                meteoro_1.setVisible(true);
                meteoro_2.setVisible(true);
                meteoro_3.setVisible(true);
                meteoro_2.setY(7);
                meteoro_3.setY(-7);
                int ramdom = ramdonNumber(1,3);
                ramdom = 3;

                if(ramdom == 1){
                        meteoro_1.print("meteoro 1");
                        meteoro_1.start();
                        //meteoro_2.setVisible(false);
                        //meteoro_3.setVisible(false);
                        this.start();
                }
                if(ramdom == 2){
                        meteoro_2.print("meteoro 2");
                        meteoro_2.start();
                        //meteoro_1.setVisible(false);
                        //meteoro_3.setVisible(false);
                        this.start();
                }
                if(ramdom == 3){
                        meteoro_3.print("meteoro 3");
                        meteoro_3.start();
                        //meteoro_1.setVisible(false);
                        //meteoro_2.setVisible(false);
                        this.start();
                }

        }

        private synchronized void checkColicion(){
                if(meteoro_1.getX() > ship.getX()){
                        int diferencia = ship.getY() - meteoro_1.getY();
                        if(diferencia < 0){
                                diferencia = diferencia * -1;
                        }

                        if( ((diferencia >= 0) && (diferencia < 4 )) ){

                                //ImageView
                                naveIMG.setImage(new Image("C:\\Users\\doney\\IdeaProjects\\FreeSpace\\src\\main\\resources\\img\\explocionNave.jpg"));

                                ship.stop();
                                meteoro_1.stop();
                                //meteor.resetData();
                                this.stop();
                        }
                }

                if(meteoro_2.getX() > ship.getX()){
                        int diferencia = ship.getY() - meteoro_2.getY();
                        if(diferencia < 0){
                                diferencia = diferencia * -1;
                        }


                        if( ((diferencia >= 13) && (diferencia < 16 )) ){

                                //ImageView
                                naveIMG.setImage(new Image("C:\\Users\\doney\\IdeaProjects\\FreeSpace\\src\\main\\resources\\img\\explocionNave.jpg"));

                                ship.stop();
                                meteoro_2.stop();
                                //meteor.resetData();
                                this.stop();
                        }
                }

                if(meteoro_3.getX() > ship.getX()){
                        int diferencia = ship.getY() - meteoro_3.getY();
                        if(diferencia < 0){
                                diferencia = diferencia * -1;
                        }

                        if( ((diferencia >= 13) && (diferencia < 16)) ){

                                //ImageView
                                naveIMG.setImage(new Image("C:\\Users\\doney\\IdeaProjects\\FreeSpace\\src\\main\\resources\\img\\explocionNave.jpg"));

                                ship.stop();
                                meteoro_3.stop();
                                //meteor.resetData();
                                this.stop();
                        }
                }

        }

        @Override
        public void run(){
                while (true){
                        try {
                                sleep(100);
                        } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }

                        this.checkColicion();


                        if(meteoro_3.getSteps()>=96){
                                meteoro_2 = new Meteor(asteroideIMG2);
                                meteoro_2.setY(7);
                                meteoro_2.start();
                        }

                        if(meteoro_2.getSteps()>=96){
                                if(this.ramdonNumber(1,2) == 1){
                                        meteoro_1 = new Meteor(asteroideIMG1);
                                        meteoro_1.start();
                                }else{
                                        meteoro_3 = new Meteor(asteroideIMG3);
                                        meteoro_3.setY(-7);
                                        meteoro_3.start();
                                }

                        }

                        if(meteoro_1.getSteps()>=96){
                                meteoro_3 = new Meteor(asteroideIMG3);
                                meteoro_3.setY(-7);
                                meteoro_3.start();
                        }

                }

        }
}
