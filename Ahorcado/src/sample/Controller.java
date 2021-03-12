package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML HBox contenedor;
    @FXML AnchorPane padre;
    String [] palabras = {"TLACUACHE", "GATO",  "CANELA", "ATUN", "MOUSEPAD", "MAZAPAN", "MANGA"};

        TextField[] arrayTxT=null;
        @FXML protected void initialize (){
        Random random= new Random();
        int aleatorio = random.nextInt(6);
        String palabra =palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxT=new TextField[palabra.length()];
        int ayuda = 1;//letras de ayuda owo

        final int [] po={-1};
        for (int x=0; x<palabra.length(); x++){
            arrayTxT [x] =new TextField();
            arrayTxT [x].setPrefWidth(50);
            arrayTxT [x].setPrefHeight(50);
            arrayTxT [x].setId("txt-"+ x + "-" + palabra.charAt(x));
            arrayTxT [x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField=(TextField) event.getTarget();
                    textField.getText();
                    String[] nombre=textField.getId().split( "-");
                    if (nombre[2].equals(textField.getText().toLowerCase()) ){
                        System.out.println("Correcto "+ textField.getId());
                        textField.setDisable(true);
                        }else {
                        System.out.println("Incorrecto "+ textField.getId());
                        textField.setText("");

                        ImageView cabeza =new ImageView(new Image( "sample/img/cabezaxd.png" ));
                        cabeza.setFitHeight(300);
                        cabeza.setFitWidth(200);
                        cabeza.setLayoutX(150);
                        cabeza.setLayoutY(170);
                        padre.getChildren().add(cabeza);
                      po[0]++;

                    }
                    if (po[0]==1){
                        ImageView torso =new ImageView(new Image( "sample/img/torso.png" ));
                        torso.setFitHeight(300);
                        torso.setFitWidth(200);
                        torso.setLayoutX(150);
                        torso.setLayoutY(170);
                        padre.getChildren().add(torso);
                    }
                    if (po[0]==2){
                        ImageView BI =new ImageView(new Image( "sample/img/brazo izquierdo.png" ));
                        BI.setFitHeight(300);
                        BI.setFitWidth(200);
                        BI.setLayoutX(150);
                        BI.setLayoutY(170);
                        padre.getChildren().add(BI);
                    }
                    if (po[0]==3){
                        ImageView BD =new ImageView(new Image( "sample/img/brazo derecho.png" ));
                        BD.setFitHeight(300);
                        BD.setFitWidth(200);
                        BD.setLayoutX(150);
                        BD.setLayoutY(170);
                        padre.getChildren().add(BD);
                    }
                    if (po[0]==4){
                        ImageView PI =new ImageView(new Image( "sample/img/pierna izquierda.png" ));
                        PI.setFitHeight(300);
                        PI.setFitWidth(200);
                        PI.setLayoutX(150);
                        PI.setLayoutY(170);
                        padre.getChildren().add(PI);
                    }
                    if (po[0]==5){
                        ImageView PD =new ImageView(new Image( "sample/img/pierna derecha.png" ));
                        PD.setFitHeight(300);
                        PD.setFitWidth(200);
                        PD.setLayoutX(150);
                        PD.setLayoutY(170);
                        padre.getChildren().add(PD);
                    }


                    //System.out.printf(arrayTxT [x]);
                }
            });
            contenedor.getChildren().add(arrayTxT [x]);
        }
    }


}
