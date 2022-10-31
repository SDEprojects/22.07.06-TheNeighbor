package main.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class NeighborTest {

    @Test
    public void setLocationIndexAtMaximum() {
        Neighbor npc = new Neighbor();
        npc.pathIndex = -1;
        npc.setLocationIndex(0);
        assertEquals(20,npc.getLocationIndex());
    }

    @Test
    public void setLocationIndexAtMinimum() {
        Neighbor npc = new Neighbor();
        npc.pathIndex = 20;
        npc.setLocationIndex(0);
        assertEquals(19,npc.getLocationIndex());
    }
}