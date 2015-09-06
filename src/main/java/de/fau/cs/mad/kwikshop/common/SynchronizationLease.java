package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.fau.cs.mad.kwikshop.common.serialization.DateDeserializer;
import de.fau.cs.mad.kwikshop.common.serialization.DateSerializer;
import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

import javax.persistence.*;

import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.SYNCHRONIZATIONLEASE_GET_ALL_FOR_USER,
                query = "SELECT l FROM SynchronizationLease l WHERE l.userId = :" + NamedQueryConstants.USER_ID
        ),
        @NamedQuery(
                name = NamedQueryConstants.SYNCHRONIZATIONLEASE_GET_BY_ID,
                query = "SELECT l FROM SynchronizationLease l WHERE l.id = :" + NamedQueryConstants.SYNCHRONIZATIONLEASE_ID
        ),
        @NamedQuery(
                name = NamedQueryConstants.SYNCHRONIZATIONLEASE_GET_BY_ID_AND_OWNER,
                query = "SELECT l FROM SynchronizationLease l WHERE l.userId = :" + NamedQueryConstants.USER_ID +
                        " AND l.id = :" + NamedQueryConstants.SYNCHRONIZATIONLEASE_ID
        )
})
public class SynchronizationLease {

    @Column
    @Id
    private int id;

    @Column
    private String clientId;

    @Column
    private String userId;

    @Column
    private Date expirationTime;


    @JsonProperty
    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    @JsonIgnore
    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String value){
        this.clientId = value;
    }

    @JsonProperty
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String value) {
        this.userId = value;
    }

    @JsonProperty
    @JsonSerialize(using = DateSerializer.class)
    public Date getExpirationTime() {
        return expirationTime;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public void setExpirationTime(Date value) {
        this.expirationTime = value;
    }
}
