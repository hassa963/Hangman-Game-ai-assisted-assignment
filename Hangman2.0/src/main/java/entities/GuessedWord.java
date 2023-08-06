package entities;

/**This is the guessed word class that stores the state of the word as it's being guessed and what the
 * correct word is*/
public class GuessedWord {
    private final String wordToGuess;
    private final StringBuilder guessedWord;

    /**The GuessedWord class consists of the wordToGuess which is the unhidden word whereas the GuessedWord consists of
     * the state of the word as it is shown. For example at the beginning if the word grape was shown it appears as
     * -----
     * @param wordToGuess this is the word that the user is trying to guess**/
    public GuessedWord(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.guessedWord = new StringBuilder(wordToGuess.replaceAll("[a-zA-Z]", "-"));}

    /**This method updates guessedWord state if the guess is correct revealing the character to the user and will leave
     * it as if the guess is wrong and will return true or false depending on if the guess is correct
     * @param guess this is the guess that the user made
     * @return if the guess was correct it returns true otherwise it returns false*/
    public boolean makeGuess(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            char letter = wordToGuess.charAt(i);
            if (Character.toLowerCase(guess) == Character.toLowerCase(letter)) {
                guessedWord.setCharAt(i, letter);
                correctGuess = true;}}
        return correctGuess;}

    /**This returns the state of the word as it's being guessed (with successfully guessed characters being the ones
     * revealed
     * @return the state of the word*/
    public String getWord(){return guessedWord.toString();}

    /**This returns the word that was initially chosen with all characters revealed
     * @return the answer to the mystery word as a string*/
    public String getWordToGuess(){return wordToGuess;}

    /**This returns true if and only if all the letters in the word have been guessed successfully
     * @return returns true if word was guessed false otherwise*/
    public boolean isWordGuessed() {return guessedWord.toString().equalsIgnoreCase(wordToGuess);}}

