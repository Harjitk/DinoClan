package controllers;

import db.DBHelper;
import db.Seeds;
import models.dinosaurs.Dinosaur;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class DinosaursController {

    public static void main(String[] args) {

        Seeds.seedData();

        get("/dinosaurs", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            model.put("dinosaur", dinosaurs);
            model.put("template", "templates/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/templates/dinosaur/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            model.put("dinosaurs", dinosaurs);
            model.put("template", "templates/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
