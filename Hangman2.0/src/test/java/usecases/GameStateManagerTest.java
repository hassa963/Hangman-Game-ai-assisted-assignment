package usecases;
import entities.GuessedWordFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameStateManagerTest {

    @Test
    void initializeWithInvalidDifficulty() {
        GameStateManager gameStateManager = new GameStateManager(new GuessedWordFactory());
        boolean errorWasThrown = false;
       try {
           gameStateManager.initialize(4);
       }
       catch (IllegalArgumentException e){
            errorWasThrown = true;}
       assertTrue(errorWasThrown);}

    @Test
    void initializeWithValidDifficulty() {
        GameStateManager gameStateManager = new GameStateManager(new GuessedWordFactory());
        boolean errorWasThrown = true;
        try {
            gameStateManager.initialize(1);
        }
        catch (IllegalArgumentException e){
            errorWasThrown = false;}
        assertTrue(errorWasThrown);}}
