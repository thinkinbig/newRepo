package edu.kit.informatik.stunde8;

import edu.kit.informatik.Terminal;

/**
 * @author Li Zeyu
 * @version JDK 1.8, 2020,01,29
 */
public class PlayField {
    /**
     * This class draw a basic outline of a playField, to ensure it can independently work,
     * it was made in accord with a standardPlayField
     */
    private static int round = 0;
    private static int selectedCount = 0;
    private Player player1;
    private Player player2;
    private ChessStone[][] stones;
    private int currentX;
    private int currentY;
    private int row;
    private int col;
    private boolean flag;
    private Player currentPlayer;
    /**
     * This constructor is make to ensure the future extensions
     */
    //default constructor
    public PlayField() { };
    /**
     * This is a standard constructor to be invoked, it set the default values of this class
     * @param row the row of this playField
     * @param col the column of this playField
     */
    //constructor
    public PlayField(int row, int col) {
        this.row = row;
        this.col = col;
        stones = new ChessStone[row][col];
        player1 = new Player();
        player2 = new Player();
        player1.setOther(player2);
        player2.setOther(player1);
        this.flag = false;
        this.currentPlayer = getPlayer1();
    }
    /**
     * This method allow players to select a chess
     * @param id the identifier of chess
     */
    public void select(int id) {
        if (!isFlag()) {
            if (selectedCount == 0) {
                if (ChessStone.getStoneById(id).isSelected() == false) {
                    if (round % 2 == 0) {
                        currentPlayer = getPlayer1();
                    }
                    if (round % 2 == 1) {
                        currentPlayer = getPlayer2();
                    }
                    currentPlayer.getOther().setSelected(ChessStone.getStoneById(id));
                    ChessStone.getStoneById(id).setSelected(true);
                    Terminal.printLine("OK");
                    selectedCount++;
                } else {
                    Terminal.printError("the stone is already selected");
                    return;
                }
            } else {
                Terminal.printError("please don't select twice, try to place");
                return;
            }
        }  else {
            Terminal.printError("the match is over");
            return;
        }
    }
    /**
     * This method allow players to place chess on the playField
     * @param x the x coordinator of the designated position
     * @param y the y coordinator of the designated position
     * @throws IllegalArgumentException judge if the argument is validate
     */
    public void place(int x, int y) throws IllegalArgumentException {
        boolean draw = true;
        for (int i = 0; i < 16; i++) {
            draw = draw && ChessStone.getStoneById(i).isSelected();
        }
        if (!isFlag()) {
            if (round % 2 == 0) {
                currentPlayer = getPlayer2();
            }
            if (round % 2 == 1) {
                currentPlayer = getPlayer1();
            }
            ChessStone selected = currentPlayer.getSelected();
            if (selected == null) {
                Terminal.printError("please select a stone first");
                return;
            }
            if (x >= 0 && x < getRow() && y >= 0 && y < getCol() && getStones()[x][y] == null) {
                setStones(x, y, selected);
                setCurrentX(x);
                setCurrentY(y);
            } else {
                Terminal.printError("the position is used");
                return;
            }
            selectedCount--;
            if (winRow() || winCol() || winLeftDia() || winRightDia()) {
                if (getPlayer2().equals(currentPlayer)) {
                    Terminal.printLine("P2 wins");
                    Terminal.printLine(round);
                    setFlag(true);
                }
                if (getPlayer1().equals(currentPlayer)) {
                    Terminal.printLine("P1 wins");
                    Terminal.printLine(round);
                    setFlag(true);
                }
            } else if (draw) {
                Terminal.printLine("draw");
            } else {
                Terminal.printLine("OK");
                round++;
            }
        } else {
            Terminal.printError("the match is over");
            return;
        }
    }
    /**
     * this method iterates the chess not yet be chosen
     */
    public void bag() {
        String result = "";
        for (int i = 0; i < 16; i++) {
            ChessStone cs = ChessStone.getStoneById(i);
            if (cs.isSelected() != true) {
                result = result + cs.getId() + " ";
            }
        }
        result = result.trim();
        Terminal.printLine(result);
    }
    /**
     * This method print all chess be placed in a specific row
     * @param x the x coordinate of this row
     * @throws IllegalArgumentException the row number must within 0~row
     */
    public void rowPrint(int x) throws IllegalArgumentException {
        String result = "";
        if (x < 0 || x >= 6) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < 6; i++) {
                if (getStones()[x][i] == null) {
                    result += "# ";
                } else {
                    result += getStones()[x][i].getId() + " ";
                }
            }
            Terminal.printLine(result);
        }
    }
    /**
     * This method print out all chess on a specific column
     * @param y the y coordinate of this column
     * @throws IllegalArgumentException must be a valid value
     */
    public void colPrint(int y) throws IllegalArgumentException {
        String result = "";
        if (y < 0 || y >= 6) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < 6; i++) {
                if (getStones()[i][y] == null) {
                    result += "# ";
                } else {
                    result += getStones()[i][y].getId() + " ";
                }
            }
            Terminal.printLine(result);
        }
    }
    /**
     * this method judge if win in row
     * @return win or not
     */
    public boolean winRow() {
        return false;
    }
    /**
     * judge if win in column
     * @return win or not
     */
    public boolean winCol() {
        return false;
    }
    /**
     * This judge if  win in left diagonal
     * @return win or not
     */
    public boolean winLeftDia() {
        return false;
    }
    /**
     * this judge if win in right diagonal
     * @return win or not
     */
    public boolean winRightDia() {
        return false;
    }
    //Getter and Setter
    /**
     * get stones
     * @return stones
     */
    public ChessStone[][] getStones() {
        return stones;
    }
    /**
     * set stones in specific position
     * @param x x coordinate of position
     * @param y y coordinate of position
     * @param cs the ChessStone to be set
     * @throws ArrayIndexOutOfBoundsException must within the playField
     */
    public void setStones(int x, int y, ChessStone cs) throws ArrayIndexOutOfBoundsException {
        if (x < getRow() && x >= 0 && y < getCol() && y >= 0) {
            getStones()[x][y] = cs;
        } else { throw new ArrayIndexOutOfBoundsException(); }
    }
    /**
     * get player1
     * @return player1
     */
    public Player getPlayer1() {
        return player1;
    }
    /**
     * get player2
     * @return player2
     */
    public Player getPlayer2() {
        return player2;
    }
    /**
     * get round
     * @return round
     */
    public static int getRound() {
        return round;
    }

    /**
     * get currentX
     * @return currentX
     */
    public int getCurrentX() {
        return currentX;
    }
    /**
     * set currentX
     * @param currentX x position
     */
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }
    /**
     * get currentY
     * @return currentY
     */
    public int getCurrentY() {
        return currentY;
    }
    /**
     * set currentY
     * @param currentY currentY
     */
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
    /**
     * get row
     * @return row
     */
    public int getRow() {
        return row;
    }
    /**
     * get col
     * @return col
     */
    public int getCol() {
        return col;
    }
    /**
     * get flag
     * @return flag
     */
    public boolean isFlag() {
        return flag;
    }
    /**
     * set new flag
     * @param flag if one player is win
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    /**
     * arrange for extension
     * @param x x coordinate
     * @return reset x
     * @throws IllegalArgumentException x must within 0~row
     */
    public int resetXPos(int x) throws IllegalArgumentException {
        if (x < 0 || x >= getRow()) { throw new IllegalArgumentException(); }
        return x;
    }
    /**
     * arrange for extension
     * @param y y coordinate
     * @return reset y
     * @throws IllegalArgumentException y must within 0~col
     */
    public int resetYPos(int y) throws IllegalArgumentException {
        if (y < 0 || y >= getCol()) { throw new IllegalArgumentException(); }
        return y;
    }
}