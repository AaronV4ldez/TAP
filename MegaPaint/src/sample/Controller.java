package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML protected void initialize(){
        context=lienzo.getGraphicsContext2D();
        context.setFill(Color.BLACK);

    }
    public void arrastrar (MouseEvent event){
    context.fillOval(event.getX(), event.getY(), 10 , 10);

    }

}
