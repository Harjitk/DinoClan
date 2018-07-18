package models;

import models.dinosaurs.*;

public class DinoFactory {

    public static Dinosaur makeDinosaur(String classType, String name, int weight, int price, int bellyCapacity, Park park, Paddock paddock){
        Dinosaur result = null;
        switch(classType){
            case "Velociraptor":
                result = new Velociraptor(name, weight, price, bellyCapacity, park, paddock);
                break;

            case "Tyrannosaurus":
                result = new Tyrannosaurus(name, weight, price, bellyCapacity, park, paddock);
                break;

            case "Stegosaurus":
                result = new Stegosaurus(name, weight, price, bellyCapacity, park, paddock);
                break;

            case "Diplodocus":
                result = new Diplodocus(name, weight, price, bellyCapacity, park, paddock);
                break;

        }
        return result;

    }


}
