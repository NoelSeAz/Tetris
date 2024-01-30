package noel.sebastia.form;

import java.awt.Graphics;
import java.io.Serial;
import javax.swing.JPanel;

import noel.sebastia.components.TetrisBoard;
public class GameManager extends JPanel{
    @Serial
    private static final long serialVersionUID = 1L;

    TetrisBoard board = new TetrisBoard();
    public GameManager(){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        board.paintElement(g);
    }

    public void repaintGame(){
        if(isGameInPlay()) {
            this.repaint();
        }
    }
    public void moveRight(){
        if(isGameInPlay() && !this.board.isRotating()) {
            this.board.moveRight();
        }
    }
    public void moveLeft(){
        if(isGameInPlay()) {
            this.board.moveLeft();
        }
    }
    public void rotate() {
        if(isGameInPlay()) {
            this.board.rotateFigure();
        }

    }
    public void pauseOrResumeGame() {
        this.board.pauseOrResume();
    }
    public void resetGame(){
        this.board = new TetrisBoard();
    }

    public void tick(){
        if(isGameInPlay()) {
            this.board.tick();
        }
    }
    public boolean isGameInPlay() {
        return !board.isGameOver() && !this.board.isStop();
    }
}
