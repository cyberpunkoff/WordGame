import java.util.ArrayList;

public class Word {
    private final String word;
    private ArrayList<Character> guessedLetters;
    private ArrayList<Character> guessedWrongLetters;

    Word(String word) {
        this.word = word;
        guessedLetters = new ArrayList<Character>();
        guessedWrongLetters = new ArrayList<Character>();
    }

    public char charAt(int index) {
        return word.charAt(index);
    }

    public int length() {
        return word.length();
    }

    public String getWord() {
        return word;
    }

    public boolean isGuessed() {
        for (int i = 0; i < word.length(); i++) {
            if (!guessedLetters.contains(word.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isLetterGuessed(char letter) {
        return guessedLetters.contains(letter);
    }

    public boolean checkLetter(Character letter) throws LetterGuessedException, LetterGuessedWrongException {
        if (guessedLetters.contains(letter))
            throw new LetterGuessedException();
        if (guessedWrongLetters.contains(letter))
            throw new LetterGuessedWrongException();
        if (word.contains(letter.toString())) {
            guessedLetters.add(letter);
            return true;
        }
        guessedWrongLetters.add(letter);
        return false;
    }


}
