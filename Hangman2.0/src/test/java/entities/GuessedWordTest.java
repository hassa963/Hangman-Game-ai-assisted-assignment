package entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class GuessedWordTest {

    @Test
    void testTrueAndFalseMakeGuess() { GuessedWord word = new GuessedWord("theatre");
        assertTrue(word.makeGuess('a'));
        assertFalse(word.makeGuess('x'));
        assertEquals("---a---", word.getWord());}

    @Test
    void isWordGuessed() {GuessedWord word = new GuessedWord("hater");
        assertEquals("-----", word.getWord());
        assertFalse(word.isWordGuessed());
        word.makeGuess('h'); word.makeGuess('a'); word.makeGuess('t'); word.makeGuess('e');
        word.makeGuess('r');
        assertTrue(word.isWordGuessed());}}