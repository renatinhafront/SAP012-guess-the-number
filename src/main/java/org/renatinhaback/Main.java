package org.renatinhaback;

public class Main {
    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame(new HumanPlayer(), new ComputerPlayer());
        game.play();
    }
}
