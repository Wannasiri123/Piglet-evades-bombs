package project;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class Pig {
    public ImageIcon[] imPig = new ImageIcon[1];
    public int y = 300;
    public int x ;
    public int count = 0;
    Pig() {
        for (int i = 0; i < imPig.length; i++) {
            String imageLocation ="pigg.gif";
            imPig[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
    public int getX() {
        return x;

    }
    public int getY() {
        return y;

    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(this.x+80,this.y+230,30,30));
    }
    
}
