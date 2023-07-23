import java.util.ArrayList;

public class Word {
    private final String word;

    private ArrayList<Character> guessedLetters;

    Word(String word) {
        this.word = word;
        guessedLetters = new ArrayList<Character>();
    }

    public boolean isGuessed() {
        for (int i = 0; i < word.length(); i++) {
            if (!guessedLetters.contains(word.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean checkLetter(Character letter) throws LetterGuessedException {
        if (guessedLetters.contains(letter))
            throw new LetterGuessedException();
        if (word.contains(letter.toString())) {
            guessedLetters.add(letter);
            return true;
        }
        return false;
    }


}
