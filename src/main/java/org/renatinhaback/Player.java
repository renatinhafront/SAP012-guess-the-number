package org.renatinhaback;

import java.util.ArrayList;


public abstract class Player {

    private String name;
    private ArrayList<Integer> guesses;

    public abstract Integer makeGuess ();

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getGuesses() {
        return this.guesses;
    }
}
