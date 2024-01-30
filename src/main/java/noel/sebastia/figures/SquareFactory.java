package noel.sebastia.figures;

import java.util.Random;

import noel.sebastia.enummanager.EnumFigure;
import noel.sebastia.utils.Constants;

public class SquareFactory {
    public static int generateRandom(int min, int max){
        return new Random().nextInt(max-min+1) + min;
    }

    //Creates a random Figure
    public static Figure getRegularFigure(){
        EnumFigure figure = EnumFigure.getRandomFigure();
        switch(figure){
            case O_SQUARE:
                return new OSquare();
            case I_SQUARE:
                return new ISquare();
            case L_SQUARE:
                return new LSquare();
            case J_SQUARE:
                return new JSquare();
            case T_SQUARE:
                return new TSquare();
            case Z_SQUARE:
                return new ZSquare();
            case S_SQUARE:
                return new SSquare();
            default:
                return null;
        }
    }
    //Creates a specific Figure
    public static Figure getRegularFigure(EnumFigure figure){
        switch(figure){
            case O_SQUARE:
                return new OSquare();
            case I_SQUARE:
                return new ISquare();
            case L_SQUARE:
                return new LSquare();
            case J_SQUARE:
                return new JSquare();
            case T_SQUARE:
                return new TSquare();
            case Z_SQUARE:
                return new ZSquare();
            case S_SQUARE:
                return new SSquare();
            default:
                return null;
        }
    }
    public static Figure getViewFigure(EnumFigure figure, int baseX, int baseY, int width, int height) {
        switch (figure) {
            case O_SQUARE:
                return new OSquare(Constants.O_Quare, baseX, baseY, width, height);
            case I_SQUARE:
                return new ISquare(Constants.I_Quare, baseX, baseY, width, height);
            case L_SQUARE:
                return new LSquare(Constants.L_Quare, baseX, baseY, width, height);
            case J_SQUARE:
                return new JSquare(Constants.J_Quare, baseX, baseY, width, height);
            case T_SQUARE:
                return new TSquare(Constants.T_Quare, baseX, baseY, width, height);
            case Z_SQUARE:
                return new ZSquare(Constants.Z_Quare, baseX, baseY, width, height);
            case S_SQUARE:
                return new SSquare(Constants.S_Quare, baseX, baseY, width, height);
        }

        return null;
    }
}
