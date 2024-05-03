package org.renatinhaback;

import java.util.ArrayList;


public abstract class Player {

    private String name;
    protected ArrayList<Integer> guesses;

    public abstract Integer makeGuess ();

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getGuesses() {
        return this.guesses;
    }
    public void setGuesses(ArrayList<Integer> guesses) {
        this.guesses = guesses;
    }
}
