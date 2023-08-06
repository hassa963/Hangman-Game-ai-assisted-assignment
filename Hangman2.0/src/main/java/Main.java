import entities.GuessedWordFactory;
import interfaceAdapters.HangmanController;
import interfaceAdapters.HangmanPresenter;
import interfaceAdapters.UserInputHandler;
import usecases.GameStateManager;
import usecases.HangmanInteractor;

import java.util.Scanner;

/**This main setups the different components for the game*/
public class Main {
    public static void main(String[] args) {
        HangmanPresenter presenter = new HangmanPresenter();
        GameStateManager gameStateManager = new GameStateManager(new GuessedWordFactory());
        UserInputHandler userInputHandler = new UserInputHandler();
        HangmanInteractor interactor = new HangmanInteractor(presenter, userInputHandler, gameStateManager);
        HangmanController controller = new HangmanController(interactor);
        controller.startGame(new Scanner(System.in));}}
