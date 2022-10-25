package main.java;

import java.util.List;

public class Location {

    private String name;
    private String description;
    private Exit exit;

    //Constructors

    public Location() {
    }

    public Location(String name, String description, Exit exit) {
        this.name = name;
        this.description = description;
        this.exit = exit;
    }

    //Getters ans setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exit getExit() {
        return exit;
    }

    public void setExit(Exit exit) {
        this.exit = exit;
    }

    //To string method

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exit=" + exit +
                '}';
    }
}
