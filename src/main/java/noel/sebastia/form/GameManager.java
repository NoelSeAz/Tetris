package noel.sebastia.form;

import java.awt.Graphics;
import java.io.Serial;
import javax.swing.JPanel;
public class GameManager extends JPanel{
    @Serial
    private static final long serialVersionUID = 1L;

    public GameManager(){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillOval(300,300,100,100);
    }

    public void repaintGame(){
        this.repaint();
    }

    public void tick(){

    }
}
