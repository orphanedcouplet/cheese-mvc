package org.launchcode.cheesemvc.models;

public class Cheese {
    private String name;
    private String description;

    public Cheese(String aName, String aDescription) {
        this.name = aName;
        this.description = aDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

}
