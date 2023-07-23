import java.util.ArrayList;

public class Printer {
    private static final String stageZero = "---+--\n" +
            "   | |\n" +
            "     |\n" +
            "     |\n" +
            "     |\n" +
            "_____|_____\n";

    private static final String stageOne = "---+--\n" +
            "  *| |\n" +
            "     |\n" +
            "     |\n" +
            "     |\n" +
            "_____|_____\n";

    private static final String stageTwo = "---+--\n" +
            "  *| |\n" +
            "  |  |\n" +
            "  |  |\n" +
            "     |\n" +
            "_____|_____\n";

    private static final String stageThree = "---+--\n" +
            "  *| |\n" +
            " /|  |\n" +
            "  |  |\n" +
            "     |\n" +
            "_____|_____\n";

    private static final String stageFour = "---+--\n" +
            "  *| |\n" +
            " /|\\ |\n" +
            "  |  |\n" +
            "     |\n" +
            "_____|_____\n";

    private static final String stageFive = "---+--\n" +
            "  *| |\n" +
            " /|\\ |\n" +
            "  |  |\n" +
            " /   |\n" +
            "_____|_____\n";

    private static final String stageSix = "---+--\n" +
            "  *| |\n" +
            " /|\\ |\n" +
            "  |  |\n" +
            " / \\ |\n" +
            "_____|_____\n";

    private static final String[] gameStages = {stageZero, stageOne, stageTwo, stageThree, stageFour, stageFive, stageSix};

    public static int print(int mistakesCounter, String word, ArrayList<Character> guessedLetters) {

        int printedLetters = 0;

        System.out.println(gameStages[mistakesCounter]);

        for (int i = 0; i < word.length(); i++) {
            System.out.print("+-+ ");
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("|");
            if (guessedLetters.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                printedLetters++;
            } else {
                System.out.print(" ");
            }
            System.out.print("| ");
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("+-+ ");
        }
        System.out.println();

        return printedLetters;
    }
}
