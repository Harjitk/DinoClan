package models.foods;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "plants")
public class Plant extends Food  {

    public Plant() {
    }

}
