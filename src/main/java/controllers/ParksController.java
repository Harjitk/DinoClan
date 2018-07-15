package controllers;

import db.DBHelper;
import db.Seeds;
import models.Park;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class ParksController {

    public static void main(String[] args) {

        Seeds.seedData();

        get("/parks", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("parks", parks);
            model.put("template", "templates/parks/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
