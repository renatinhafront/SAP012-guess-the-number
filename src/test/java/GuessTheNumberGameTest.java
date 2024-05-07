import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.renatinhaback.ComputerPlayer;
import org.renatinhaback.GuessTheNumberGame;
import org.renatinhaback.HumanPlayer;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuessTheNumberGameTest {

    @Mock
    private ComputerPlayer mockComputerPlayer;

    @Mock
    private HumanPlayer mockHumanPlayer;

    // teste player vence
    @Test
    public void testGuessTheNumberPlayerVence() throws Exception {
        GuessTheNumberGame game = new GuessTheNumberGame(mockHumanPlayer, mockComputerPlayer);
        game.setTargetNumber(10);

        when(mockHumanPlayer.makeGuess()).thenReturn(10);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.play();

        assertTrue(outContent.toString().contains("Player venceu!"));
        outContent.close();
    }

    // teste computer vence
    @Test
    public void testGuessTheNumberComputerVence() throws IOException {
        GuessTheNumberGame game = new GuessTheNumberGame(mockHumanPlayer, mockComputerPlayer);
        game.setTargetNumber(10);

        when(mockHumanPlayer.makeGuess()).thenReturn(1);
        when(mockComputerPlayer.makeGuess()).thenReturn(10);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.play();

        assertTrue(outContent.toString().contains("Computer venceu!"));
        outContent.close();
    }

    // testar se o chute foi muito alto
    @Test
    public void testGuessTheNumberAlto() throws IOException {
        GuessTheNumberGame game = new GuessTheNumberGame(mockHumanPlayer, mockComputerPlayer);
        game.setTargetNumber(10);

        when(mockHumanPlayer.makeGuess()).thenReturn(20);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.play();

        assertTrue(outContent.toString().contains("Hummm, o chute foi alto!! \n"));
        outContent.close();
    }

    // testar se o chute foi muito baixo
    @Test
    public void testGuessTheNumberBaixo() throws IOException {
        GuessTheNumberGame game = new GuessTheNumberGame(mockHumanPlayer, mockComputerPlayer);
        game.setTargetNumber(10);

        when(mockHumanPlayer.makeGuess()).thenReturn(9);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.play();

        assertTrue(outContent.toString().contains("Haha está chutando baixo!! \n"));
        outContent.close();
    }

    // testar se o chute foi exato
    @Test
    public void testGuessTheNumberExato() throws IOException {
        GuessTheNumberGame game = new GuessTheNumberGame(mockHumanPlayer, mockComputerPlayer);
        game.setTargetNumber(10);

        when(mockHumanPlayer.makeGuess()).thenReturn(10);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.play();

        assertTrue(outContent.toString().contains("Acertou miserável!! \n"));
        outContent.close();
    }
}
