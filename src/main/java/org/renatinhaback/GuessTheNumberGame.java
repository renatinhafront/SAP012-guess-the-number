package org.renatinhaback;

import java.util.ArrayList;
import java.util.Random;

public class GuessTheNumberGame  {
    private static final Random random = new Random();
    private final Integer targetNumber = random.nextInt(1, 100);

    public void main(String[] args) {
        System.out.println("Bem vindo ao Guess the Number" + "\n");
        System.out.println(targetNumber);

        Player computerPlayer = new ComputerPlayer();
        computerPlayer.setName("Computer Player");
        computerPlayer.setGuesses(new ArrayList<>());

        Player humanPlayer = new HumanPlayer();
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
}



// cada jogador terá 5 tentativas alternando entre player e computer

// se o número gerado for MAIOR que o digitado retorna muito alto

// System.out.println("-- Round - Player --"+ "\n" + "Player: Digite seu palpite: "+ "Muito alto");

// se o número gerado for MENOR que o digitado retorna muito baixo

// quando alguem acertar

// Parabéns, você adivinhou o número!!

// Ou então Ops, não foi dessa vez. Tente outra vez!!

// guarda os números que o player digitou e retorna uma lista com as tentativas

// retorna a quantidade de tentativas
