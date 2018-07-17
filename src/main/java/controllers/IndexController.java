package controllers;

import db.DBHelper;
import db.DBPark;
import db.Seeds;
import models.ModelMaker;
import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.humans.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class IndexController {

    public static void main(String[] args) {

        DinosaursController dinosaursControllersController = new DinosaursController();
        VisitorsController visitorsController = new VisitorsController();
        PaddocksController paddocksController = new PaddocksController();
        ParkAdminController parkAdminController = new ParkAdminController();

        Seeds.seedData();

        get ("/index", (req, res) -> {
            Map<String, Object> model = ModelMaker.makeModel();
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



//                add in get path for park.getTill
//                add in get path for get.Visitors.size()- links to visitor
//                add in get path for get.Dinosaurs.size()- links to dinosaurs



    }

}
