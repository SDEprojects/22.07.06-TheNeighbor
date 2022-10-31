package main.java;

import java.util.ArrayList;
import java.util.List;

class PlayerGoodies {

    List<String> inventory = new ArrayList<>();

    public List<String> getInventory() {
        return inventory;
    }

    private void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

}
