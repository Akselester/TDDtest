import org.junit.Test;
import ru.itsjava.Hangman;

import static org.junit.Assert.*;

public class HangmanTest {
    private Hangman game = new Hangman("sofa");

    @Test
    public void youSeeMaskedWord() {
        assertEquals("____", game.getWord());
    }

    @Test
    public void gameIsNotLostAtTheBeginning() {
        assertFalse(game.isLost());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void youMustGuessLetters() {
        game.guessLetter('o');
        assertEquals("_o__", game.getWord());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void youHaveSixGuesses() {
        game.guessLetter('x');
        game.guessLetter('y');
        game.guessLetter('z');
        game.guessLetter('u');
        game.guessLetter('t');
        assertFalse(game.isLost());
        assertEquals(5, game.getFailuresCount());
        game.guessLetter('i');
        assertTrue(game.isLost());
        assertEquals(6, game.getFailuresCount());
    }

    @Test
    public void youWinWhenYouGuessedAllLetters() {
        game.guessLetter('f');
        game.guessLetter('s');
        game.guessLetter('a');
        game.guessLetter('o');
        assertTrue(game.isWon());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void multipleClicks() {
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        assertEquals(1, game.getFailuresCount());
        assertFalse(game.isWon());
        assertFalse(game.isLost());
    }
}
