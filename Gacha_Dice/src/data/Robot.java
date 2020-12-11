package data;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Robot extends Player {

    public Robot(String Name) {
        super(Name);
    }
    public void lose(ImageView imageView){
        if (this.getIsWin() == true){
//            Image image = new Image("bomman2.gif");
//            imageView.setImage(image);
        }else {
            Random generator = new Random();
            int soTT = generator.nextInt(4) + 1 ;
//            Image image = new Image("bomman1" + soTT +".gif");
//            imageView.setImage(image);
        }
    }
}
