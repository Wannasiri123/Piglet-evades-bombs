package project;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class heal {
    int state = 1;
    int pasueg = 0;
    int check = 0;
    Image img;
    public int x =  (int) (Math.random() * 900)+20;
    public int y =  100;
    public int count = 0;
    heal(){
        String imageLocation = "heal.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		if(state == 1){
                    if(check==0){
                        y += 3;
                        x += 6;
                        check=1;
                    }
                    else if(check==1){
                        y += 3;
                        x -= 6;
                        check=2;
                    }
                    else if(check==2){
                        y += 3;
                        x -= 6;
                        check=3;
                    }
                    else if(check==3){
                        y += 3;
                        x += 6;
                        check=0;
                    }
                    
                }
                else if(state==2){
                    y += 8;
                }
                else if(state == 3){
                    y += 12;
                }
		if(y > 800){
                    img = null;
                    runner.stop();
                }
                try{
                    runner.sleep(30);
                }catch(InterruptedException e){}
            }
	}
    });
    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;

    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y,55,55));
    }
}
