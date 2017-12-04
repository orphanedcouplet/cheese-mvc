package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<Cheese> fromages = new ArrayList<>();

    // getAll
    public static ArrayList<Cheese> getAll() {
        return fromages;
    }

    // add
    public static void add(Cheese nouveauFromage) {
        fromages.add(nouveauFromage);
    }

    // remove
    public static void remove(int id) {
        Cheese fromageASupprimer = getById(id);
        fromages.remove(fromageASupprimer);
    }

    // getById
    public static Cheese getById(int id) {
        Cheese theCheese = null;

        for (Cheese candidateCheese : fromages) {
            if (candidateCheese.getId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

}
