package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Character {
    private List<Items> items;
    private List<Location> location;
    private String name;
    private int locationIndex = 0;

    // instantiate JSON mapper
    ObjectMapper mapper = new ObjectMapper();

    // instantiate List attributes
    {
        try {
            items = Arrays.asList(mapper.readValue(Paths.get("src/resources/items.json").toFile(), Items[].class));
            location = List.of(mapper.readValue(Paths.get("src/resources/locations.json").toFile(), Location[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
