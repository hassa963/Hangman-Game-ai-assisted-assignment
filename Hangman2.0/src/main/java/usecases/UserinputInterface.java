package usecases;
import interfaceAdapters.HangmanOutputBoundary;
import java.util.Scanner;

/**This class handles receiving and validating user input*/
public interface UserinputInterface {

    /**This method gets a valid choice for the difficulty level from the user a number from 1 to
     * whatever number of difficulty levels made
     * @param maxChoice maximum number the user is allowed to input to choose a difficulty choice*/
    int getValidChoice(Scanner scanner ,int maxChoice);

    /**This method gets a VALID guess from the user *
     *@return returns the valid letter that will be used*/
    char getGuess(Scanner scanner, HangmanOutputBoundary presenter);}
