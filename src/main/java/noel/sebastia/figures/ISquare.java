package noel.sebastia.figures;

import java.awt.Color;
import java.util.LinkedList;

import noel.sebastia.enummanager.EnumFigure;
import noel.sebastia.utils.Constants;

public class ISquare extends Figure {
    public ISquare(){
        super(Color.BLACK, EnumFigure.I_SQUARE);
        this.setSquareLocation(Constants.COLUMNS/3, 0);
    }
    public ISquare(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY){
        super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.I_SQUARE);
        this.setSquareLocation(0,0);
    }
    @Override
    public LinkedList<Square> rotateElement(Square[][] board){
        return null;
    }
    @Override
    public void setSquareLocation(int indexI, int indexJ){
        int i = 0;
        while(i < 4){
            this.addSquare(indexI++, indexJ);
            i++;
        }
    }
    @Override
    public void setNextPosition(){

    }
}
