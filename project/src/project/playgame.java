package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class playgame extends JPanel {
    int keyX;
    int keyY;
    int form = 1;
    int state = 1;
    
    ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("bgg1.gif"));
    ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("bgg2.gif"));
    ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("bgg3.gif"));
    ImageIcon heal = new ImageIcon(this.getClass().getResource("heal.png"));
    ImageIcon imgover = new ImageIcon(this.getClass().getResource("go.gif"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("re.png"));
    ImageIcon  close = new ImageIcon(this.getClass().getResource("exit.png"));
    ImageIcon  close2 = new ImageIcon(this.getClass().getResource("exit2.png"));
    ImageIcon  winpop = new ImageIcon(this.getClass().getResource("pwin.gif"));
    ImageIcon  winback = new ImageIcon(this.getClass().getResource("bwin.gif"));
    ImageIcon  winwin = new ImageIcon(this.getClass().getResource("winner.gif"));
   
    public int random = 0; 
    boolean endgame=false;
    
    Pig aa = new Pig();
   
    JLabel Tscore = new JLabel();
    ArrayList<heal> heall = new ArrayList<heal>(); //+1ชีวิต
    ArrayList<bomb1> bomb1l = new ArrayList<bomb1>(); //-1 ชีวิต
    ArrayList<bomb2> bomb2l = new ArrayList<bomb2>();
    ArrayList<bomb3> bomb3l = new ArrayList<bomb3>();
    int times;
    int HP;
    boolean timestart;
    boolean startf;
    int pauseg;
    Thread all = new Thread(new Runnable() {
        public void run(){ 
            if(!endgame){
            
                if (pauseg == 0) {
                    while (true) {
                        try {
                            Thread.sleep(1);
                        } catch (Exception e) {
                        }
                        repaint();
                    }
                }
            }

    }
    });
    Thread tbomb1 = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            if (state == 1) {
                                Thread.sleep(3000);
                            } else if (state == 2) {
                                Thread.sleep(2000);
                            } else if (state == 3) {
                                Thread.sleep(1000);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        bomb1l.add(new bomb1());
                    }
                }
            }
        }
    });

    Thread tbomb2 = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            if (state == 1) {
                                Thread.sleep(3000);
                            } else if (state == 2) {
                                Thread.sleep(2000);
                            } else if (state == 3) {
                                Thread.sleep(1000);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        bomb2l.add(new bomb2());
                    }
                }
            }
        }
    });

    Thread tbomb3 = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            if (state == 1) {
                                Thread.sleep(3000);
                            } else if (state == 2) {
                                Thread.sleep(2000);
                            } else if (state == 3) {
                                Thread.sleep(1000);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        bomb3l.add(new bomb3());
                    }
                }
            }
        }
    });
    
     Thread theal = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (3000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        heall.add(new heal());
                    }
                }
            }
        }
    });

    
     Thread t = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    if (timestart == false) {
                        times = (times - 1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    playgame() {
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if(pauseg == 1){
                    System.out.println(pauseg);
                if (a == KeyEvent.VK_LEFT) {
                    aa.x -= 10;
                    form = 1;
                } else if (a == KeyEvent.VK_RIGHT) {
                    aa.x += 10;
                    form = 0;
                }
                if (aa.count > 3) {
                    aa.count = 0;
                }
                }
            }
            public void keyReleased(KeyEvent e) {
                aa.count = 0;
            }
            });
        
        aa.x = 400;
        all.start();
        t.start();
        theal.start();
        tbomb1.start();
        tbomb2.start();
        tbomb3.start();
          
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                keyX = e.getX();
                keyY = e.getY();
            }
        });
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                if (keyX >= 850 && keyX <= 890 && keyY >= 30 && keyY <= 70) {
                    System.exit(0);
                } 
                else if (keyX >= 850 && keyX <= 890 && keyY >= 100 && keyY <= 140) {
                    pauseg = 0;
                    setSize(1000, 800);
                    requestFocusInWindow();
                    System.out.println(pauseg);
                    t.suspend();
                    all.suspend(); 
                    theal.suspend();
                    tbomb1.suspend();
                    tbomb2.suspend();
                    tbomb3.suspend();
                     
                    if (!bomb1l.isEmpty()) {
                        for (int i = 0; i < bomb1l.size(); i++) {
                            bomb1l.get(i).runner.suspend();
                        }
                    }
                    if (!bomb2l.isEmpty()) {
                        for (int i = 0; i < bomb2l.size(); i++) {
                            bomb2l.get(i).runner.suspend();
                        }
                    }
                    if (!bomb3l.isEmpty()) {
                        for (int i = 0; i < bomb3l.size(); i++) {
                            bomb3l.get(i).runner.suspend();
                        }
                    }
                    
                    if (!heall.isEmpty()) {
                        for (int i = 0; i < heall.size(); i++) {
                            heall.get(i).runner.suspend();
                        }
                    }
                    
                } else if (keyX >= 850 && keyX <= 890 && keyY >= 165 && keyY <= 210) {
                    setSize(1000, 800);
                    requestFocusInWindow();
                    pauseg = 1;
                    System.out.println(pauseg);
                    t.resume();
                    all.resume();            
                    t.resume();
                    theal.resume();
                    tbomb1.resume();
                    tbomb2.resume();
                    tbomb3.resume();
                    
                    
                    if (!bomb1l.isEmpty()) {
                        for (int i = 0; i < bomb1l.size(); i++) {
                            bomb1l.get(i).runner.suspend();;
                        }
                    }
                    if (!bomb2l.isEmpty()) {
                        for (int i = 0; i < bomb2l.size(); i++) {
                            bomb2l.get(i).runner.suspend();;
                        }
                    }
                    if (!bomb3l.isEmpty()) {
                        for (int i = 0; i < bomb3l.size(); i++) {
                            bomb3l.get(i).runner.suspend();;
                        }
                    }
                    
                    if (!heall.isEmpty()) {
                        for (int i = 0; i < heall.size(); i++) {
                            heall.get(i).runner.resume();
                        }
                    }
                } else if (keyX >= 490 && keyX <= 570 && keyY >= 510 && keyY <= 600) {
                    home bb = new home();
                    setSize(1000, 800);
                    add(bb);
                    bb.setBounds(0, 0, 1000, 800);
                    bb.setFocusable(true);
                    bb.requestFocusInWindow();
                } else if (keyX >= 645 && keyX <= 715 && keyY >= 515 && keyY <= 600) {
                    System.exit(0);
                }
            }
        });
    }
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
       //  over
       
        if ( HP <= 0) {
            this.setLayout(null);
            g.drawImage(imgover.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(restart.getImage(), 494, 520, 75, 75, this);
            g.drawImage(close2.getImage(), 645, 520, 75, 75, this);
        } 

        else if(times <=0)
        {
            state++;
            if(state==4){
                endgame = true;
            }
            times = 30;
        }
     //  win
        else if(state == 4){
            g.drawImage(winback.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(winpop.getImage(), 100, 400, 400, 400, this);
            g.drawImage(winwin.getImage(), 50, 20, 400, 400, this);
            g.drawImage(restart.getImage(), 494, 520, 75, 75, this);
            g.drawImage(close2.getImage(), 645, 520, 75, 75, this);
        }
        
        //1
        
        else if(state == 1){
            g.drawImage(imgstate1.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(close.getImage(), 850, 30, 60, 40, this);
            g.drawImage(aa.imPig[0].getImage(), aa.x, 500, 200, 150, this);

            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            } 
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            
            
            for (int i = 0; i < bomb1l.size(); i++) {
                g.drawImage(bomb1l.get(i).getImage(), bomb1l.get(i).getX(), bomb1l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb1l.size(); j++) {
                if (Intersect(aa.getbound(), bomb1l.get(j).getbound())) {
                    bomb1l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < bomb2l.size(); i++) {
                g.drawImage(bomb2l.get(i).getImage(), bomb2l.get(i).getX(), bomb2l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb2l.size(); j++) {
                if (Intersect(aa.getbound(), bomb2l.get(j).getbound())) {
                    bomb2l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < bomb3l.size(); i++) {
                g.drawImage(bomb3l.get(i).getImage(), bomb3l.get(i).getX(), bomb3l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb3l.size(); j++) {
                if (Intersect(aa.getbound(), bomb3l.get(j).getbound())) {
                    bomb3l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            // heal
            for (int i = 0; i < heall.size(); i++) {
                g.drawImage(heall.get(i).getImage(), heall.get(i).getX(), heall.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < heall.size(); j++) {
                if (Intersect(aa.getbound(), heall.get(j).getbound())) {
                    heall.remove(j);
                    HP += 1;
                    g.drawString("+1HP", aa.x + 100, 580);
                }
            }
            g.setFont(new Font("Brush Script MT", Font.HANGING_BASELINE, 30));
            g.setColor(Color.BLACK);
            g.setFont(new Font("Brush Script MT", Font.HANGING_BASELINE, 50));
            g.drawString("STATE " + 1, 350, 80);
            g.drawString("Time " + times, 335, 150);
            g.drawString("HP  " + HP, 50, 100);
        }
        
       
        //   2
            else if(state == 2){
            g.drawImage(imgstate2.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(close.getImage(), 850, 30, 60, 40, this);
            g.drawImage(aa.imPig[0].getImage(), aa.x, 500, 200, 170, this);

            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            } 
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }

            for (int i = 0; i < bomb1l.size(); i++) {
                g.drawImage(bomb1l.get(i).getImage(), bomb1l.get(i).getX(), bomb1l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb1l.size(); j++) {
                if (Intersect(aa.getbound(), bomb1l.get(j).getbound())) {
                    bomb1l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < bomb2l.size(); i++) {
                g.drawImage(bomb2l.get(i).getImage(), bomb2l.get(i).getX(), bomb2l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb2l.size(); j++) {
                if (Intersect(aa.getbound(), bomb2l.get(j).getbound())) {
                    bomb2l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < bomb3l.size(); i++) {
                g.drawImage(bomb3l.get(i).getImage(), bomb3l.get(i).getX(), bomb3l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb3l.size(); j++) {
                if (Intersect(aa.getbound(), bomb3l.get(j).getbound())) {
                    bomb3l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            for (int i = 0; i < heall.size(); i++) {
                g.drawImage(heall.get(i).getImage(), heall.get(i).getX(), heall.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < heall.size(); j++) {
                if (Intersect(aa.getbound(), heall.get(j).getbound())) {
                    heall.remove(j);
                    HP += 1;
                    g.drawString("+1HP", aa.x + 100, 580);
                }
            }
            
            g.setFont(new Font("Brush Script MT", Font.HANGING_BASELINE, 30));
            g.setColor(Color.BLACK);
            g.setFont(new Font("Brush Script MT", Font.HANGING_BASELINE, 50));
            g.drawString("STATE " + 2, 350, 80);
            g.drawString("Time " + times, 335, 150);
            g.drawString("HP  " + HP, 50, 100);
        }
            
            
          // 3
        
            else if(state == 3){
            g.drawImage(imgstate3.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(close.getImage(), 850, 30, 60, 40, this);
            g.drawImage(aa.imPig[0].getImage(), aa.x, 500, 200, 170, this);

            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            } 
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            
         
            for (int i = 0; i < bomb1l.size(); i++) {
                g.drawImage(bomb1l.get(i).getImage(), bomb1l.get(i).getX(), bomb1l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb1l.size(); j++) {
                if (Intersect(aa.getbound(), bomb1l.get(j).getbound())) {
                    bomb1l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < bomb2l.size(); i++) {
                g.drawImage(bomb2l.get(i).getImage(), bomb2l.get(i).getX(), bomb2l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb2l.size(); j++) {
                if (Intersect(aa.getbound(), bomb2l.get(j).getbound())) {
                    bomb2l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < bomb3l.size(); i++) {
                g.drawImage(bomb3l.get(i).getImage(), bomb3l.get(i).getX(), bomb3l.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < bomb3l.size(); j++) {
                if (Intersect(aa.getbound(), bomb3l.get(j).getbound())) {
                    bomb3l.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                }
            }
            
            for (int i = 0; i < heall.size(); i++) {
                g.drawImage(heall.get(i).getImage(), heall.get(i).getX(), heall.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < heall.size(); j++) {
                if (Intersect(aa.getbound(), heall.get(j).getbound())) {
                    heall.remove(j);
                    HP += 1;
                    g.drawString("+1HP", aa.x + 100, 580);
                }
            }
            
            
            g.setFont(new Font("Brush Script MT", Font.HANGING_BASELINE, 30));
            g.setColor(Color.BLACK);
            g.setFont(new Font("Brush Script MT", Font.HANGING_BASELINE, 50));
            g.drawString("STATE " + 3, 350, 80);
            g.drawString("Time " + times, 335, 150);
            g.drawString("HP  " + HP, 50, 100);
        }
        
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}