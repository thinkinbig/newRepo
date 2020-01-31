package edu.kit.informatik.stunde8;

import edu.kit.informatik.Terminal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Li Zeyu
 * @version JDK 1.8
 *
 */
public final class SafeInput {
    /**
     * This class is a utility class that handle with regular expressions to ensure the safe input
     */

    /**
     * constructor no use
     */
    private SafeInput() {
    }

    /**
     * handle with start
     * @param input input string
     * @return the mode of playField, if not accepted return null
     */
    public static PlayField start(String input) {
        final String regex = "start (standard|torus)";
        final String string = input;
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            String mode = matcher.group(1);
            if ("torus".equals(mode)) {
                Terminal.printLine("OK");
                return new TorusPlayField(6, 6);
            } if ("standard".equals(mode)) {
                Terminal.printLine("OK");
                return new StandardPlayField(6, 6);
            }
        } else {
            Terminal.printError("not a valid start input");
        }

        return null;
    }

    /**
     * handle select
     * @param input input string
     * @param pf playField
     */
    public static void select(String input, PlayField pf) {
        final String regex = "^select ([0-9]|1[0-5])$";
        final String string = input;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            String catcher = matcher.group(1);
            int id = Integer.parseInt(catcher);
            pf.select(id);
        } else {
            Terminal.printError("not a valid select number, try again");
        }
    }

    /**
     * handle place
     * @param input input string
     * @param pf playField
     */
    public static void place(String input, PlayField pf) {
        final String regex = "^place ([-1]?[\\d]*);([-1]?[\\d]*)$";
        final String string = input;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            x = pf.resetXPos(x);
            y = pf.resetYPos(y);
            pf.place(x, y);
        } else {
            Terminal.printError("not a valid place number, try again");
        }
    }

    /**
     * handle bag
     * @param input input string
     * @param pf playField
     */
    public static void bag(String input, PlayField pf) {
        final String regex = "^bag$";
        final String string = input;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            pf.bag();
        }
    }

    /**
     * handle rowPrint
     * @param input input string
     * @param pf playField
     */
    public static void rowPrint(String input, PlayField pf) {
        final String regex = "^rowprint ([0-5])$";
        final String string = input;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int row = Integer.parseInt(matcher.group(1));
            pf.rowPrint(row);
        } else {
            Terminal.printError("Invalid row number, try again");
        }
    }

    /**
     * handle colPrint
     * @param input input string
     * @param pf playField
     */
    public static void colPrint(String input, PlayField pf) {
        final String regex = "^colprint ([0-5])$";
        final String string = input;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int col = Integer.parseInt(matcher.group(1));
            pf.colPrint(col);
        } else {
            Terminal.printError("Invalid col number, try again");
        }
    }
}
