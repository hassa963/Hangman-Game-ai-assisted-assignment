package interfaceAdapters;
import usecases.FigureModel;
import java.util.List;

/**This interface involves the presentation of the messages and figures that need to be printed during the game*/
public interface HangmanOutputBoundary {

    /**This method sets the different possible difficulty levels that are options for the players so that they can be
     * presented*/
    void setDifficultyChoices(List<String> difficultyChoices);

    /**This method displays the initial welcome message for the game*/
    void displayWelcomeMessage();

    /**This displays the state of the figure based on the number of mistakes the user has made
     * @param wrongTries number of mistakes made while guessing*/
    void displayHangman(int wrongTries);

    /**This method displays the game state, so it displays the word with the characters not guessed hidden and the
     * number of more mistakes they can make
     *  @param guessedWord this is the state of the word with the correctly guessed characters revealed
     *  @param numTries this is the number of tries that the user has left*/
    void displayGameState(String guessedWord, int numTries);

    /**This displays a message depending on whether the guess was successful or not
     * @param correctGuess this condition determines whether an incorrect or correct guess message is given
     * if it's true it means it's correct, false it means it's incorrect*/
    void displayGuessResult(boolean correctGuess);

    /**This displays the game result message, so it displays the message for whether the user has won or lost
     * @param gameWon if this is true the winning message is displayed if it's false the losing message is displayed
     * @param correct this is used to present what the right answer for the word is*/
    void displayGameResult(boolean gameWon, String correct);

    /**This displays the message to tell the user to enter a letter*/
    void displayEnterGuessMessage();

    /**This displays the message for when the user entered a guess that's invalid (not a single character)*/
    void displayInvalidInputMessage();

    /**This method sets which figure will be drawn
     * @param figureModel this contains which figure will get displayed during the game*/
    void setHangman(FigureModel figureModel);}
