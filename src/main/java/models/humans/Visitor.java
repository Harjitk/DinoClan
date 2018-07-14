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

    public void tauntDinosaursInPaddock(){
        int taunt = 5;
        int currentHappiness;
        int newHappiness;
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()){
            currentHappiness = dinosaur.getHappiness();
            newHappiness = currentHappiness -= taunt;
            dinosaur.setHappiness(newHappiness);
        }
    }

//MANY TO MANY??
//    @Cascade(CascadeType.SAVE_UPDATE)
//    @ManyToMany
//    @JoinTable(name = "Visitor_DinoSeen",
//    joinColumns = {@JoinColumn(name = "visitor_id", nullable = false, updatable = false)},
//  inverseJoinColumns = {@JoinColumn(name = "dinosaur_id", nullable = false, updatable = false)})

    public List<Dinosaur> getDinosSeen() {
        return dinosSeen;
    }

    public void setDinosSeen(List<Dinosaur> dinosSeen) {
        this.dinosSeen = dinosSeen;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paddock_id", nullable = true)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
