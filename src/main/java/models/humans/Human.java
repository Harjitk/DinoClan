package models.humans;

import models.Park;
import models.interfaces.Iedible;
import models.interfaces.Imeaty;

import java.util.*;

public abstract class Human implements Iedible, Imeaty {

    private String name;
    private int wallet;
    private List<String> firstNames;
    private List<String> lastNames;

    public Human() {
    }

    public Human(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
        this.firstNames = new ArrayList<String>();
        this.lastNames = new ArrayList<String>();

        firstNames.add("Harjit"); firstNames.add("Richard"); firstNames.add("John"); firstNames.add("Steve"); firstNames.add("Louise"); firstNames.add("Colin"); firstNames.add("Cleyra"); firstNames.add("Stephan"); firstNames.add("Adri"); firstNames.add("Angelina"); firstNames.add("Campbell"); firstNames.add("Craig"); firstNames.add("Debi"); firstNames.add("Derek"); firstNames.add("Farheen"); firstNames.add("Greg"); firstNames.add("Jack"); firstNames.add("Joe"); firstNames.add("Matt"); firstNames.add("Pete"); firstNames.add("Roddy"); firstNames.add("Steven"); firstNames.add("Tara");

        lastNames.add("Singh"); lastNames.add("Phillips-Kerr"); lastNames.add("McCollum"); lastNames.add("Meiklejohn"); lastNames.add("Reid"); lastNames.add("Bell"); lastNames.add("Blyth"); lastNames.add("Miller"); lastNames.add("McDowell"); lastNames.add("Skea"); lastNames.add("Leach"); lastNames.add("Murning"); lastNames.add("Bonner");

    }


    public String randName(){
        String finalName;
        Collections.shuffle(firstNames);
        Collections.shuffle(lastNames);
       finalName = firstNames.get(0) + " " + lastNames.get(0);
       return finalName;
    }

    public int randWallet(){
        Random ran = new Random();
        int x = ran.nextInt(1000) + 2000;
        return x;
    }


    public void Iedible() {

    }

    public void Imeaty() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }


}
