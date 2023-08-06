package interfaceAdapters;
import usecases.IHangmanInteractor;

import java.util.Scanner;

/**This class is the controller which starts the game*/
public class HangmanController {

    private final IHangmanInteractor interactor;

    /**This creates an intsance of the HangmanController class that takes in an interactor that
     * coordinates the game play
     * @param interactor the interactor that coordinates the uses cases*/
    public HangmanController(IHangmanInteractor interactor) {this.interactor = interactor;}

    /**This method starts the hang man game*/
    public void startGame(Scanner scanner){interactor.play(scanner);}}
