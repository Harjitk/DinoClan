package controllers;

import db.Seeds;

public class IndexController {

    public static void main(String[] args) {

        DinosaursController dinosaursControllersController = new DinosaursController();

        Seeds.seedData();


    }

}
