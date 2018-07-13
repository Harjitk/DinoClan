package models;


import javax.persistence.*;

@Entity

//@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Food implements Iedible {

//    private int id;
//    private Park park;

    public Food() {
    }

    public void Iedible() {

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
