package interfaceAdapters;
import usecases.FigureModel;
import java.util.List;

/**This class involves the presentation of the messages and figures that need to be printed during the game*/
public class HangmanPresenter implements HangmanOutputBoundary{
    private List<String> difficultyChoices;
    private FigureModel hangman;


    /**This method sets the different possible difficulty levels that are options for the players so that they can be
     * presented*/
    public void setDifficultyChoices(List<String> difficultyChoices) {
        this.difficultyChoices = difficultyChoices;
    }

    /**This method sets which figure will be drawn
     * @param figure this contains which figure will get displayed during the game*/
    public void setHangman(FigureModel figure){this.hangman = figure;}

    /**This method displays the initial welcome message for the game*/
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Hangman Game!");
        System.out.println("Please choose a difficulty level:");
        displayDifficultyChoices();}

    /**This displays the message to tell the user to enter a letter*/
    public void displayEnterGuessMessage() {
        System.out.print("Enter your guess (a-z): ");
    }

    /**This displays the message for when the user entered a guess that's invalid (not a single character)*/
    public void displayInvalidInputMessage() {
        System.out.print("Invalid input. Please enter a single letter (a-z): ");}

    /**This method displays the game state, so it displays the word with the characters not guessed hidden and the
     * number of more mistakes they can make
     *  @param guessedWord this is the state of the word with the correctly guessed characters revealed
     *  @param numTries this is the number of tries that the user has left*/
    public void displayGameState(String guessedWord, int numTries) {
        System.out.println("Current Progress: " + guessedWord);
        System.out.println("Number of Tries Left: " + numTries);}

    /**This displays a message depending on whether the guess was successful or not
     * @param correctGuess this condition determines whether an incorrect or correct guess message is given
     * if it's true it means it's correct, false it means it's incorrect*/
    public void displayGuessResult(boolean correctGuess) {
        if (correctGuess) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Incorrect guess!");}}

    /**This displays the game result message, so it displays the message for whether the user has won or lost
     * @param gameWon if this is true the winning message is displayed if it's false the losing message is displayed
     * @param correct this is used to present what the right answer for the word is*/
    public void displayGameResult(boolean gameWon, String correct) {
        if (gameWon) {
            System.out.println("Congratulations! You've won!");
        } else {
            System.out.println("Game Over! You've run out of tries. The word was "+ correct + ".");}}

    /**This displays the state of the figure based on the number of mistakes the user has made
     * @param tries number of mistakes made while guessing*/
    public void displayHangman(int tries){hangman.getFigure(tries);}

    /**This displays the different difficulty levels for the user to choose from and is used in the welcome message*/
    private void displayDifficultyChoices() {
        int choiceNumber = 1;
        for (String level : difficultyChoices) {
            System.out.println(choiceNumber + ". " + level);
            choiceNumber++;}}}
