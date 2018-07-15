package models.foods;


import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Food {

    private int id;
    private Park park;
    private Dinosaur dinosaur;
    private Paddock paddock;

    //Only one constructor - do we need two for DB?
    //One constructor with ID, one empty?

    public Food() {
    }
//
//    Unable to make empty constuctor

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="park_id", nullable = true)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="dinosaur_id", nullable = true)
    public Dinosaur getDinosaur() {
        return dinosaur;
    }

    public void setDinosaur(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="paddock_id", nullable = true)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }
}