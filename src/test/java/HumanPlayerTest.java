import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.renatinhaback.HumanPlayer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HumanPlayerTest {

    @Test
    public void testHumanPlayer() {
        HumanPlayer humanPlayer = new HumanPlayer();
        provideInput("3");
        int guess = humanPlayer.makeGuess();

        Assertions.assertEquals(3, guess);
    }

    @Test
    public void testHumanPlayerWhenInputNotNumber() {
        HumanPlayer humanPlayer = new HumanPlayer();
        provideInput("a\n3");
        int guess = humanPlayer.makeGuess();

        Assertions.assertEquals(3, guess);
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
