package controllers;

import db.DBDinosaur;
import db.DBHelper;
import db.DBPark;
import db.DBParkStaff;
import models.DinoFactory;
import models.ModelMaker;
import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.dinosaurs.Velociraptor;
import models.humans.ParkStaff;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.debug.DebugScreen.enableDebugScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinosaursController {

        public DinosaursController() {
            this.setupEndpoints();
        }

        private void setupEndpoints() {

            get("/dinosaurs", (req, res) -> {
                Map<String, Object> model = ModelMaker.makeModel();
                List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
                List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
                model.put("template", "templates/dinosaurs/index.vtl");
                model.put("dinosaurs", dinosaurs);
                model.put("paddocks", paddocks);
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());



            post ("/dinosaurs", (req, res) -> {
                String species = req.queryParams("species");
                int paddockId = Integer.parseInt(req.queryParams("paddock"));
                Paddock paddock = DBHelper.find(Paddock.class, paddockId);
                Park park = DBHelper.find(Park.class, 1);
                String name = req.queryParams("name");
                int weight = Integer.parseInt(req.queryParams("weight"));
                int price = Integer.parseInt(req.queryParams("price"));
                int bellyCapacity = Integer.parseInt(req.queryParams("bellyCapacity"));

                Dinosaur dinosaur = DinoFactory.makeDinosaur(species, name, weight, price, bellyCapacity, park, paddock);
                DBPark.buyDinosaur(park, dinosaur, paddock);

                res.redirect("/dinosaurs");
                return null;
            }, new VelocityTemplateEngine());



            get ("/dinosaurs/new", (req, res) -> {
                Map<String, Object> model = ModelMaker.makeModel();
                List<Paddock> paddocks = DBHelper.getAll(Paddock.class);

                List<String> dinosaurClasses = new ArrayList<>();
                dinosaurClasses.add("Velociraptor");
                dinosaurClasses.add("Stegosaurus");
                dinosaurClasses.add("Diplodocus");
                dinosaurClasses.add("Tyrannosaurus");

                model.put("dinosaurClasses", dinosaurClasses);
                model.put("paddocks", paddocks);
                model.put("template", "templates/dinosaurs/create.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());



            post ("/dinosaurs/:id/move", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);

                int paddockId = Integer.parseInt(req.queryParams("paddock"));
                Paddock paddock = DBHelper.find(Paddock.class, paddockId);

                ParkStaff parkStaff = DBHelper.find(ParkStaff.class, 2);

                DBParkStaff.transferDinosaur(parkStaff, dinosaur, paddock);
                res.redirect("/dinosaurs");
                return null;

            }, new VelocityTemplateEngine());



            post ("/dinosaurs/:id/eat", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);

                DBDinosaur.eat(dinosaur);
                res.redirect("/dinosaurs");
                return null;

            }, new VelocityTemplateEngine());



            post ("/dinosaurs/:id/eat/paddock", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);

                Object paddockObject = DBDinosaur.getTheDinosaursPaddock(dinosaur);
                Paddock paddock = (Paddock)paddockObject;
                int padId = paddock.getId();

                DBDinosaur.eat(dinosaur);
                res.redirect("/paddocks/"+padId);
                return null;

            }, new VelocityTemplateEngine());



            post ("/dinosaurs/:id/rampage", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);

                DBDinosaur.rampage(dinosaur);

                res.redirect("/dinosaurs");
                return null;

            }, new VelocityTemplateEngine());


            get("/dinosaurs/:id/edit", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);
                List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
                Map<String, Object> model = ModelMaker.makeModel();
                model.put("paddocks", paddocks);
                model.put("template", "templates/dinosaurs/edit.vtl");
                model.put("dinosaur", dinosaur);

                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());



            post ("/dinosaurs/:id", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);
                ParkStaff parkStaff = DBHelper.find(ParkStaff.class, 2);

                int paddockId = Integer.parseInt(req.queryParams("paddock"));
                Paddock paddock = DBHelper.find(Paddock.class, paddockId);
                String name = req.queryParams("name");
                int weight = Integer.parseInt(req.queryParams("weight"));
                int price = Integer.parseInt(req.queryParams("price"));
                int bellyCapacity = Integer.parseInt(req.queryParams("bellyCapacity"));

                dinosaur.setName(name);
                dinosaur.setWeight(weight);
                dinosaur.setPrice(price);
                dinosaur.setBellyCapacity(bellyCapacity);
                dinosaur.setPaddock(paddock);
//                DBParkStaff.transferDinosaur(parkStaff, dinosaur, paddock);
                DBHelper.saveOrUpdate(dinosaur);
                res.redirect("/dinosaurs");
                return null;

            }, new VelocityTemplateEngine());



            post ("/dinosaurs/:id/delete", (req, res) -> {
                int id = Integer.parseInt(req.params(":id"));
                Dinosaur dinosaurToDelete = DBHelper.find(Dinosaur.class, id);
                DBHelper.delete(dinosaurToDelete);
                res.redirect("/dinosaurs");
                return null;
            }, new VelocityTemplateEngine());



            get("/dinosaurs/:id", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);
                Map<String, Object> model = ModelMaker.makeModel();
                model.put("dinosaur", dinosaur);
                model.put("template", "templates/dinosaurs/show.vtl");

                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());


            enableDebugScreen();

    }

}
