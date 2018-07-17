package controllers;

import db.DBHelper;
import db.DBPark;
import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.dinosaurs.Velociraptor;
import models.humans.ParkStaff;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class PaddocksController {

    public PaddocksController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/paddocks", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("template", "templates/paddocks/index.vtl");
            model.put("paddocks", paddocks);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/paddocks", (req, res) -> {

            Park park = DBHelper.find(Park.class, 1);

            String name = req.queryParams("name");
            int capacity = Integer.parseInt(req.queryParams("capacity"));

            Paddock paddock = new Paddock(name, capacity, park);
            DBHelper.saveOrUpdate(paddock);
//            DBPark.addPaddock(park, paddock);

            res.redirect("/paddocks");
            return null;
        }, new VelocityTemplateEngine());

        get ("/paddocks/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);

            model.put("paddocks", paddocks);
            model.put("template", "templates/paddocks/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/paddocks/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(Paddock.class, intId);

            Map<String, Object> model = new HashMap<>();
            model.put("paddock", paddock);
            model.put("template", "templates/paddocks/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/paddocks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(Paddock.class, intId);

            String name = req.queryParams("name");
            int capacity = Integer.parseInt(req.queryParams("capacity"));

            paddock.setName(name);
            paddock.setCapacity(capacity);

            DBHelper.saveOrUpdate(paddock);
            res.redirect("/paddocks");
            return null;

        }, new VelocityTemplateEngine());

        post ("/paddocks/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Paddock paddockToDelete = DBHelper.find(Paddock.class, id);
            DBHelper.delete(paddockToDelete);
            res.redirect("/paddocks");
            return null;
        }, new VelocityTemplateEngine());

        get("/paddocks/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(Paddock.class, intId);
            List<Dinosaur> dinosaurs = paddock.getDinosaursInPaddock();

            Map<String, Object> model = new HashMap<>();

            model.put("dinosaurs", dinosaurs);
            model.put("paddock", paddock);
            model.put("template", "templates/paddocks/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}