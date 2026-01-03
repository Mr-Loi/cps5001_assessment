package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */
import java.util.ArrayList;
import java.util.List;

public class DispatchCentre extends Node {

    private List<ResponseUnit> units;

    public DispatchCentre(String id, String name) {
        super(id, name);
        this.units = new ArrayList<>();
    }

    public void addUnit(ResponseUnit unit) {
        units.add(unit);
    }

    // Checks to see if there is an available unit
    public List<ResponseUnit> getAvailableUnits(ResourceType type) {
        List<ResponseUnit> available = new ArrayList<>();
        for (ResponseUnit unit : units) {
            if (unit.isAvailable() && unit.getType() == type) {
                available.add(unit);
            }
        }
        return available;
    }
}

