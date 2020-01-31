package edu.kit.informatik.stunde8;

import edu.kit.informatik.stunde8.ChessStone;
import edu.kit.informatik.stunde8.PlayField;
import edu.kit.informatik.stunde8.Player;

/**
 * @author Li Zeyu
 * @version JDK 1.8
 */
public class TorusPlayField extends PlayField {
    /**
     * this class is a torus playField, which has more ways to win
     */
    //composition
    private static int round = 1;
    private static int selectedCount = 0;
    private PlayField pf;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private ChessStone[][] stones;
    private int currentX;
    private int currentY;
    private int row;
    private int col;
    private boolean flag;

    /**
     * standard constructor
     * @param row row number
     * @param col col number
     */
    //constructor
    public TorusPlayField(int row, int col) {
        pf = new PlayField(row, col);
        this.row = row;
        this.col = col;
        this.player1 = pf.getPlayer1();
        this.player2 = pf.getPlayer2();
        this.round =  pf.getRound();
        this.stones = pf.getStones();
        this.currentX = pf.getCurrentX();
        this.currentY  = pf.getCurrentY();
        this.flag = false;
        this.currentPlayer = getPlayer1();
    }

    /**
     * default constructor for further extension
     */
    //default
    public TorusPlayField() {
    }

    /**
     * this method override win in row, the chess is judged win in row even if they are not adjacent
     * @return win or not
     */
    @Override
    public boolean winRow() {
        for (int i = 0; i < 6; i++) {
            int x1 = resetXPos(getCurrentX());
            ChessStone s1 = getStones()[x1][resetYPos(i)];
            ChessStone s2 = getStones()[x1][resetYPos(i + 1)];
            ChessStone s3 = getStones()[x1][resetYPos(i + 2)];
            ChessStone s4 = getStones()[x1][resetYPos(i + 3)];
            if (s1 == null || s2 == null || s3 == null || s4 == null) {
                continue;
            } else {
                boolean b1 = s1.getColor().equals(s2.getColor()) && s1.getColor().equals(s3.getColor())
                        && s1.getColor().equals(s4.getColor());
                boolean b2 = s1.getForm1().equals(s2.getForm1()) && s1.getForm1().equals(s3.getForm1())
                        && s1.getForm1().equals(s4.getForm1());
                boolean b3 = s1.getForm2().equals(s2.getForm2()) && s1.getForm2().equals(s3.getForm2())
                        && s1.getForm2().equals(s4.getForm2());
                boolean b4 = s1.getForm3().equals(s2.getForm3()) && s1.getForm3().equals(s3.getForm3())
                        && s1.getForm3().equals(s4.getForm3());
                boolean b = b1 || b2 || b3 || b4;
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * this method override win in column, the chess is judged win in column even if they are not adjacent
     * @return win or not
     */
    @Override
    public boolean winCol() {
        for (int i = 0; i < 6; i++) {
            int y1 = resetYPos(getCurrentY());
            ChessStone s1 = getStones()[resetXPos(i)][y1];
            ChessStone s2 = getStones()[resetXPos(i + 1)][y1];
            ChessStone s3 = getStones()[resetXPos(i + 2)][y1];
            ChessStone s4 = getStones()[resetXPos(i + 3)][y1];
            if (s1 == null || s2 == null || s3 == null || s4 == null) {
                continue;
            } else {
                boolean b1 = s1.getColor().equals(s2.getColor()) && s1.getColor().equals(s3.getColor())
                        && s1.getColor().equals(s4.getColor());
                boolean b2 = s1.getForm1().equals(s2.getForm1()) && s1.getForm1().equals(s3.getForm1())
                        && s1.getForm1().equals(s4.getForm1());
                boolean b3 = s1.getForm2().equals(s2.getForm2()) && s1.getForm2().equals(s3.getForm2())
                        && s1.getForm2().equals(s4.getForm2());
                boolean b4 = s1.getForm3().equals(s2.getForm3()) && s1.getForm3().equals(s3.getForm3())
                        && s1.getForm3().equals(s4.getForm3());
                boolean b = b1 || b2 || b3 || b4;
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * this method override win in left diagonal, the chess is judged win in diagonal even if they are not adjacent
     * @return win or not
     */
    @Override
    public boolean winLeftDia() {
        int x = getCurrentX();
        int y = getCurrentY();
        for (int i = 0; i < 6; i++) {
            ChessStone s1 = getStones()[resetXPos(x + i)][resetYPos(y - i)];
            ChessStone s2 = getStones()[resetXPos(x + i + 1)][resetYPos(y - i - 1)];
            ChessStone s3 = getStones()[resetXPos(x + i + 2)][resetYPos(y - i - 2)];
            ChessStone s4 = getStones()[resetXPos(x + i + 3)][resetYPos(y - i - 3)];
            if (s1 == null || s2 == null || s3 == null || s4 == null) {
                continue;
            } else {
                boolean b1 = s1.getColor().equals(s2.getColor()) && s1.getColor().equals(s3.getColor())
                        && s1.getColor().equals(s4.getColor());
                boolean b2 = s1.getForm1().equals(s2.getForm1()) && s1.getForm1().equals(s3.getForm1())
                        && s1.getForm1().equals(s4.getForm1());
                boolean b3 = s1.getForm2().equals(s2.getForm2()) && s1.getForm2().equals(s3.getForm2())
                        && s1.getForm2().equals(s4.getForm2());
                boolean b4 = s1.getForm3().equals(s2.getForm3()) && s1.getForm3().equals(s3.getForm3())
                        && s1.getForm3().equals(s4.getForm3());
                boolean b = b1 || b2 || b3 || b4;
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * this method override win in right diagonal, the chess is judged win in diagonal even if they are not adjacent
     * @return win or not
     */
    @Override
    public boolean winRightDia() {
        int x = getCurrentX();
        int y = getCurrentY();
        for (int i = 0; i < 6; i++) {
            ChessStone s1 = getStones()[resetXPos(x + i)][resetYPos(y + i)];
            ChessStone s2 = getStones()[resetXPos(x + i + 1)][resetYPos(y + i + 1)];
            ChessStone s3 = getStones()[resetXPos(x + i + 2)][resetYPos(y + i + 2)];
            ChessStone s4 = getStones()[resetXPos(x + i + 3)][resetYPos(y + i + 3)];
            if (s1 == null || s2 == null || s3 == null || s4 == null) {
                continue;
            } else {
                boolean b1 = s1.getColor().equals(s2.getColor()) && s1.getColor().equals(s3.getColor())
                        && s1.getColor().equals(s4.getColor());
                boolean b2 = s1.getForm1().equals(s2.getForm1()) && s1.getForm1().equals(s3.getForm1())
                        && s1.getForm1().equals(s4.getForm1());
                boolean b3 = s1.getForm2().equals(s2.getForm2()) && s1.getForm2().equals(s3.getForm2())
                        && s1.getForm2().equals(s4.getForm2());
                boolean b4 = s1.getForm3().equals(s2.getForm3()) && s1.getForm3().equals(s3.getForm3())
                        && s1.getForm3().equals(s4.getForm3());
                boolean b = b1 || b2 || b3 || b4;
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * the method reset the value of x when it is negative or bigger as row number
     * @param x x coordinate
     * @return x in 0 ~ row
     */
    @Override
    public int resetXPos(int x) {
        if (x >= getRow()) {
            return x % 6;
        }
        if (x < 0) {
            return ((x % 6) + 6) % 6;
        }
        return x;
    }
    /**
     * the method reset the value of y when it is negative or bigger as volumn number
     * @param y y coordinate
     * @return y in 0 ~ col
     */
    @Override
    public int resetYPos(int y) {
        if (y >= getCol()) {
            return y % 6;
        }
        if (y < 0) {
            return ((y % 6) + 6) % 6;
        }
        return y;
    }

    /**
     * get player1
     * @return player1
     */
    @Override
    public Player getPlayer1() {
        return player1;
    }

    /**
     * get player2
     * @return player2
     */
    @Override
    public Player getPlayer2() {
        return player2;
    }

    /**
     * get stones
     * @return stones
     */
    @Override
    public ChessStone[][] getStones() {
        return stones;
    }

    /**
     * get currentX
     * @return currentX
     */
    @Override
    public int getCurrentX() {
        return currentX;
    }

    /**
     * get currentY
     * @return currentY
     */
    @Override
    public int getCurrentY() {
        return currentY;
    }

    /**
     * get row
     * @return row
     */
    @Override
    public int getRow() {
        return row;
    }
    /**
     * get column
     * @return column
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * get flag
     * @return flag
     */
    @Override
    public boolean isFlag() {
        return flag;
    }

    /**
     * set flag
     * @param flag if one player is win
     */
    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * set currentX
     * @param currentX x position
     */
    @Override
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    /**
     * set currentY
     * @param currentY currentY
     */
    @Override
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
}
