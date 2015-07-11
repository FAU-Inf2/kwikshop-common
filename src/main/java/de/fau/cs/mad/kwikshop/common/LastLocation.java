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
    private double latitude = 0.0;

    @DatabaseField
    private double longitude = 0.0;

    @DatabaseField
    private String address;

    @DatabaseField
    private String name;

    @DatabaseField
    private long timestamp;



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
    public String getAddress() {return address; }

    public void setAddress(String address) { this.address = address; }

	@JsonProperty
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
