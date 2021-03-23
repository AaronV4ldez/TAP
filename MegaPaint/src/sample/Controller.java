package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;



public class Controller {
    @FXML Canvas lienzo;
    @FXML Slider sloder;
    @FXML ComboBox combobox;
    GraphicsContext context;
    @FXML ColorPicker colorPicker;
    Color colorPincel=Color.BLACK;
    @FXML protected void initialize(){
        context=lienzo.getGraphicsContext2D();
        context.setFill(Color.BLACK);
        sloder.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                uwu(newValue.intValue());
            }
        });
        combobox.getItems().addAll("Cuadricula","Estrella","Estrella doble","Ajedrez");
    }
    public void uwu(int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        context.setFill(colorPincel);
        if(combobox.getSelectionModel().getSelectedIndex()==0){
            for (int x=0;x<valor;x++){//Cuadritos
                int diviciones=(int)lienzo.getWidth()/valor;
                context.strokeLine(0,diviciones*x,lienzo.getWidth(),diviciones*x);
                context.strokeLine(diviciones*x,lienzo.getHeight(),diviciones*x,0);
            }
        }else
        if(combobox.getSelectionModel().getSelectedIndex()==1){
            //estrella
            int mitadAncho=((int) lienzo.getWidth())/2;
            int mitadAlto=((int) lienzo.getHeight())/2;
            context.strokeLine(mitadAncho,0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0,mitadAlto,lienzo.getHeight(),mitadAlto);
            int diviciones=mitadAncho/valor;
            int diviciones1=mitadAlto/valor;
            for(int i=0;i<valor;i++){
                context.strokeLine(mitadAncho,diviciones * i,mitadAncho+(diviciones*i),mitadAlto);
                context.strokeLine(diviciones * i,mitadAncho,mitadAlto,mitadAncho+(diviciones*i));
                context.strokeLine(mitadAncho,diviciones*i,mitadAncho-(diviciones*i),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getWidth()-(diviciones*i),mitadAncho+(diviciones*i),mitadAlto);
            }
        }else
        if(combobox.getSelectionModel().getSelectedIndex()==2){
            //Estrella doble
            int mitadAncho=((int) lienzo.getWidth())/2;
            int mitadAlto=((int) lienzo.getHeight())/2;
            int mitadAncho1=((int) lienzo.getWidth())/4;
            int mitadAlto1=((int) lienzo.getHeight())/4;
            context.strokeLine(mitadAncho,0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0,mitadAlto,lienzo.getHeight(),mitadAlto);
            int diviciones=mitadAncho/valor;
            int diviciones1=mitadAlto/valor;
            for(int i=0;i<valor;i++) {
                //estrella
                context.strokeLine(mitadAncho, diviciones * i, mitadAncho + (diviciones * i), mitadAlto);
                context.strokeLine(diviciones * i, mitadAncho, mitadAlto, mitadAncho + (diviciones * i));
                context.strokeLine(mitadAncho, diviciones * i, mitadAncho - (diviciones * i), mitadAlto);
                context.strokeLine(mitadAncho, lienzo.getWidth() - (diviciones * i), mitadAncho + (diviciones * i), mitadAlto);
                //segunda estrella
                context.strokeLine(diviciones*i,diviciones*i, mitadAncho+(diviciones*i),mitadAlto-(diviciones*i));
                context.strokeLine(diviciones*i,diviciones*i, mitadAncho-(diviciones*i),mitadAlto+(diviciones*i));
                context.strokeLine(lienzo.getWidth()-(diviciones*i),lienzo.getHeight()-diviciones*i, mitadAncho+(diviciones*i),mitadAlto-(diviciones*i));
                context.strokeLine(lienzo.getWidth()-(diviciones*i),lienzo.getHeight()-diviciones*i, mitadAncho-(diviciones*i),mitadAlto+(diviciones*i));
                //curvas
                context.strokeLine(0,mitadAncho+(diviciones*i),diviciones*i,lienzo.getHeight());
                context.strokeLine(lienzo.getWidth(),mitadAncho+(diviciones*i),lienzo.getWidth()-(diviciones*i),lienzo.getHeight());
                context.strokeLine(0,mitadAncho-(diviciones*i),diviciones*i,0);
                context.strokeLine(lienzo.getWidth(),mitadAlto-(diviciones*i),lienzo.getWidth()-(diviciones*i),0);

            }

        }else
        if(combobox.getSelectionModel().getSelectedIndex()==3){
            context.fillRect(0,0,lienzo.getWidth(), lienzo.getHeight());
            int separacion = 2*valor;
            for(int x=0; x<=lienzo.getWidth(); x+=separacion){
                for(int y=0; y<=lienzo.getWidth(); y+=separacion){
                    context.clearRect(x,y,valor,valor);
                }
            }
            for(int x=valor; x<=lienzo.getWidth(); x+=separacion) {
                for (int y = valor; y <= lienzo.getWidth(); y += separacion) {
                    context.clearRect(x, y, valor, valor);
                }
            }
        }
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
