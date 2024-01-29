package noel.sebastia.figures;

import java.awt.Color;
import java.util.LinkedList;

import noel.sebastia.enummanager.EnumFigure;
import noel.sebastia.utils.Constants;

public class ZSquare extends Figure {
    public ZSquare(){
        super(Color.BLACK, EnumFigure.Z_SQUARE);
        this.setSquareLocation(Constants.COLUMNS/3, 0);
    }
    public ZSquare(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY){
        super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.Z_SQUARE);
        this.setSquareLocation(0,0);
    }
    @Override
    public LinkedList<Square> rotateElement(Square[][] board){
        return null;
    }
    @Override
    public void setSquareLocation(int indexI, int indexJ){
        this.addSquare(indexI, indexJ);
        this.addSquare(indexI+1, indexJ);
        this.addSquare(indexI+1, indexJ+1);
        this.addSquare(indexI+2, indexJ+1);
    }
    @Override
    public void setNextPosition(){

    }
}
