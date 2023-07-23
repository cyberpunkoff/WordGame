import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    InputReader input;
    ArrayList<Character> guessedLetters;
    private int mistakesCounter; // при количестве ошибок больше шести игра заканчивается
    private final Word word;

    Game() {
        mistakesCounter = 0;
        String wordFromDictionary = Dictionary.getWord();
        word = new Word(wordFromDictionary);
        input = new InputReader();
    }

    public void game() {
        Printer.print(word, mistakesCounter);

        while (mistakesCounter < 6 && !word.isGuessed()) {

            char letter = input.getLetter();

            try {
                if (word.checkLetter(letter)) {
                    System.out.println("Вы угадали букву!");
                } else {
                    mistakesCounter++;
                    System.out.println("Вы не угадали букву!");
                }
            } catch (LetterGuessedException exception) {
                System.out.println("Вы уже угадали эту букву!");
                continue;
            } catch (LetterGuessedWrongException exception) {
                System.out.println("Вы уже пробовали эту букву!");
            }

            Printer.print(word, mistakesCounter);
        }

        if (mistakesCounter < 6) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы проиграли!");
        }
    }

    public void begin() {
        System.out.println("----------------- ВИСЕЛЬНИЦА -----------------");
        System.out.println("Добро пожаловать в игру висельница!");
        System.out.printf("Сейчас вам будет загадано слово из %d букв%n", word.length());
        System.out.println("Вам нужно будет постараться отгадать его меньше чем за шесть ошибок!");
        System.out.println("Начнем игру!");
        game();
    }
}
