import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private int mistakesCounter; // при количестве ошибок больше шести игра заканчивается

    private Word word;

    InputReader input;
    ArrayList<Character> guessedLetters;


    Game() {

        mistakesCounter = 0;

        String wordFromDictionary = Dictionary.getWord();
        word = new Word(wordFromDictionary);


        input = new InputReader();
    }

    public void game() {


        Printer.print(word);

        while (mistakesCounter < 6 && !word.isGuessed()) {

            char letter = input.getLetter();

            try {
                if (word.checkLetter(letter)) {
                    System.out.println("Вы угадали букву!");
                } else {
                    mistakesCounter++;
                    System.out.println("Вы не угадали букву!");
                }
            } catch (LetterGuessedException) {
                System.out.println("Вы уже угадали эту букву!");
                continue;
            }

            Printer.print(word);
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
