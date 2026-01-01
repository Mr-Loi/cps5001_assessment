package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */
public class Incident extends Node {

    private Severity severity;
    private ResourceType requiredResource;

    public Incident(String id, String name,
                    Severity severity,
                    ResourceType requiredResource) {
        super(id, name);
        this.severity = severity;
        this.requiredResource = requiredResource;
    }

    public Severity getSeverity() {
        return severity;
    }

    public ResourceType getRequiredResource() {
        return requiredResource;
    }
}

