package models.humans;

import models.dinosaurs.Dinosaur;
import models.interfaces.Iedible;
import models.interfaces.Imeaty;

public abstract class Human implements Iedible, Imeaty {

    private String name;
    private int wallet;
    private Dinosaur dinosaur;

    public Human() {
    }

    public Human(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;

//        need to add:
//        randName method;
//        randWallet method;
    }

    public void Iedible() {

    }

    public void Imeaty() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public Dinosaur getDinosaur() {
        return dinosaur;
    }

    public void setDinosaur(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }


}
