package controllers;

import db.DBHelper;
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
import static spark.Spark.post;

public class VisitorsController {
    public VisitorsController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {


        get("/visitors", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> visitors = DBHelper.getAll(Visitor.class);
            model.put("visitors", visitors);
            model.put("template", "templates/visitors/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/visitors/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<models.humans.Visitor> visitors = DBHelper.getAll(Visitor.class);

            model.put("visitors", visitors);
            model.put("template", "templates/visitors/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/visitors/new   ", (req, res) -> {
            String name = req.queryParams("name");
            int wallet = Integer.parseInt(req.queryParams("wallet"));
            Park park = DBHelper.find(Park.class, 1);
            Visitor visitor = new Visitor(name, wallet, park);
            DBHelper.saveOrUpdate(visitor);
            res.redirect("/visitors");
            return null;
        }, new VelocityTemplateEngine());


        get("/visitors/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(Visitor.class, intId);

            Map<String, Object> model = new HashMap<>();

            model.put("visitor", visitor);
            model.put("template", "templates/visitors/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/visitors/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Visitor visitor = DBHelper.find(Visitor.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/visitors/edit.vtl");
            model.put("visitor", visitor);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());





    }
}





