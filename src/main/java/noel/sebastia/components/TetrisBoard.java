package noel.sebastia.components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import noel.sebastia.figures.Figure;
import noel.sebastia.figures.Square;
import noel.sebastia.figures.SquareFactory;
import noel.sebastia.segregation.Drawable;
import noel.sebastia.utils.Constants;
import noel.sebastia.enummanager.EnumFigure;

public class TetrisBoard implements Drawable{
    private Square[][] board = new Square[Constants.COLUMNS][Constants.ROWS];
    private ViewFigure nextView;
    private Figure currentFigure, nextFigure;
    private int baseX, baseY;
    private int panelX, panelY, panelSpace;
    private int gameSpeed = 180;
    private boolean isGameOver = false, isRotating = false, stop = false;
    private int points = 0;
    public TetrisBoard(){
        this.baseX = Constants.BOARD_X;
        this.baseY = Constants.BOARD_Y;
        this.panelX = Constants.X_LEFT_PANEL;
        this.panelY = Constants.Y_LEFT_PANEL;
        this.panelSpace = Constants.SPACE_BTW_PANELS;
        this.nextView = new ViewFigure(panelX, panelY + 100);
        this.addNewFigure();
    }
    public void addNewFigure(){
        if(this.nextFigure != null){
            this.currentFigure = this.nextFigure;
            this.nextFigure = SquareFactory.getRegularFigure();
        } else {
            this.currentFigure = SquareFactory.getRegularFigure();
            this.nextFigure = SquareFactory.getRegularFigure();
        }
        this.nextView.setFigure(SquareFactory.getViewFigure(nextFigure.getFigureType(), nextView.getX(), nextView.getY(), Constants.WIDTH_OF_SQUARE_VIEW, Constants.HEIGHT_OF_SQUARE_VIEW));
        this.validateCurrentLocation();
    }
    private void validateCurrentLocation() {
        for(Square square: this.currentFigure.getSquares()) {
            if(this.board[square.getIndexI()][square.getIndexJ()] != null) {
                System.out.println("GAME OVER!!");
                this.isGameOver = true;
                break;
            }
        }
    }
    private void moveImageDown(){
        if(this.currentFigure == null || this.isGameOver){
            return;
        }
        boolean merge = false;
        for(Square square: this.currentFigure.getSquares()){
            if(square.getIndexJ() >= Constants.ROWS - 1){
                merge = true;
                break;
            } else if(this.board[square.getIndexI()][square.getIndexJ() + 1] != null){
                merge = true;
                break;
            }
        }
        if(!merge){
            for (Square square: this.currentFigure.getSquares()){
                square.setLocation(square.getIndexI(), square.getIndexJ() + 1, this.baseX, this.baseY);
            }
        } else {
            for(Square square: this.currentFigure.getSquares()){
                this.board[square.getIndexI()][square.getIndexJ()] = square;
            }
            this.searchLines();
            this.addNewFigure();
        }
    }
    private void searchLines() {
        int countLines = 0;
        for (int j=Constants.ROWS - 1; j>0; j--) {
            for (int i=0; i<Constants.COLUMNS; i++) {
                if(this.board[i][j] == null) {
                    break;
                }
                countLines++;
            }
            if(countLines == Constants.COLUMNS) {
                this.deleteLine(j);
                this.points += Constants.COLUMNS;
                // Since a line was deleted, then start in the same line
                j++;
            }
            countLines = 0;
        }
    }
    private void deleteLine(int j) {
        for(int i=0; i<Constants.COLUMNS; i++) {
            this.board[i][j] = null;
        }
        for (;j>1; j--) {
            for (int i = 0; i < Constants.COLUMNS; i++) {
                if(this.board[i][j-1] != null) {
                    this.board[i][j] = this.board[i][j-1];
                    this.board[i][j-1] = null;
                    this.board[i][j].setLocation(i, j, this.baseX, this.baseY);
                }
            }
        }
    }
    public void moveRight(){
        if(this.currentFigure == null){
            return;
        }
        for(Square square: this.currentFigure.getSquares()){
            if(square.getIndexI() + 1 >= Constants.COLUMNS){
                return;
            }else if(this.board[square.getIndexI() + 1][square.getIndexJ()] != null){
                return;
            }
        }
        for(Square square: this.currentFigure.getSquares()){
            square.setLocation(square.getIndexI() + 1, square.getIndexJ(), this.baseX, this.baseY);
        }
    }
    public void moveLeft(){
        if(this.currentFigure == null){
            return;
        }
        for(Square square: this.currentFigure.getSquares()){
            if(square.getIndexI() - 1 < 0){
                return;
            }else if(this.board[square.getIndexI() - 1][square.getIndexJ()] != null){
                return;
            }
        }
        for(Square square: this.currentFigure.getSquares()){
            square.setLocation(square.getIndexI() - 1, square.getIndexJ(), this.baseX, this.baseY);
        }
    }

    public void setIsRotating(boolean isRotating){
        this.isRotating = isRotating;
    }
    public boolean isRotating(){
        return this.isRotating;
    }
    public void rotateFigure() {
        if(this.currentFigure.getFigureType() == EnumFigure.O_SQUARE) {
            // Do not rotate in case is already rotating
            return;
        }
        this.isRotating = true;
        LinkedList<Square> squares = currentFigure.rotateElement(this.board);
        // Validate if the squares are outside the area
        int top=0, right=0, left=0, down=0, current=0;
        for (Square square: squares) {
            if(square.getIndexI() < 0) {
                current = square.getIndexI() * - 1;
                left = left < current? current: left;
            }
            if(square.getIndexI() > Constants.COLUMNS - 1) {
                current = square.getIndexI() - (Constants.COLUMNS - 1);
                right = right < current? current: right;
            }
            if(square.getIndexJ() < 0) {
                current = square.getIndexJ() * - 1;
                top = top < current? current: top;
            }
            if(square.getIndexJ() > Constants.ROWS - 1) {
                current = square.getIndexJ() - (Constants.ROWS - 1);
                down = down < current? current: down;
            }
        }
        // Increment or decrement depending on the distance outside for every side of the table
        for (Square square : squares) {
            if(top > 0) {
                square.setIndexJ(square.getIndexJ() + top);
            }
            if(down > 0) {
                square.setIndexJ(square.getIndexJ() - down);
            }
            if(left > 0) {
                square.setIndexI(square.getIndexI() + left);
            }
            if(right > 0) {
                square.setIndexI(square.getIndexI() - right);
            }
            square.setLocation(this.baseX, this.baseY);
        }
        // If any of the squares is located inside a place that is not null, can´t be rotated
        for (Square square: squares) {
            if(this.board[square.getIndexI()][square.getIndexJ()] != null) {
                this.isRotating = false;
                return;
            }
        }
        this.currentFigure.setSquares(squares);
        this.currentFigure.setNextPosition(); // Only enable rotation when everything is ok
        this.isRotating = false;
    }
    public void tick(){
        if(!isGameOver) {
            if(!isRotating) {
                moveImageDown();
            }
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException e) {
            }
        }
    }
    @Override
    public void paintElement(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_WIDTH);
        this.nextView.paintElement(g);
        g.setColor(Color.black);
        g.fill3DRect(this.baseX, this.baseY, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT, false);
        for (int i=0; i<Constants.COLUMNS; i++){
            for (int j=0; j<Constants.ROWS; j++){
                if (this.board[i][j] != null){
                    Square square = this.board[i][j];
                    g.setColor(square.getColor());
                    g.fill3DRect(square.getX(), square.getY(), Constants.SQUARED_WIDTH, Constants.SQUARED_HEIGHT, true);
                }
            }
        }
        this.currentFigure.paintElement(g);
        g.setColor(Color.BLACK);

        g.setFont(Constants.FONT);
        g.drawString("Points: ", panelX-40, panelY-20);
        String formattedPoints = String.format("%06d", this.points);
        g.drawString(formattedPoints, panelX-45, panelY+50);
        g.setColor(Color.white);
    }
    public void pauseOrResume() {
        this.stop = !this.stop;
    }

    public boolean isStop() {
        return this.stop;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
