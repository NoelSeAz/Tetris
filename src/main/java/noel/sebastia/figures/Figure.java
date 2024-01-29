package noel.sebastia.figures;

import java.awt.Color;
import java.util.LinkedList;
import java.awt.Graphics;

import noel.sebastia.enummanager.EnumFigure;
import noel.sebastia.segregation.Drawable;
import noel.sebastia.utils.Constants;
public abstract class Figure implements Drawable{
    //New Figure with Shape
    private LinkedList<Square> squares = new LinkedList<>();
    //Color of the Figure
    private Color color;
    //Dimensions of the Figure
    private int width, height;
    //Private Coordiantes for the Figure
    private int baseX, baseY;
    //Shape Type
    private EnumFigure figureType;

    public Figure() {
    }
    //Constructor for regular figure
    public Figure(Color color, EnumFigure figureType){
        this.color = color;
        this.baseX = Constants.BOARD_X;
        this.baseY = Constants.BOARD_Y;
        this.figureType = figureType;
        //Use the board Location
        this.width = Constants.SQUARED_WIDTH;
        this.height = Constants.SQUARED_HEIGHT;
    }
    //Constructor for figure inside an specific location and size
    public Figure(Color color, int baseX, int baseY, int width, int height, EnumFigure figureType){
        this.color = color;
        this.baseX = baseX;
        this.baseY = baseY;
        this.width = width;
        this.height = height;
        this.figureType = figureType;
    }
    @Override
    public void paintElement(Graphics g){
        g.setColor(this.color);
        for(Square square: this.getSquares()){
            g.fill3DRect(square.getX(), square.getY(), width, height, true);
        }
    }
    public void addSquare(int i, int j){
        this.squares.add(new Square(this.getColor(), this.getWidth(), this.getHeight()).setLocation(i, j , baseX, baseY));
    }
    public void addSquare(Square square){
        squares.add(square);
    }
    public LinkedList<Square> getSquares(){
        return squares;
    }
    public void setSquares(LinkedList<Square> squares){
        this.squares = squares;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public int getWidth(){
        return width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getBaseX(){
        return baseX;
    }
    public void setBaseX(int baseX){
        this.baseX = baseX;
    }
    public int getBaseY(){
        return baseY;
    }
    public void setBaseY(int baseY){
        this.baseY = baseY;
    }
    public EnumFigure getFigureType(){
        return figureType;
    }
    public void setFigureType(EnumFigure figureType){
        this.figureType = figureType;
    }
    public abstract LinkedList<Square> rotateElement(Square[][] board);
    public abstract void setSquareLocation(int indexI, int indexJ);
    public abstract void setNextPosition();
}
