package de.fau.cs.mad.kwikshop.common;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


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


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {return address; }

    public void setAddress(String address) { this.address = address; }


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
