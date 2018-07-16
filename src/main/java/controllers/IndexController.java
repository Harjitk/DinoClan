package controllers;

import db.Seeds;

public class IndexController {

    public static void main(String[] args) {

        DinosaursController dinosaursControllersController = new DinosaursController();
        VisitorsController visitorsController = new VisitorsController();

        Seeds.seedData();


    }

}
