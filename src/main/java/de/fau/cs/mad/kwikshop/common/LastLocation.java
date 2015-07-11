package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.Entity;

@Entity
@DatabaseTable(tableName = "location")
public class LastLocation {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private double latitude;

    @DatabaseField
    private double longitude;

    @DatabaseField
    private String Address;

    @DatabaseField
    private boolean visited;


    @JsonProperty
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @JsonProperty
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
