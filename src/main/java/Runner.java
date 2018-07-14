import db.DBHelper;
import models.foods.Meat;
import models.foods.Plant;

public class Runner {

    public static void main(String[] args) {

        Meat meat = new Meat();
        DBHelper.saveOrUpdate(meat);

        Plant plant = new Plant();
        DBHelper.saveOrUpdate(plant);


    }
}
