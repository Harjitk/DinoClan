package models.humans;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="visitors")

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

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "dinoDex",
    joinColumns = {@JoinColumn(name = "visitor_id", nullable = false, updatable = false)},
  inverseJoinColumns = {@JoinColumn(name = "dinosaur_id", nullable = false, updatable = false)})
    public List<Dinosaur> getDinosSeen() {
        return dinosSeen;
    }

    public void setDinosSeen(List<Dinosaur> dinosSeen) {
        this.dinosSeen = dinosSeen;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paddock_id", nullable = true)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
