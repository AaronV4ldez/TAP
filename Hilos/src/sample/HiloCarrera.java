package sample;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class HiloCarrera extends Thread{
    private ImageView objeto;
private long tiempo=1000;
public HiloCarrera(ImageView objeto, Long tiempo){
    this.objeto=objeto;
    this.tiempo=tiempo;
}
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (cont==0){
                            objeto.setLayoutX(objeto.getLayoutX()+10);
                            System.out.println(objeto.getLayoutX()+"");
                            System.out.println(objeto.getLayoutY()+"");
                            if (objeto.getLayoutX()>=410){
                                cont=1;
                            }
                        }else if (cont==1){
                            objeto.setLayoutY(objeto.getLayoutY()+10);
                            if (objeto.getLayoutY()>=410){
                                con=2;
                            }
                        }else  if (cont==2){
                            if (tiempo==200 && contConejo<160){
                                objeto.setLayoutX(objeto.getLayoutX()+0);
                                conConejo ++;
                            }else {
                                objeto.setLayoutX(objeto.getLayoutX()-10);
                            }
                            if (objeto.getLayoutX()<=120){
                                cont=3;
                            }
                        }else if (cont==3){
                            objeto.setLayoutX(objeto.getLayoutX()+0);
                        }
                    }

                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
