package noel.sebastia.figures;

import java.awt.Color;
import java.util.LinkedList;

import noel.sebastia.enummanager.EnumFigure;
import noel.sebastia.utils.Constants;

public class JSquare extends Figure {
    public JSquare(){
        super(Color.BLACK, EnumFigure.J_SQUARE);
        this.setSquareLocation(Constants.COLUMNS/3, 0);
    }
    public JSquare(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY){
        super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.J_SQUARE);
        this.setSquareLocation(0,0);
    }
    @Override
    public LinkedList<Square> rotateElement(Square[][] board){
        return null;
    }
    @Override
    public void setSquareLocation(int indexI, int indexJ){
        this.addSquare(indexI, indexJ);
        for(int i=0; i<3; i++){
            this.addSquare(indexI++, indexJ+1);
        }
    }
    @Override
    public void setNextPosition(){

    }
}
