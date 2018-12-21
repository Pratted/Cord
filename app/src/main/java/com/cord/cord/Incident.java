package com.example.eric.helloworld;



public class Incident {
    protected String incidentType;
    protected String location;
    protected String activeSince;
    protected String owners;
    protected String status;
    protected String description;

    public Incident(String incidentType, String location, String activeSince){
        this.incidentType = incidentType;
        this.location = location;
        this.activeSince = activeSince;
    }

    public Incident(String incidentType, String location, String activeSince, String owners, String status, String description) {
        this.incidentType = incidentType;
        this.location = location;
        this.activeSince = activeSince;
        this.owners = owners;
        this.status = status;
        this.description = description;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setActiveSince(String activeSince) {
        this.activeSince = activeSince;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}