package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */
public class ResponseUnit {

    private String unitId;
    private ResourceType type;
    private UnitStatus status;

    public ResponseUnit(String unitId, ResourceType type) {
        this.unitId = unitId;
        this.type = type;
        this.status = UnitStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == UnitStatus.AVAILABLE;
    }

    public ResourceType getType() {
        return type;
    }

    public void deploy() {
        status = UnitStatus.DEPLOYED;
    }

    public void release() {
        status = UnitStatus.AVAILABLE;
    }
}

