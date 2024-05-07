package org.renatinhaback;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public Integer makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(getName() + "," + "Digite sua sugestão: ");
        String guess = scanner.nextLine();

//         verifica se ele é um numero inteiro
        while (!NumberUtils.isParsable(guess)) {
            System.out.print("Inválido, digite novamente: ");
            guess = scanner.nextLine();
        }

        return Integer.parseInt(guess);
    }
}
