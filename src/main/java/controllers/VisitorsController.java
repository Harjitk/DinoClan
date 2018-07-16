package controllers;

import db.DBHelper;
import models.dinosaurs.Dinosaur;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import sun.reflect.generics.visitor.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class VisitorsController {
        public VisitorsController() {
            this.setupEndpoints();
        }

    private void setupEndpoints() {


        get("/visitors", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<models.humans.Visitor> visitors = DBHelper.getAll(Visitor.class);
            model.put("visitor", visitors);
            model.put("template", "templates/Visitors/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }




}
