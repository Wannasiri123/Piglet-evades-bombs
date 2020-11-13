package project;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import sun.audio.*;

public class home extends JPanel{
    ImageIcon backgroud = new ImageIcon(this.getClass().getResource("bgg.gif"));
    ImageIcon imgpp = new ImageIcon(this.getClass().getResource("phome.gif"));
    ImageIcon start = new ImageIcon(this.getClass().getResource("playbutton.png"));
    playgame gameplay = new playgame();
    int keyX;
    int keyY;
    

    home(){
        setLayout(null);
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                if(e.getX() >= 0 && e.getX() <= 920 && e.getY() >=0 && e.getY() <= 625){
                    keyX = e.getX();
                    keyY = e.getY();
                                }
            }
        }
    );
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (keyX >= 690 && keyX <= 840 && keyY >= 420 && keyY <= 570) {
                    setSize(1000, 800);
                    add(gameplay);
                    gameplay.setBounds(0, 0, 1000, 800);
                    gameplay.requestFocusInWindow();
                    gameplay.timestart = false;
                    gameplay.HP = 3;
                    gameplay.times = 30;
                    gameplay.startf = false;
                    gameplay.timestart = false;
                    gameplay.pauseg = 1;
                } 
            }
        });

}
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroud.getImage(),0,0,1000,800,this);
        g.drawImage(start.getImage(),690,420,150,150,this);
        g.drawImage(imgpp.getImage(), 250, 300, 400, 400, this);
        g.setColor(Color.white);
        g.setFont(new Font("2005_iannnnnMTV", Font.HANGING_BASELINE, 90));
        g.drawString("Piglet evades bombs", 100, 100);
    }
    
}