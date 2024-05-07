package org.renatinhaback;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    @Override
    public Integer makeGuess() {
        Random random = new Random();
        return random.nextInt(0, 100);
    }
}
