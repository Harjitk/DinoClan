package controllers;

import db.DBDinosaur;
import db.DBHelper;
import db.DBPark;
import db.DBParkStaff;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinosaursController {

        public DinosaursController() {
            this.setupEndpoints();
        }

        private void setupEndpoints() {

            get("/dinosaurs", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
                model.put("template", "templates/dinosaurs/index.vtl");
                model.put("dinosaurs", dinosaurs);
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());


            post ("/dinosaurs", (req, res) -> {

                int paddockId = Integer.parseInt(req.queryParams("paddock"));
                Paddock paddock = DBHelper.find(Paddock.class, paddockId);
                Park park = DBHelper.find(Park.class, 1);
                String name = req.queryParams("name");
                int weight = Integer.parseInt(req.queryParams("weight"));
                int price = Integer.parseInt(req.queryParams("price"));
                int bellyCapacity = Integer.parseInt(req.queryParams("bellyCapacity"));

                Velociraptor velociraptor = new Velociraptor(name, weight, price, bellyCapacity, park, paddock);
                DBPark.buyDinosaur(velociraptor, paddock);

                res.redirect("/dinosaurs");
                return null;
            }, new VelocityTemplateEngine());


            get ("/dinosaurs/new", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                List<Paddock> paddocks = DBHelper.getAll(Paddock.class);

                model.put("paddocks", paddocks);
                model.put("template", "templates/dinosaurs/create.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

            get("/dinosaurs/:id/edit", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);
                List<Paddock> paddocks = DBHelper.getAll(Paddock.class);

                Map<String, Object> model = new HashMap<>();
                model.put("paddocks", paddocks);
                model.put("template", "templates/dinosaurs/edit.vtl");
                model.put("dinosaur", dinosaur);

                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

            post ("/dinosaurs/:id", (req, res) -> {
                String strId = req.params(":id");
                Integer intId = Integer.parseInt(strId);
                Dinosaur dinosaur = DBHelper.find(Dinosaur.class, intId);
                ParkStaff parkStaff = DBHelper.find(ParkStaff.class, 15);

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

                Map<String, Object> model = new HashMap<>();

                model.put("dinosaur", dinosaur);
                model.put("template", "templates/dinosaurs/show.vtl");

                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());





            enableDebugScreen();




    }

}
