package usecases;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**This interface handles updating and managing the game state*/
public class GameStateManager implements GameStateBoundary{
    private GuessedWord guessedWord;
    private int numTries;
    private boolean gameComplete;
    private boolean gameWon;
    private int wrongTries;
    private DifficultyLevel difficultyLevel;
    private final GuessedWordFactory factory;

    public GameStateManager(GuessedWordFactory factory){this.factory =factory;}

    /**This method initializes all that's required to set up the game state and if the difficulty choice is invaldi it
     * throws an IllegalArgumentException (this is for the sake of testing)
     * @throws IllegalArgumentException if the difficulty choice is invalid*/
    public void initialize(int difficulty) throws IllegalArgumentException{
        int difficultyChoiceIndex = difficulty - 1;
        if (difficultyChoiceIndex >= 0 && difficultyChoiceIndex < DifficultyLevel.values().length) {
            DifficultyLevel selectedDifficulty = DifficultyLevel.values()[difficultyChoiceIndex];
            String wordToGuess = getRandomWord(selectedDifficulty);
            difficultyLevel = selectedDifficulty;
            guessedWord = factory.createWord(wordToGuess);
            numTries = selectedDifficulty.getMaxTries();
            wrongTries = 0;
            gameComplete = false;
            gameWon = false;
        } else {
            throw new IllegalArgumentException("Invalid difficulty choice!");}}

    /**This method returns the number of mistakes the user has made
     * @return number of mistakes the user makes*/
    public int getWrongTries(){return wrongTries;}

    /**This method creates a FigureModel that packages the figure that the presenter will display
     * @return the FigureModel packaging the FigureStrategy*/
    public FigureModel getFigureModel(){return new FigureModel(difficultyLevel.getFigureStrategy());}

    /**This method returns the total number of mistakes they have left tp make
     * @return  the number of tries that the user has*/
    public int getNumTries() {return numTries;}

    /**This method returns the state that the word is in so what characters are revealed or hidden
     * @return the state of what's left to guess*/
    public String getGuessedWord() { return guessedWord.getWord();}

    /**This method returns true if the user won the game and false otherwise
     * @return this returns true if the game was won and false if game was lost*/
    public boolean isGameWon() {return gameWon;}

    /**This method returns true if the game has ended regardless if the user won or ran out of attempts
     * @return returns a boolean (true of the game is complete and false if game has ended */
    public boolean isGameComplete() {return gameComplete;}

    /**This selects a word randomly from the difficulty level word list
     * @return this returns the word that was selected (string)*/
    private String getRandomWord(DifficultyLevel difficultyLevel) {
        List<String> wordList = difficultyLevel.getWordList();
        int randomIndex = new Random().nextInt(wordList.size());
        return wordList.get(randomIndex);}

    /**This method updates the word state and reveals the correct characters and returns true if the guess was
     * successful
     * @return returns true if the guess was correct and false otherwise*/
    public boolean makeGuess(char guess) {
        boolean correctGuess = guessedWord.makeGuess(guess);
        if (!correctGuess) {numTries--; wrongTries++;}
        if (guessedWord.isWordGuessed()) {
            gameComplete = true;
            gameWon = true;}
        else if (numTries == 0) {
            gameComplete = true;}
        return correctGuess;}

    /**This returns the different difficulty choice options available to choose from
     * @return returns a list of strings of the names of the difficulty levels available */
    public List<String> getDifficultyChoices() {
        List<String> difficultyLevels = new ArrayList<>();
        for (DifficultyLevel level : DifficultyLevel.values()) {
            difficultyLevels.add(level.name());}
        return difficultyLevels;}

    /**This method returns what the word actually should be without any of the characters hidden
     * @return a string of unveiled word*/
    public String getCorrectAnswer(){return guessedWord.getWordToGuess();}}


