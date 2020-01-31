package edu.kit.informatik.stunde8;

/**
 * @author Li Zeyu
 * @version JDK 1.8
 */
public class Player {

    /**
     * this class modified player
     */
    private Player other;
    private ChessStone selected;

    /**
     * constructor
     */
    public Player() {
    }

    /**
     * set stone for another person
     * @param selected selected chessStone
     */
    public void setStoneForOther(ChessStone selected) {
        other.setSelected(selected);
    }

    //Getter and Setter

    /**
     * get other player
     * @return other player
     */
    public Player getOther() {
        return other;
    }

    /**
     * set other player
     * @param other other player
     */
    public void setOther(Player other) {
        this.other = other;
    }

    /**
     * get selected ChessStone
     * @return selected ChessStone
     */
    public ChessStone getSelected() {
        return selected;
    }

    /**
     * set selected ChessStone
     * @param selected selected ChessStone
     */
    public void setSelected(ChessStone selected) {
        this.selected = selected;
    }

}
