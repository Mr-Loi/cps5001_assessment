package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */
import java.util.*;

public class AllocationManager {

    private EmergencyGraph graph;

    public AllocationManager(EmergencyGraph graph) {
        this.graph = graph;
    }

    public void dispatchUnit(List<DispatchCentre> centres, Incident incident) {

        DispatchCentre bestCentre = null;
        ResponseUnit bestUnit = null;
        double bestScore = Double.MAX_VALUE;

        for (DispatchCentre centre : centres) {

            List<ResponseUnit> available =
                    centre.getAvailableUnits(incident.getRequiredResource());

            if (available.isEmpty()) continue;

            Map<Node, Double> distances = graph.dijkstra(centre);
            double distance = distances.getOrDefault(incident, Double.MAX_VALUE);

            double severityWeight = incident.getSeverity().ordinal() + 1;
            double score = distance * severityWeight;

            if (score < bestScore) {
                bestScore = score;
                bestCentre = centre;
                bestUnit = available.get(0);
            }
        }

        if (bestUnit != null) {
            bestUnit.deploy();
            System.out.println("Dispatched " + bestUnit.getType() +
                    " from " + bestCentre.getName() +
                    " to incident " + incident.getName());
        } else {
            System.out.println("No available unit for incident " + incident.getName());
        }
    }
    
    public void releaseUnit(ResponseUnit unit) {
        unit.release();
    }

}

