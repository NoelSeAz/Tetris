package noel.sebastia.enummanager;

import java.util.Random;
public enum EnumFigure {
    O_SQUARE,
    I_SQUARE,
    L_SQUARE,
    J_SQUARE,
    T_SQUARE,
    Z_SQUARE,
    S_SQUARE;

    private static final Random PRNG = new Random();
    public static EnumFigure getRandomFigure(){
        EnumFigure[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
