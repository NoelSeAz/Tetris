package noel.sebastia.form;

import java.awt.Toolkit;
import java.io.Serial;
import javax.swing.JFrame;
public class MainWindow extends JFrame implements Runnable {
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
    public MainWindow(){
        this.game = new GameManager();
        this.setUndecorated(decorate);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.getContentPane().add(game);

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
                this.game.tick();
                this.deltaUps=0;
            }
            if(this.deltaFps>=1){
                this.game.repaintGame();
                this.deltaFps=0;
            }
        }
    }
}
