package models;


import javax.persistence.*;

@Entity

//@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Food implements Iedible {

//    private int id;
    private Park park;
    private Dinosaur dinosaur;
    private Paddock paddock;

    public Food() {
    }

    public void Iedible() {

    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public Dinosaur getDinosaur() {
        return dinosaur;
    }

    public void setDinosaur(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }
}

//
//
////    @Id
////    @GeneratedValue
////    @Column(name="id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
////    @Column(name="park")
//    public Park getPark() {
//        return park;
//    }
//
//    public void setPark(Park park) {
//        this.park = park;
//    }
//}