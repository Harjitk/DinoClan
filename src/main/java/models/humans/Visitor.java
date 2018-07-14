package models.humans;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;

import java.util.ArrayList;
import java.util.List;

public class Visitor extends Human {

    private List<Dinosaur> dinosSeen;
    private Paddock paddock;
    private Park park;


    public Visitor() {
    }

    public Visitor(String name, int wallet, Park park) {
        super(name, wallet);
        this.park = park;
        this.paddock = null;
        this.dinosSeen = new ArrayList<Dinosaur>();
    }

    public String tauntDinosaursInPaddock(){
        int taunt = 5;
        int currentHappiness;
        int newHappiness;
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()) {
            if (dinosaur.getHappiness() >= 5) {
                currentHappiness = dinosaur.getHappiness();
                newHappiness = currentHappiness -= taunt;
                dinosaur.setHappiness(newHappiness);
            } else {
                return "This dinosaur is angry as hell and looks ready to RAMPAGE";
            }
        }

        return null;
    }

    public List<Dinosaur> getDinosSeen() {
        return dinosSeen;
    }

    public void setDinosSeen(List<Dinosaur> dinosSeen) {
        this.dinosSeen = dinosSeen;
    }

    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
