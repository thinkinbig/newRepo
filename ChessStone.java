package edu.kit.informatik.stunde8;

import edu.kit.informatik.Terminal;

public enum ChessStone {
    /**
     * This class initialise the basic chessStones in game
     */
    /**
     * variable
     */
    STONE0(0, "schwarz", "eckig", "klein", "hohl", false),
    /**
     * variable
     */
    STONE1(1, "schwarz", "eckig", "klein", "massiv", false),
    /**
     * variable
     */
    STONE2(2, "schwarz", "eckig", "groß", "hohl", false),
    /**
     * variable
     */
    STONE3(3, "schwarz", "eckig", "groß", "massiv", false),
    /**
     * variable
     */
    STONE4(4, "schwarz", "zylinderförmig", "klein", "hohl", false),
    /**
     * variable
     */
    STONE5(5, "schwarz", "zylinderförmig", "klein", "massiv", false),
    /**
     * variable
     */
    Stone6(6, "schwarz", "zylinderförmig", "groß", "hohl",  false),
    /**
     * variable
     */
    Stone7(7, "schwarz", "zylinderförmig", "groß", "massiv", false),
    /**
     * variable
     */
    STONE8(8, "weiß", "eckig", "klein", "hohl", false),
    /**
     * variable
     */
    STONE9(9, "weiß", "eckig", "klein", "massiv", false),
    /**
     * variable
     */
    STONE10(10, "weiß", "eckig", "groß", "hohl", false),
    /**
     * variable
     */
    STONE11(11, "weiß", "eckig", "groß", "massiv", false),
    /**
     * variable
     */
    STONE12(12, "weiß", "zylinderförmig", "klein", "hohl", false),
    /**
     * variable
     */
    STONE13(13, "weiß", "zylinderförmig", "klein", "massiv", false),
    /**
     * variable
     */
    STONE14(14, "weiß", "zylinderförmig", "groß", "hohl", false),
    /**
     * variable
     */
    STONE15(15, "weiß", "zylinderförmig", "groß", "massiv", false);

    private int id;
    private String color;
    private String form1;
    private String form2;
    private String form3;
    private boolean isSelected;
    /**
     * constructor
     * @param id identifier
     * @param color black or white
     * @param form1 sharp or cylinder
     * @param form2 small or big
     * @param form3 massive or hollow
     * @param isSelected used or not
     */
    private ChessStone(int id, String color, String form1, String form2, String form3, boolean isSelected) {
        this.id = id;
        this.color = color;
        this.form1 = form1;
        this.form2 = form2;
        this.form3 = form3;
    }

    //getter

    /**
     * get stone
     * @param id identifier
     * @return stone
     */
    public static ChessStone getStoneById(int id) {
        for (ChessStone cs : ChessStone.values()) {
            if (cs.getId() ==  id) {
                return cs;
            }
        }
        if (id < 0 || id > 15) {
            Terminal.printError("this ID is not acceptable, please try again");
        }
        return null;
    }

    //Getter and Setter

    /**
     * get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * get color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * get form1
     * @return form1
     */
    public String getForm1() {
        return form1;
    }

    /**
     * get form2
     * @return form2
     */
    public String getForm2() {
        return form2;
    }

    /**
     * get form2
     * @return form3
     */
    public String getForm3() {
        return form3;
    }

    /**
     * get selected
     * @return if selected
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * set selected
     * @param selected set true
     */
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}

