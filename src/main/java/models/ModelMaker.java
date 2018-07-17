package models;

import db.DBHelper;
import models.dinosaurs.Dinosaur;
import models.humans.Visitor;

import java.util.HashMap;
import java.util.List;

public final class ModelMaker{


    public static HashMap<String, Object> makeModel(){
        Park park= DBHelper.find(Park.class,1);
        List<Dinosaur> allTheDinosaurs=DBHelper.getAll(Dinosaur.class);
        int totalDinosaurs=allTheDinosaurs.size();
        List<Visitor> allTheVisitors=DBHelper.getAll(Visitor.class);
        int totalVisitors=allTheVisitors.size();
        HashMap<String, Object> model = new HashMap<>();
        model.put("totalVisitors",totalVisitors);
        model.put("totalDinosaurs",totalDinosaurs);
        model.put("park",park);
        return model;
        }

}

