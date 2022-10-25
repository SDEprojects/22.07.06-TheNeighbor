package main.java;

public class Items {

    private String name;
    private String image;
    private String description;
    private String location;

    //Constructor

    public Items(){

    }

    public Items(String name, String image, String description, String location) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.location = location;
    }

    //Getter and Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    //To String method


    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
