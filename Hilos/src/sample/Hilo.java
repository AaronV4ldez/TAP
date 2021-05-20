package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Hilo extends Thread{
    /*Crear clase y heredar de tread
    2) sobre escribir el metodo RUN
    3) Crear el while infinito
    4) crear el plataform
    5)Programar la logica
    */
    private int cont=0;
    private Label label;
    public Hilo(Label label){
        this.label=label;
    }
    @Override
    public void run() {
       //c ejecuta cuando inicia el proceso
        while (true){

            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        //muchas veces
                        System.out.println(cont);
                        label.setText(cont + "");
                        cont ++;
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
