package usecases;
import interfaceAdapters.*;
import java.util.List;
import java.util.Scanner;

/**This interface is responsible for the coordination of the game*/
public class HangmanInteractor implements IHangmanInteractor{
    private final HangmanOutputBoundary presenter;
    private final UserinputInterface handler;
    private final GameStateBoundary gameState;

    public HangmanInteractor(HangmanOutputBoundary presenter, UserinputInterface handler, GameStateBoundary gameState){
        this.presenter = presenter;
        this.handler = handler;
        this.gameState = gameState;}

    /**This method starts the game and coordinates the game play*/
    public void play(Scanner scanner){
        setupDifficulty(scanner);
        boolean gameOver = false;
        while (!gameOver) {
            makeTurn(scanner);
            if (gameState.isGameComplete()) {
                gameOver = true;
                presenter.displayHangman( gameState.getWrongTries());
                presenter.displayGameResult( gameState.isGameWon(), gameState.getCorrectAnswer());}}
        scanner.close();}

    /**This method is responsible for setting the difficulty level */
    private void setupDifficulty(Scanner scanner){
        List<String> difficultChoices = gameState.getDifficultyChoices();
        presenter.setDifficultyChoices(difficultChoices);
        presenter.displayWelcomeMessage();
        int difficultyChoice = handler.getValidChoice(scanner, difficultChoices.size());
        gameState.initialize(difficultyChoice);
        presenter.setHangman(gameState.getFigureModel());}

    /**This method is responsible for making a guess during the game*/
    private void makeTurn(Scanner scanner){presenter.displayHangman(gameState.getWrongTries());
        presenter.displayGameState(gameState.getGuessedWord(), gameState.getNumTries());
        char guess = handler.getGuess(scanner, presenter);
        boolean correctGuess = gameState.makeGuess(guess);
        presenter.displayGuessResult(correctGuess);}}

