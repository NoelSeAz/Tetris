package noel.sebastia.utils;

import java.awt.*;

public class Constants {
    public static final int BOARD_X = 500;
    public static final int BOARD_Y = 100;
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 700;
    public static final int COLUMNS = 10;
    public static final int ROWS = 20;
    public static final int SQUARED_WIDTH = BOARD_WIDTH/COLUMNS;
    public static final int SQUARED_HEIGHT = BOARD_HEIGHT/ROWS;
    public static final int WIDTH_OF_VIEW = (int)(Constants.BOARD_WIDTH * 0.3);
    public static final int HEIGHT_OF_VIEW = (int)(Constants.BOARD_WIDTH * 0.1);
    public static final int WIDTH_OF_SQUARE_VIEW = (int)(WIDTH_OF_VIEW * 0.2);
    public static final int HEIGHT_OF_SQUARE_VIEW = (int)(HEIGHT_OF_VIEW * 0.5);
    public static final int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final int FONT_SIZE = (int)(Constants.HEIGHT_OF_VIEW * 0.8);
    public static Font FONT = new Font("TimesRoman", Font.PLAIN, FONT_SIZE);
    public static Color I_Quare = Color.CYAN;
    public static Color S_Quare = Color.GREEN;
    public static Color Z_Quare = Color.RED;
    public static Color J_Quare = Color.BLUE;
    public static Color L_Quare = Color.ORANGE;
    public static Color O_Quare = Color.YELLOW;
    public static Color T_Quare = Color.MAGENTA;
}
