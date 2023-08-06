package interfaceAdapters;
import usecases.UserinputInterface;
import java.util.Scanner;

/**This class handles receiving and validating user input*/
public class UserInputHandler implements UserinputInterface {

    /**This method gets a valid choice for the difficulty level from the user a number from 1 to
     * whatever number of difficulty levels made
     * @param maxChoice maximum number the user is allowed to input to choose a difficulty choice*/
    public int getValidChoice(Scanner scanner, int maxChoice) {
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {System.out.print("Enter your choice: ");
            try {choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > maxChoice) {
                    System.out.println("Invalid input. Please enter a valid choice.");
                } else {validInput = true;}
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");}}
        return choice;}

    /**This method gets a VALID guess from the user *
     *@return returns the valid letter that will be used*/
    @Override
    public char getGuess(Scanner scanner, HangmanOutputBoundary presenter) {
        presenter.displayEnterGuessMessage();
        String input = scanner.nextLine().toLowerCase();
        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            presenter.displayInvalidInputMessage();
            input = scanner.nextLine().toLowerCase();}
        return input.charAt(0);}}


