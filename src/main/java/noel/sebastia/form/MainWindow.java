package noel.sebastia.form;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;
import javax.swing.JFrame;
public class MainWindow extends JFrame implements Runnable,KeyListener {
    @Serial
    private static final long serialVersionUID = 1L;
    private GameManager game;
    private boolean decorate=true;
    private final double FPS=21D;
    private final double UPS=60D;
    private final double timeFps=1000000000/FPS;
    private final double timeUps=1000000000/UPS;
    private double deltaFps=0, deltaUps=0;
    private long initialTime = System.nanoTime();
    private boolean typeRight = false, typeLeft = false;
    public MainWindow(){
        this.game = new GameManager();
        this.setUndecorated(decorate);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.getContentPane().add(game);
        this.addKeyListener(this);

        new Thread(this).start();

    }
    @Override
    public void run(){
        while(true){
            long currentTime = System.nanoTime();
            this.deltaFps += (currentTime - this.initialTime)/this.timeFps;
            this.deltaUps += (currentTime - this.initialTime)/this.timeUps;
            this.initialTime = currentTime;
            if(this.deltaUps>=1){
                if(typeLeft){
                    game.moveLeft();
                }
                if(typeRight){
                    game.moveRight();
                }
                this.game.tick();
                this.deltaUps=0;
            }
            if(this.deltaFps>=1){
                this.game.repaintGame();
                this.deltaFps=0;
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            typeLeft = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            typeRight = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            typeLeft = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            typeRight = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.game.rotate();
        }
        if(e.getKeyCode() == KeyEvent.VK_P) {
            this.game.pauseOrResumeGame();
        }
        if(e.getKeyCode() == KeyEvent.VK_R){
            this.game.resetGame();
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            System.exit(0);
        }
    }
}
