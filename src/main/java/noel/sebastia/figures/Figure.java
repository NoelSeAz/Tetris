package noel.sebastia.figures;

import java.awt.Color;
import java.util.LinkedList;

import noel.sebastia.enummanager.EnumFigure;
import noel.sebastia.utils.Constants;
public abstract class Figure {
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
    public void addSquare(Square square){
        squares.add(square);
    }
    public LinkedList<Square> getSquares(){
        return squares;
    }
    public abstract LinkedList<Square> rotateElement(Square[][] board);
    public abstract void setSquareLocation(int indexI, int indexJ);
    public abstract void setNextPosition();
}
