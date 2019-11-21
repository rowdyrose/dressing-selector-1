package com.tessasanders.dressingselector.models;

public class DressingData {

    private int dressingID;

    private String dressingName;

    private String drainageRequirement;

    private String thicknessRequirement;

    private String debridementRequired;

    public int getDressingID() {
        return dressingID;
    }

    public void setDressingID(int dressingID) {
        this.dressingID = dressingID;
    }

    public String getDressingName() {
        return dressingName;
    }

    public void setDressingName(String dressingName) {
        this.dressingName = dressingName;
    }

    public String getDrainageRequirement() {
        return drainageRequirement;
    }

    public void setDrainageRequirement(String drainageRequirement) {
        this.drainageRequirement = drainageRequirement;
    }

    public String getThicknessRequirement() {
        return thicknessRequirement;
    }

    public void setThicknessRequirement(String thicknessRequirement) {
        this.thicknessRequirement = thicknessRequirement;
    }

    public String getDebridementRequired() {
        return debridementRequired;
    }

    public void setDebridementRequired(String debridementRequired) {
        this.debridementRequired = debridementRequired;
    }

    public String getFrequencyAllowed() {
        return frequencyAllowed;
    }

    public void setFrequencyAllowed(String frequencyAllowed) {
        this.frequencyAllowed = frequencyAllowed;
    }

    private String frequencyAllowed;

}


