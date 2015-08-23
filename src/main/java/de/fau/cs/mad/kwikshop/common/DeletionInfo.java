package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.fau.cs.mad.kwikshop.common.interfaces.DomainObject;

/**
 * Stores info about the deletion of a object
 */
public class DeletionInfo implements DomainObject {

    private int id;
    private int version;
    private int predefinedId;


    public DeletionInfo() {

    }

    public DeletionInfo(int id, int version, int predefinedId) {
        this.id = id;
        this.version = version;
        this.predefinedId = predefinedId;
    }



    /**
     * Gets the id of the object that was deleted
     */
    @Override
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    /**
     * Gets the id of the object that was deleted
     */
    @JsonProperty("id")
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the version of the object that was deleted at the time of the deletion
     */
    @JsonProperty("version")
    public int getVersion() {
        return this.version;
    }

    /**
     * Sets the version of the object that was deleted at the time of the deletion
     * @param value
     */
    @JsonProperty("version")
    public void setVersion(int value) {
        this.version = value;
    }


    @JsonProperty("predefinedId")
    @Override
    public int getPredefinedId() {
        return this.predefinedId;
    }

    public void setPredefinedId(int value) {
        this.predefinedId = predefinedId;
    }
}
