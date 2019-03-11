
package com.kalelman.listurlconnection.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelWarDetail {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("attacker_king")
    @Expose
    private String attackerKing;
    @SerializedName("defender_king")
    @Expose
    private String defenderKing;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("region")
    @Expose
    private String region;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelWarDetail() {
    }

    /**
     * 
     * @param region
     * @param defenderKing
     * @param location
     * @param name
     * @param attackerKing
     */
    public ModelWarDetail(String name, String attackerKing, String defenderKing, String location, String region) {
        super();
        this.name = name;
        this.attackerKing = attackerKing;
        this.defenderKing = defenderKing;
        this.location = location;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttackerKing() {
        return attackerKing;
    }

    public void setAttackerKing(String attackerKing) {
        this.attackerKing = attackerKing;
    }

    public String getDefenderKing() {
        return defenderKing;
    }

    public void setDefenderKing(String defenderKing) {
        this.defenderKing = defenderKing;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
