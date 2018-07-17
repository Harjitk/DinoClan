package controllers;

import db.DBFood;
import db.DBHelper;
import db.DBPark;
import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.dinosaurs.Velociraptor;
import models.foods.Food;
import models.humans.ParkStaff;
import models.humans.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ParkAdminController {

    public ParkAdminController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/parkadmin", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Park park = DBHelper.find(Park.class, 1);
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            List<Food> foodInPark = DBFood.getFoodInPark(park);
            int totalFood=foodInPark.size();

            List<Dinosaur> allTheDinosaurs=DBHelper.getAll(Dinosaur.class);
            int totalDinosaurs=allTheDinosaurs.size();

            List<Visitor> allTheVisitors=DBHelper.getAll(Visitor.class);
            int totalVisitors=allTheVisitors.size();

            model.put("template", "templates/parkadmin/index.vtl");
            model.put("paddocks", paddocks);
            model.put("dinosaurs", dinosaurs);
            model.put("park", park);
            model.put("totalVisitors",totalVisitors);
            model.put("totalDinosaurs",totalDinosaurs);
            model.put("totalFood",totalFood);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
