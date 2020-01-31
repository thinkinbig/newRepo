package edu.kit.informatik.stunde8;

/**
 * @author Li Zeyu
 * @version JDK 1.8
 */
public class StandardPlayField extends PlayField {
    /**
     * this class is a standard playField just like playField
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

    //constructor

    /**
     * standard constructor
     * @param row row number
     * @param col column number
     */
    public StandardPlayField(int row, int col) {
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
     * default constructor
     * for extension and further use
     */
    public StandardPlayField() {
    }

    /**
     * this method judge if win in row
     * @return win or not
     */
    @Override
    public boolean winRow() {
        int sgn = 2;
        return winRow(sgn);
    }
    /**
     * this method is set to avoid ArrayIndexOutOfBound,
     * @param sgn the signature of the playField
     * @return win or not
     */
    public boolean winRow(int sgn) {
        ChessStone s1 = null;
        ChessStone s2 = null;
        ChessStone s3 = null;
        ChessStone s4 = null;
        for (int i = 0; i <= sgn; i++) {
            s1 = getStones()[getCurrentX()][i];
            s2 = getStones()[getCurrentX()][i + 1];
            s3 = getStones()[getCurrentX()][i + 2];
            s4 = getStones()[getCurrentX()][i + 3];
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
                if (b) { return true; }
            }
        }
        return false;
    }
    /**
     * this method judge if win in column
     * @return win or not
     */
    @Override
    public boolean winCol() {
        int sgn = 2;
        return winCol(sgn);
    }
    /**
     * this method is set to avoid ArrayIndexOutOfBound,
     * @param sgn the  signature of the playField
     * @return win or not
     */
    public boolean winCol(int sgn) {
        ChessStone s1 = null;
        ChessStone s2 = null;
        ChessStone s3 = null;
        ChessStone s4 = null;
        for (int i = 0; i <= sgn; i++) {
            s1 = getStones()[i][getCurrentY()];
            s2 = getStones()[i + 1][getCurrentY()];
            s3 = getStones()[i + 2][getCurrentY()];
            s4 = getStones()[i + 3][getCurrentY()];
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
                if (b) { return true; }
            }
        }
        return false;
    }
    /**
     * this method judge if win in left diagonal
     * @return win or not
     */
    @Override
    public boolean winLeftDia() {
        int x = getCurrentX();
        int y = getCurrentY();
        int i = (x + y <= 5) ? x + y : x + y - 5;
        int sgn1 =  i - 3;
        int sgn2 =  i;
        int sgn3 =  2;
        return winLeftDia(sgn1, sgn2, sgn3);
    }
    /**
     * this method is set to avoid ArrayIndexOutOfBound,
     * @param sgn1 the signature of the playField
     * @param sgn2 the signature of the playField
     * @param sgn3 the signature of the playField
     * @return win or not
     */
    public boolean winLeftDia(int sgn1, int sgn2, int sgn3) {
        int x = getCurrentX();
        int y = getCurrentY();
        int i = (x + y <= 5) ? x + y : x + y - 5;
        if (x + y <= 5) {
            for (int k = 0; k <= sgn1; k++) {
                ChessStone s1 = getStones()[k][i - k];
                ChessStone s2 = getStones()[k + 1][i - k - 1];
                ChessStone s3 = getStones()[k + 2][i - k - 2];
                ChessStone s4 = getStones()[k + 3][i - k - 3];
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
                    if (b) { return true; }
                }
            }
        } else {
            for (int k = sgn2; k <= sgn3; k++) {
                ChessStone s1 = getStones()[k][i + 5 - k];
                ChessStone s2 = getStones()[k + 1][i + 5 - k - 1];
                ChessStone s3 = getStones()[k + 2][i + 5 - k - 2];
                ChessStone s4 = getStones()[k + 3][i + 5 - k - 3];
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
                    if (b) { return true; }
                }
            }
        }
        return false;
    }
    /**
     * this method judge if win in right diagonal
     * @return win or not
     */
    @Override
    public boolean winRightDia() {
        int x = getCurrentX();
        int y = getCurrentY();
        int i = (x - y <= 0) ? y - x : x - y;
        int sgn1 =  2 - i;
        int sgn2 =  i;
        int sgn3 =  2;
        return winRightDia(sgn1, sgn2, sgn3);
    }
    /**
     * this method is set to avoid ArrayIndexOutOfBound,
     * @param sgn1 the signature of the playField
     * @param sgn2 the signature of the playField
     * @param sgn3 the signature of the playField
     * @return win or not
     */
    public boolean winRightDia(int sgn1, int sgn2, int sgn3) {
        int x = getCurrentX();
        int y = getCurrentY();
        int i = (x - y <= 0) ? y - x : x - y;
        if (x <= y) {
            for (int k = 0; k <= sgn1; k++) {
                ChessStone s1 = getStones()[k][i + k];
                ChessStone s2 = getStones()[k + 1][i + k + 1];
                ChessStone s3 = getStones()[k + 2][i + k + 2];
                ChessStone s4 = getStones()[k + 3][i + k + 3];
                if (s1 == null || s2 == null || s3 == null || s4 == null) { continue; }
                else {
                    boolean b1 = s1.getColor().equals(s2.getColor()) && s1.getColor().equals(s3.getColor())
                            && s1.getColor().equals(s4.getColor());
                    boolean b2 = s1.getForm1().equals(s2.getForm1()) && s1.getForm1().equals(s3.getForm1())
                            && s1.getForm1().equals(s4.getForm1());
                    boolean b3 = s1.getForm2().equals(s2.getForm2()) && s1.getForm2().equals(s3.getForm2())
                            && s1.getForm2().equals(s4.getForm2());
                    boolean b4 = s1.getForm3().equals(s2.getForm3()) && s1.getForm3().equals(s3.getForm3())
                            && s1.getForm3().equals(s4.getForm3());
                    boolean b = b1 || b2 || b3 || b4;
                    if (b) { return true; }
                }
            }
        } else {
            for (int k = sgn2; k <= sgn3; k++) {
                ChessStone s1 = getStones()[k][k - i];
                ChessStone s2 = getStones()[k + 1][k - i + 1];
                ChessStone s3 = getStones()[k + 2][k - i + 2];
                ChessStone s4 = getStones()[k + 3][k - i + 3];
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
                    if (b) { return true; }
                }
            }
        }
        return false;
    }
    /**
     * reset cell in X coordinate
     * @param x x coordinate
     * @return x coordinate
     */
    @Override
    public int resetXPos(int x) {
        return pf.resetXPos(x);
    }
    /**
     * reset cell in Y coordinate
     * @param y y coordinate
     * @return y coordinate
     */
    @Override
    public int resetYPos(int y) {
        return pf.resetYPos(y);
    }
    //Getter and Setter

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
     * set currentX
     * @param currentX x position
     */
    @Override
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
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
     * set currentY
     * @param currentY currentY
     */
    @Override
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
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
}
