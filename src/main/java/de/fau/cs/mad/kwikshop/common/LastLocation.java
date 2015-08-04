package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

//Hibernate
@Entity(name = "Location")
@Table(name = "Location")
//ORMLite
@DatabaseTable(tableName = "location")
public class LastLocation {

    //Hibernate : ignore client id
    @Transient
    //ORMLite
    @DatabaseField(generatedId = true)
    private int id;

    //Hibernate
    @Id
    @GeneratedValue
    @Column(name = "id")
    //ORMLite
    @DatabaseField
    private int serverId;


    //Hibernate
    @Column(name = "latitude")
    //ORMLite
    @DatabaseField
    private double latitude = 0.0;

    //Hibernate
    @Column(name = "longitude")
    //ORMLite
    @DatabaseField
    private double longitude = 0.0;

    //Hibernate
    @Column(name = "address")
    //ORMLite
    @DatabaseField
    private String address;

    //Hibernate
    @Column(name = "name")
    //ORMLite
    @DatabaseField
    private String name;

    //Hibernate
    @Column(name = "timestamp")
    //ORMLite
    @DatabaseField
    private long timestamp;

    //Hibernate
    @Column(name = "accuracy")
    //ORMLite
    @DatabaseField
    private double accuracy;



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

    public double getAccuracy() { return accuracy; }

    public void setAccuracy(double accuracy) { this.accuracy = accuracy;}

    @JsonProperty("id")
    public int getServerId() {
        return this.serverId;
    }

    @JsonIgnore
    public int getId() {
        return this.id;
    }

}
