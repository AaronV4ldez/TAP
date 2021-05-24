package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Label lbl1, lbl2, lbl3, lbl4;
    @FXML
    Button btn;
    Hilo h1,h2,h3,h4;


    public void generar (ActionEvent event){
        if (btn.getText().equals("Generar")){
            h1=new Hilo(lbl1);
            h2=new Hilo(lbl2);
            h3=new Hilo(lbl3);
            h4=new Hilo(lbl4);
            h1.start();
            h2.start();
            h3.start();
            h4.start();
            btn.setText("Detener");
        }else {
            h1.stop();
           if (lbl2.getText() != lbl1.getText() && lbl2.getText() != lbl4.getText()  && lbl2.getText() != lbl3.getText()){
                h2.stop();
                /*h3.stop();
                h4.stop();*/
            } if (lbl3.getText() != lbl2.getText() && lbl3.getText() != lbl4.getText()  && lbl3.getText() != lbl1.getText()){
                h3.stop();
            } if (lbl4.getText() != lbl3.getText() && lbl4.getText() != lbl2.getText()  && lbl4.getText() != lbl1.getText()){
                h4.stop();
            }/*else {
                h2.start();
                h3.start();
                h4.start();
            }*/
            /*else if (lbl3.getText() != lbl2.getText()){
                h3.stop();
           }*/


            btn.setText("Generar");
        }
    }
}
