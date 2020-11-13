package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Project extends JFrame {
    home homegames1 = new home();      //สร้างออบเจ็ค หน้าโฮมเกม
    playgame gameplay = new playgame();
    int keyX;
    int keyY;
    Project() {
        this.setSize(800, 600);
        this.add(homegames1);
}
    public static void main(String[] args) {
        Project jf = new Project();           //สร้างหน้าต่างเปล่าๆเข้ามา
        jf.setSize(1000, 800);
        jf.setTitle("Piglet evades bombs");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
