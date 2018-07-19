package controllers;

import db.*;
import models.ModelMaker;
import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.dinosaurs.Velociraptor;
import models.foods.Food;
import models.humans.ParkStaff;
import models.humans.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
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

            Map<String, Object> model = ModelMaker.makeModel();
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
            Map<String, Object> model = ModelMaker.makeModel();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("paddocks", paddocks);
            model.put("template", "templates/paddocks/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        post ("/paddocks/:id/addfood", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);

            Paddock paddock = DBHelper.find(Paddock.class, intId);
            Park park = DBHelper.find(Park.class, 1);
            List<Food> foodStock = DBFood.getFoodInPark(park);
            ParkStaff parkStaff = DBHelper.find(ParkStaff.class, 2);

            DBParkStaff.addFoodToStore(park, parkStaff, paddock);
            res.redirect("/paddocks");
            return null;

        }, new VelocityTemplateEngine());



        post ("/paddocks/:id/taunt", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(Paddock.class, intId);

            Object visitorObj = DBPaddock.getFirstVisitorsInPaddock(paddock);
            Visitor visitor = (Visitor)visitorObj;

            DBVisitor.tauntDinosaursInPaddock(visitor);
            res.redirect("/paddocks/"+strId);
            return null;

        }, new VelocityTemplateEngine());


        post ("/paddocks/:id/calm", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(Paddock.class, intId);

            ParkStaff parkStaff = DBHelper.find(ParkStaff.class, 2);

            DBParkStaff.calmDinosaursInPaddock(parkStaff, paddock);
            res.redirect("/paddocks/"+strId);
            return null;

        }, new VelocityTemplateEngine());


        get("/paddocks/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Paddock paddock = DBHelper.find(Paddock.class, intId);
            Map<String, Object> model = ModelMaker.makeModel();
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
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            List<Dinosaur> dinosaurs = paddock.getDinosaursInPaddock();
            List<Visitor> visitors = paddock.getVisitorsInPaddock();
            Map<String, Object> model = ModelMaker.makeModel();
            model.put("dinosaurs", dinosaurs);
            model.put("paddocks", paddocks);
            model.put("paddock", paddock);
            model.put("visitors", visitors);
            model.put("template", "templates/paddocks/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
