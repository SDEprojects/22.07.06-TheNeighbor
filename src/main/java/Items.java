package main.java;

public class Items {

    private String name;
    private String description;

    //Constructor


    public Items() {
    }

    public Items(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}