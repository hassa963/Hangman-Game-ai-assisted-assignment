package interfaceAdapters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
public class UserInputHandlerTest {
    InputStream sysInBackup;
    private ByteArrayInputStream testIn;
    @BeforeEach
    public void setUp() {
        sysInBackup = System.in; // Backup original System.in
    }
    @ParameterizedTest
    @CsvSource({"A, a",
            "b, b",
            "C, c",
            "z, z"})
    public void testGetGuess_ValidInput(String input, char expected) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn); // Redirect System.in to the test input stream
        HangmanPresenter mockPresenter = mock(HangmanPresenter.class);
        UserInputHandler userInputHandler = new UserInputHandler();
        char guess = userInputHandler.getGuess(new Scanner(System.in), mockPresenter);
        assertEquals(expected, guess);}

    @ParameterizedTest
    @CsvSource({"123, b", "%, b", "def, b"}) // Update the test data here
    public void testGetGuess_InvalidInput(String input, char expected) {
        testIn = new ByteArrayInputStream(((input + "\nb")).getBytes());
        System.setIn(testIn); // Redirect System.in to the test input stream
        HangmanPresenter mockPresenter = mock(HangmanPresenter.class);
        UserInputHandler userInputHandler = new UserInputHandler();
        // Pass the Scanner object as a parameter
        char guess = userInputHandler.getGuess(new Scanner(System.in), mockPresenter);
        assertEquals(expected, guess);}

    @ParameterizedTest
    @CsvSource({"123, 2", "%, 2", "def, 2"}) // Update the test data here
    public void testInvalidDifficultyChoice(String input, int expected) {
        testIn = new ByteArrayInputStream(((input + "\n2")).getBytes());
        System.setIn(testIn); // Redirect System.in to the test input stream
        UserInputHandler userInputHandler = new UserInputHandler();
        // Pass the Scanner object as a parameter
        int guess = userInputHandler.getValidChoice(new Scanner(System.in), 3);
        assertEquals(expected, guess);}

    @ParameterizedTest
    @CsvSource({"2, 2", "1, 1", "3, 3"}) // Update the test data here
    public void testValidDifficultyChoice(String input, int expected) {
        testIn = new ByteArrayInputStream((input.getBytes()));
        System.setIn(testIn); // Redirect System.in to the test input stream
        UserInputHandler userInputHandler = new UserInputHandler();
        // Pass the Scanner object as a parameter
        int guess = userInputHandler.getValidChoice(new Scanner(System.in), 3);
        assertEquals(expected, guess);}}
