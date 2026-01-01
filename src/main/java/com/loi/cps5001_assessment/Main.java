package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1. Create graph
        EmergencyGraph graph = new EmergencyGraph();

        // 2. Create cities
        City cityA = new City("C1", "City A");
        City cityB = new City("C2", "City B");
        City cityC = new City("C3", "City C");

        // Add cities to graph
        graph.addNode(cityA);
        graph.addNode(cityB);
        graph.addNode(cityC);

        // 3. Create dispatch centres
        DispatchCentre dispatch1 = new DispatchCentre("D1", "Dispatch Centre 1");
        dispatch1.addUnit(new ResponseUnit("U1", ResourceType.AMBULANCE));
        dispatch1.addUnit(new ResponseUnit("U2", ResourceType.FIRE_ENGINE));

        DispatchCentre dispatch2 = new DispatchCentre("D2", "Dispatch Centre 2");
        dispatch2.addUnit(new ResponseUnit("U3", ResourceType.AMBULANCE));
        dispatch2.addUnit(new ResponseUnit("U4", ResourceType.POLICE_UNIT));

        // Add dispatch centres to graph
        graph.addNode(dispatch1);
        graph.addNode(dispatch2);

        // 4. Connect cities and dispatch centres with edges (distance as weight)
        graph.addEdge(cityA, cityB, 10);
        graph.addEdge(cityB, cityC, 15);
        graph.addEdge(dispatch1, cityA, 5);
        graph.addEdge(dispatch2, cityC, 8);

        // 5. Create an incident
        Incident incident1 = new Incident("I1", "Fire at City B", Severity.HIGH, ResourceType.FIRE_ENGINE);
        graph.addNode(incident1);
        graph.addEdge(cityB, incident1, 2); // Link incident to city

        // 6. Prepare allocation manager
        AllocationManager allocator = new AllocationManager(graph);

        // 7. Dispatch units
        List<DispatchCentre> centres = Arrays.asList(dispatch1, dispatch2);
        allocator.dispatchUnit(centres, incident1);

        // 8. You can add more incidents dynamically and re-run allocation
    }
}
