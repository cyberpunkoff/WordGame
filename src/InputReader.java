import java.util.Scanner;

public class InputReader {
    private final Scanner inputStream;

    InputReader() {
        inputStream = new Scanner(System.in);
    }

    private static boolean isLetterCorrect(char letter) {
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        return russianAlphabet.indexOf(letter) != -1;
    }

    public char getLetter() {

        System.out.print("Введите букву: ");
        String userInput = inputStream.next().toUpperCase();

        if (userInput.length() > 1 || userInput.isBlank()) {
            System.out.println("Введите ровно одну букву!");
            return getLetter();
        }

        char letter = userInput.charAt(0);

        if (isLetterCorrect(letter))
            return letter;

        System.out.println("Введите букву русского алфавита!");
        return getLetter();

    }
}
