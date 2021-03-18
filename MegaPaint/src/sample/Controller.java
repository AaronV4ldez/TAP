package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;



public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML ColorPicker colorPicker;
    Color colorPincel=Color.BLACK;
    @FXML protected void initialize(){
        context=lienzo.getGraphicsContext2D();
        context.setFill(Color.BLACK);

    }
    public void arrastrar (MouseEvent event){
        context.setFill(colorPincel);
    context.fillOval(event.getX(), event.getY(), 10 , 10);
    }
    public void cambiarColor (ActionEvent event){
        colorPincel= colorPicker.getValue();
    }

    public void borrar (ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0, lienzo.getHeight(), lienzo.getWidth());
    }

}
