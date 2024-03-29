package com.tessasanders.dressingselector.models.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Dressing {

    @Id
    @GeneratedValue
    private long dressingId;

    private String dressingName;

    private String drainageRequirement;

    private String thicknessRequirement;

    private String debridementRequired;

    private String frequencyAllowed;

    public long getDressingId() {
        return dressingId;
    }

    public void setDressingId(long dressingId) {
        this.dressingId = dressingId;
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


}