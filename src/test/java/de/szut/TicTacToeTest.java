package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource(value = {"3, 2", "-1, 2"})
    public void erwarteExceptionTestWennXAusserhalb(final int x, final int y) {
        Exception ex = assertThrows(RuntimeException.class,
                () -> game.play(x, y));
        assertEquals("X Außerhalb des Feldes", ex.getMessage());
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource(value = {"2, 3", "2, -1"})
    public void erwarteExceptionTestWennYAusserhalb(final int x, final int y) {
        Exception ex = assertThrows(RuntimeException.class,
                () -> game.play(x, y));
        assertEquals("Y Außerhalb des Feldes", ex.getMessage(), "Test");
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource(value = {"0, 0", "1, 1", "2, 0"})
    public void erwarteExceptionTestWennFeldBelegt(final int x, final int y) {
        char board[][] = new char[][] {
            {'X', ' ', 'O'},
            {' ', 'X', ' '},
            {'X', ' ', 'O'}
        };
        Exception ex = assertThrows(RuntimeException.class,() -> game.checkIfEmpty(board, x, y));
        assertEquals("Feld ist belegt", ex.getMessage(), "Test");
    }

    @ParameterizedTest(name = "Player {0}, counter {1}")
    @CsvSource(value = {"X, 0", "O, 1", "X, 6", "O, 5"})
    public void testGetNextPlayer(final char player, final int counter) {
        assertEquals(player, game.nextPlayer(counter));
    }
}
