package org.renatinhaback;

import java.util.ArrayList;
import java.util.Random;

public class GuessTheNumberGame  {
    private static final Random random = new Random();
    private int targetNumber = random.nextInt(1, 100);

    private final Player computerPlayer;
    private final Player humanPlayer;

    public GuessTheNumberGame(Player humanPlayer, Player computerPlayer) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
    }

    public void play() {
        System.out.println("Bem vindo ao Guess the Number" + "\n");
        System.out.println(targetNumber);

        computerPlayer.setName("Computer Player");
        computerPlayer.setGuesses(new ArrayList<>());

        humanPlayer.setName("Player");
        humanPlayer.setGuesses(new ArrayList<>());

        int contador = 0;
        while (contador < 4) {
            boolean palpiteHumanCorreto = checkGuess(humanPlayer);
            if (palpiteHumanCorreto) {
                System.out.println("Player venceu! ");
                break;
            }

            boolean palpiteComputerCorreto = checkGuess(computerPlayer);
            if (palpiteComputerCorreto) {
                System.out.println("Computer venceu! ");
                break;
            }

            contador++;
        }

        System.out.println("Sugestões: " + humanPlayer.getGuesses());
        System.out.println("Total de palpites: " + humanPlayer.getGuesses().size());
        System.out.println("By @renatinhaback ");

    }

    private boolean createValidator(int palpite) {
        if (palpite > targetNumber) {
            System.out.println("Hummm, o chute foi alto!! \n");
            return false;

        }else if (palpite < targetNumber) {
            System.out.println("Haha está chutando baixo!! \n");
            return false;

        }else {
            System.out.println("Acertou miserável!! \n");
            return true;
        }
    }

    private Boolean checkGuess(Player player) {
        System.out.println(" --- Round: --- " + player.getName());
        int palpite = player.makeGuess();
        System.out.println(player.getName()+ ", " + palpite);
        player.getGuesses().add(palpite);
        return createValidator(palpite);
    }

    public void setTargetNumber(final int targetNumber) {
        this.targetNumber = targetNumber;
    }
}
