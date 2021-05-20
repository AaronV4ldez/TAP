package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class Controller {
    @FXML Label lblnumero;
    @FXML
    ImageView liebre, tortuga;
    Hilo hilo1;
    HiloCarrera hiloLiebre, hiloTortuga;


    public void iniciar(ActionEvent event){
        hiloLiebre=new HiloCarrera(liebre, 500L);
        hiloTortuga=new HiloCarrera(tortuga, 1000L);


        hiloTortuga.start();
        hiloLiebre.start();
//hilo1=new Hilo(lblnumero);
//hilo1.start();
    }
    public void detener (ActionEvent event){
hilo1.stop();
    }

}
