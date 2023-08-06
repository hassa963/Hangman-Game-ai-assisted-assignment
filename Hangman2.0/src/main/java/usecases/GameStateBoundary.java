package usecases;
import java.util.List;

/**This interface handles updating and managing the game state*/
public interface GameStateBoundary {

    /**This method returns the number of mistakes the user has made
     * @return number of mistakes the user makes*/
    int getWrongTries();

    /**This method creates a FigureModel that packages the figure that the presenter will display
     * @return the FigureModel packaging the FigureStrategy*/
    FigureModel getFigureModel();

    /**This method returns the total number of mistakes they have left tp make
     * @return  the number of tries that the user has*/
    int getNumTries();

    /**This method returns the state that the word is in so what characters are revealed or hidden
     * @return the state of what's left to guess*/
    String getGuessedWord();

    /**This method returns true if the user won the game and false otherwise
     * @return this returns true if the game was won and false if game was lost*/
    boolean isGameWon();

    /**This method initializes all that's required to set up the game state and if the difficulty choice is invaldi it
     * throws an IllegalArgumentException (this is for the sake of testing)
     * @throws IllegalArgumentException if the difficulty choice is invalid*/
    void initialize(int difficulty) throws IllegalArgumentException;

    /**This method returns true if the game has ended regardless if the user won or ran out of attempts
     * @return returns a boolean (true of the game is complete and false if game has ended */
    boolean isGameComplete();

    /**This method updates the word state and reveals the correct characters and returns true if the guess was
     * successful
     * @return returns true if the guess was correct and false otherwise*/
    boolean makeGuess(char guess);

    /**This returns the different difficulty choice options available to choose from
     * @return returns a list of strings of the names of the difficulty levels available */
    List<String> getDifficultyChoices();

    /**This method returns what the word actually should be without any of the characters hidden
     * @return a string of unveiled word*/
    String getCorrectAnswer();}
