package edu.kit.informatik.stunde8;

import edu.kit.informatik.Terminal;

/**
 * @author Li Zeyu
 * @version JDK 1.8
 */
public final class Main {
    /**
     * this provide main method
     */
    private static PlayField pf = null;

    /**
     * to bypass checkstyle
     * @param pf playField
     */
    private Main(PlayField pf) {
        this.pf = pf;
    }

    /**
     * main method
     * @param args args
     */
    public static void main(String[] args) {
        while (true) {
            String input = Terminal.readLine();
            String[] strings = input.split(" ");
            boolean b1 = "start".equals(strings[0]);
            boolean b2 = "select".equals(strings[0]);
            boolean b3 = "place".equals(strings[0]);
            boolean b4 = "bag".equals(strings[0]);
            boolean b5 = "rowprint".equals(strings[0]);
            boolean b6 = "colprint".equals(strings[0]);
            boolean b7 = "quit".equals(strings[0]);
            try {
                if ("start".equals(strings[0])) {
                    pf = SafeInput.start(input);
                }
                if (pf != null) {
                    if ("select".equals(strings[0])) {
                        SafeInput.select(input, pf);
                    }
                    if ("place".equals(strings[0])) {
                        SafeInput.place(input, pf);
                    }
                    if ("bag".equals(strings[0])) {
                        SafeInput.bag(input, pf);
                    }
                    if ("rowprint".equals(strings[0])) {
                        SafeInput.rowPrint(input, pf);
                    }
                    if ("colprint".equals(strings[0])) {
                        SafeInput.colPrint(input, pf);
                    } if (!b1 && !b2 && !b3 && !b4 && !b5 && !b6 && !b7) {
                        Terminal.printError("not a valid order");
                    }
                } else {
                    Terminal.printError("please start first");
                }
                if ("quit".equals(strings[0])) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Terminal.printError("array index out of bound");
            } catch (IllegalArgumentException e) {
                Terminal.printError("this argument is not allowed");
            }
        }
    }
}
